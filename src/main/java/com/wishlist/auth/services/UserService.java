package com.wishlist.auth.services;

import com.wishlist.auth.dtos.RoleDto;
import com.wishlist.auth.dtos.UserDto;
import com.wishlist.auth.dtos.VerifyOTPRequest;
import com.wishlist.auth.models.TRole;
import com.wishlist.auth.models.TUser;

import java.util.List;


public interface UserService {

    public UserDto createUser(TUser user);
    RoleDto createRole(TRole role);
    void addRoleToUser(String username, String roleName);
    UserDto getUser(String username);
    List<UserDto> getUsers();

    String generateAndSendOTP(String phoneNumber);

    String verifyOTP(VerifyOTPRequest verifyOTPRequest);
}
