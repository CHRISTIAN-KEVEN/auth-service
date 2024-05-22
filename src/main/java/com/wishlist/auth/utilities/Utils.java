package com.wishlist.auth.utilities;

import com.wishlist.auth.dtos.RoleDto;
import com.wishlist.auth.dtos.UserDto;
import com.wishlist.auth.models.TRole;
import com.wishlist.auth.models.TUser;

public class Utils {
    public static UserDto mapUserToDto(TUser user) {
        if(user == null)
            return null;
        UserDto dto = new UserDto();
        dto.setId(user.getLgId());
        dto.setName(user.getStrName());
        dto.setSex(user.getStrSex());
        dto.setImageUrl(user.getStrImageUrl());
        dto.setUsername(user.getStrUsername());
        dto.setPhoneNumber(user.getStrPhoneNumber());

        return dto;
    }

    public static RoleDto mapRoleToDto(TRole role) {
        if(role == null)
            return null;
        RoleDto dto = new RoleDto();
        dto.setId(role.getLgId());
        dto.setName(role.getStrName());

        return dto;
    }
}
