package com.wishlist.auth.services;

import com.wishlist.auth.dtos.*;
import com.wishlist.auth.models.TRole;
import com.wishlist.auth.models.TUser;
import com.wishlist.auth.repositories.RoleRepository;
import com.wishlist.auth.repositories.UserRepository;
import com.wishlist.auth.utilities.Utilities;
import com.wishlist.auth.utilities.Utils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final RedisService redisService;
    private final JwtUtilService jwtUtilService;

    /**
     * @param user
     * @return
     */
    @Override
    public UserDto createUser(TUser user) {

        TUser savedUser = userRepo.save(user);
        return Utils.mapUserToDto(savedUser);
    }

    /**
     * @param role
     * @return
     */
    @Override
    public RoleDto createRole(TRole role) {
        TRole savedRole = roleRepo.save(role);
        return Utils.mapRoleToDto(role);
    }

    /**
     * @param phoneNumber
     * @param roleName
     */
    @Override
    public void addRoleToUser(String phoneNumber, String roleName) {
        log.info("Adding role {} to user {}", roleName, phoneNumber);
        TUser user = userRepo.findByStrPhoneNumber(phoneNumber);
        Optional<TRole> optRole = roleRepo.findByStrName(roleName);
//        if(optRole.isPresent()) {
//            user.getRoles().add(optRole.get());
////            userRepo.save(user);
//        }
    }

    /**
     * @param phoneNumber
     * @return
     */
    @Override
    public UserDto getUser(String phoneNumber) {
        log.info("Fetching user {}", phoneNumber);
        return Utils.mapUserToDto(userRepo.findByStrPhoneNumber(phoneNumber));
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll().stream().map(Utils::mapUserToDto).collect(Collectors.toList());
    }

    /**
     * @param phoneNumber
     * @return
     */
    @Override
    public String generateAndSendOTP(String phoneNumber) {

        String otp = generateOTP() + "";

        // Save OTP
        redisService.setValue(phoneNumber, otp);
        // Send OTP
        return Utilities.dataReturn(otp);

    }

    /**
     * @param verifyOTPRequest
     * @return
     */
    @Override
    public String verifyOTP(VerifyOTPRequest verifyOTPRequest) {
        if(verifyOTPRequest == null) return null;
       try {
           String userPhoneNumber = verifyOTPRequest.getPhone();
           String storedOtp = (String) redisService.getValue(userPhoneNumber);
           AuthenticationResponseDto resp = new AuthenticationResponseDto();

           TUser tUser = null;
           if(storedOtp !=null && storedOtp.equals(verifyOTPRequest.getOtp())) {
               // Check if user already has an account
               tUser = userRepo.findByStrPhoneNumber(userPhoneNumber);
               if(tUser == null) {
                   // Create Account
                   tUser = new TUser();
                   tUser.setStrPhoneNumber(userPhoneNumber);
                   this.createUser(tUser);
               }

               resp.setAccessToken(jwtUtilService.generateToken(new CustomUserDetails(tUser)));

               return Utilities.dataReturn(resp);
           }
           else {
               return Utilities.errorMessageReturn("Invalid OTP !");
           }
       } catch (Exception ex) {
           log.error("Failed to verify OTP ", ex);
           return Utilities.errorMessageReturn("Your OTP could not be verified.Try again later");
       }
    }

    public int generateOTP() {
        Random random = new Random();
        int otp = 100_000 + random.nextInt(900_000);
        return otp;
    }
}
