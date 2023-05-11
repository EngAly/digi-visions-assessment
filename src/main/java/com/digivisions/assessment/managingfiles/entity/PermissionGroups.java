package com.digivisions.assessment.managingfiles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permission_groups")
public class PermissionGroups extends BaseEntity {

    @Column(name = "group_name")
    private String groupName;

    public PermissionGroups() {
    }

    public PermissionGroups(Long id) {
        setId(id);
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
