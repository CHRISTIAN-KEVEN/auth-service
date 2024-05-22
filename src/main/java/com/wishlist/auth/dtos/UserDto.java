package com.wishlist.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private long id;
    private String name;
    private String username;
    private  String password;
    private String phoneNumber;
    private String sex;
    private String imageUrl;
    private String token;
}
