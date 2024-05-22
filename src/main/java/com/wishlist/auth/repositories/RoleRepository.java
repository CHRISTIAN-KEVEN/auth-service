package com.wishlist.auth.repositories;

import com.wishlist.auth.models.TRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<TRole, Long> {
    Optional<TRole> findByStrName(String roleName);
}
