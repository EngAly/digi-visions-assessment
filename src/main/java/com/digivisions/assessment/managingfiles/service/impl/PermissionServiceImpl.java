package com.digivisions.assessment.managingfiles.service.impl;

import com.digivisions.assessment.managingfiles.config.AuthorizationException;
import com.digivisions.assessment.managingfiles.dao.PermissionRepository;
import com.digivisions.assessment.managingfiles.entity.Permissions;
import com.digivisions.assessment.managingfiles.service.PermissionService;
import com.digivisions.assessment.utils.SecurityUtil;
import com.digivisions.assessment.utils.StringUtils;
import org.springframework.stereotype.Service;

import static com.digivisions.assessment.utils.StringUtils.not;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepo;

    public PermissionServiceImpl(PermissionRepository permissionRepo) {
        this.permissionRepo = permissionRepo;
    }

    @Override
    public boolean existsByUsername(String username) {

        if (StringUtils.isBlank(username))
            throw new SecurityException("Username can't be null");

        return permissionRepo.existsByUserEmail(username);
    }

    @Override
    public boolean isUserHasEditPermission(Long permissionGrpId) {

        Permissions permission = permissionRepo.findByPermissionGroups_IdAndUserEmail(permissionGrpId, SecurityUtil.getCurrentUser())
                .orElseThrow(() -> new AuthorizationException("User not have permission on current container"));

        boolean permissionEdit = permission.isPermissionLevelTypeEdit();

        if (not(permissionEdit))
            throw new AuthorizationException("User not have EDIT permission to edit in current container");

        return true;
    }

    @Override
    public boolean isUserHasAccessPermission(Long permissionGrpId) {

        Permissions permission = permissionRepo.findByPermissionGroups_IdAndUserEmail(permissionGrpId, SecurityUtil.getCurrentUser())
                .orElseThrow(() -> new AuthorizationException("User not have access permission"));

        boolean permissionEdit = permission.isPermissionLevelAny();

        if (not(permissionEdit))
            throw new AuthorizationException("User not have access permission");

        return true;
    }

}
