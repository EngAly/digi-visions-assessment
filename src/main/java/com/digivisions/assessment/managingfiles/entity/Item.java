package com.digivisions.assessment.managingfiles.entity;

import com.digivisions.assessment.managingfiles.enums.ItemTypeEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item extends BaseEntity {

    @Column(unique = true)
    private String name;

    @Enumerated
    private ItemTypeEnum type;

    @JoinColumn(name = "permission_group_id")
    @ManyToOne
    private PermissionGroups permissionGroup;

    @JoinColumn(name = "parent_item_id")
    @ManyToOne
    private Item parentItem;

    @OneToMany(mappedBy = "item")
    private List<Files> files;


    public boolean isItemTypeSpace() {
        return this.type == ItemTypeEnum.Space;
    }

    public boolean isItemTypeFolder() {
        return this.type == ItemTypeEnum.Folder;
    }

    public boolean isItemTypeFile() {
        return this.type == ItemTypeEnum.File;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemTypeEnum getType() {
        return type;
    }

    public void setType(ItemTypeEnum type) {
        this.type = type;
    }

    public PermissionGroups getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(PermissionGroups permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    public Item getParentItem() {
        return parentItem;
    }

    public void setParentItem(Item parentItem) {
        this.parentItem = parentItem;
    }

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }
}
