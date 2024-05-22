package com.wishlist.auth.repositories;

import com.wishlist.auth.models.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<TUser, Long> {
    TUser findByStrPhoneNumber(@Param("strPhoneNumber") String phoneNumber);

}
