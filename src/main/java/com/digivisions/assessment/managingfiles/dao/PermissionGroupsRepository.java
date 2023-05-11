package com.digivisions.assessment.managingfiles.dao;

import com.digivisions.assessment.managingfiles.entity.PermissionGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionGroupsRepository extends JpaRepository<PermissionGroups, Long> {
}
