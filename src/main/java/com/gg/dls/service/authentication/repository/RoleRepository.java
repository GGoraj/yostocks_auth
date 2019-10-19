package com.gg.dls.service.authentication.repository;

import com.gg.dls.service.authentication.model.Role;
import com.gg.dls.service.authentication.model.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}