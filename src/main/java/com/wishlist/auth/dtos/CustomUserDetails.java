package com.wishlist.auth.dtos;

import com.wishlist.auth.models.TUser;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;


public class CustomUserDetails extends User {


    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
    public CustomUserDetails(TUser tUser) {
        super(tUser.getStrPhoneNumber(), tUser.getStrPassword(), true, true, true, true, tUser.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getStrName())).collect(Collectors.toList()));
    }
}
