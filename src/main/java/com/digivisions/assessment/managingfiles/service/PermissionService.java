package com.digivisions.assessment.managingfiles.service;

public interface PermissionService {

    boolean existsByUsername(String username);

    boolean isUserHasEditPermission(Long permissionGrpId);

    boolean isUserHasAccessPermission(Long permissionGrpId);
}
