package com.digivisions.assessment.managingfiles.dao;


import com.digivisions.assessment.managingfiles.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permissions, Long> {

    Optional<Permissions> findByUserEmail(String email);

    boolean existsByUserEmail(String email);

    Optional<Permissions> findByPermissionGroups_IdAndUserEmail(Long id, String username);
}
