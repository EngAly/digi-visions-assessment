package com.digivisions.assessment.managingfiles.entity;

import com.digivisions.assessment.managingfiles.enums.PermissionLevelType;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
public class Permissions extends BaseEntity {

    @Column(name = "user_email", unique = true)
    private String userEmail;

    @Column(name = "permission_level")
    @Enumerated
    private PermissionLevelType permissionLevel;

    @JoinColumn(name = "group_id")
    @ManyToOne
    private PermissionGroups permissionGroups;

    public boolean isPermissionLevelTypeView() {
        return this.permissionLevel == PermissionLevelType.VIEW;
    }

    public boolean isPermissionLevelTypeEdit() {
        return this.permissionLevel == PermissionLevelType.EDIT;
    }

    public boolean isPermissionLevelAny() {
        return isPermissionLevelTypeView() || isPermissionLevelTypeEdit();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public PermissionLevelType getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(PermissionLevelType permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public PermissionGroups getPermissionGroups() {
        return permissionGroups;
    }

    public void setPermissionGroups(PermissionGroups permissionGroups) {
        this.permissionGroups = permissionGroups;
    }
}
