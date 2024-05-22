package com.wishlist.auth.services;

import com.wishlist.auth.dtos.CustomUserDetails;
import com.wishlist.auth.models.TUser;
import com.wishlist.auth.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepo;
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        userRepo = userRepository;
    }
    /**
     * @param phoneNumber
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        TUser tUser = userRepo.findByStrPhoneNumber(phoneNumber);
        if(tUser == null) {
            log.info("No user with phone number {} found", phoneNumber);
            return null;
        }
        log.info("User obtained {}", tUser);
        return new CustomUserDetails(tUser);
    }
}
