package com.wishlist.auth.controllers;

import com.wishlist.auth.dtos.AddRoleToUserForm;
import com.wishlist.auth.dtos.UserDto;
import com.wishlist.auth.models.TRole;
import com.wishlist.auth.models.TUser;
import com.wishlist.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("users/save")
    public ResponseEntity<List<UserDto>> createUser(@RequestBody TUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/save").toUriString());
        return ResponseEntity.created(uri).body(userService.getUsers());
    }
    @PostMapping("roles/save")
    public ResponseEntity<List<UserDto>> createRole(@RequestBody TRole role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/roles/save").toUriString());
        return ResponseEntity.created(uri).body(userService.getUsers());
    }

    @PostMapping("add-role-to-user")
    public ResponseEntity<?> addRoleToUser(@RequestBody AddRoleToUserForm request) {
        userService.addRoleToUser(request.getUsername(), request.getRole());
        return ResponseEntity.ok().build();
    }
}
