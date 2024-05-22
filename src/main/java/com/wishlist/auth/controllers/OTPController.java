package com.wishlist.auth.controllers;

import com.wishlist.auth.dtos.VerifyOTPRequest;
import com.wishlist.auth.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class OTPController {

    private final UserService userService;

    public OTPController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/send-otp")
    public ResponseEntity<String> generateAndSendOTP(@RequestBody String phoneNumber) {
        return ResponseEntity.ok(userService.generateAndSendOTP(phoneNumber));
    }
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOTP(@RequestBody VerifyOTPRequest verifyOTPRequest) {
        return ResponseEntity.ok(userService.verifyOTP(verifyOTPRequest));
    }
}
