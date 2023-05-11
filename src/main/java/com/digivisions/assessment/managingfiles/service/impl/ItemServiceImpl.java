package com.digivisions.assessment.managingfiles.service.impl;

import com.digivisions.assessment.managingfiles.config.BusinessRuleException;
import com.digivisions.assessment.managingfiles.dao.ItemRepository;
import com.digivisions.assessment.managingfiles.dto.FileMetadataDto;
import com.digivisions.assessment.managingfiles.entity.Files;
import com.digivisions.assessment.managingfiles.entity.Item;
import com.digivisions.assessment.managingfiles.entity.PermissionGroups;
import com.digivisions.assessment.managingfiles.enums.ItemTypeEnum;
import com.digivisions.assessment.managingfiles.service.FileService;
import com.digivisions.assessment.managingfiles.service.ItemService;
import com.digivisions.assessment.managingfiles.service.PermissionService;
import com.digivisions.assessment.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepo;
    private final PermissionService permissionService;
    private final FileService fileService;

    public ItemServiceImpl(ItemRepository itemRepo, PermissionService permissionService, FileService fileService) {
        this.itemRepo = itemRepo;
        this.permissionService = permissionService;
        this.fileService = fileService;
    }

    public void createSpace(Item entity) {

        entity.setId(null);
        entity.setType(ItemTypeEnum.Space);

        itemRepo.save(entity);
    }

    @Override
    public void createFolder(Item entity) {

        entity.setId(null);
        entity.setType(ItemTypeEnum.Folder);

        Item baseSpace = getBaseSpace();
        entity.setParentItem(baseSpace);

        permissionService.isUserHasEditPermission(baseSpace.getPermissionGroup().getId());
        itemRepo.save(entity);
    }

    @Override
    public void createFile(String itemName, Long permissionGroupId, MultipartFile file) {

        Item item = new Item();
        item.setName(itemName);
        item.setType(ItemTypeEnum.File);
        item.setPermissionGroup(new PermissionGroups(permissionGroupId));
        Item baseFolder = getBaseFolder();
        item.setParentItem(baseFolder);

        permissionService.isUserHasEditPermission(baseFolder.getPermissionGroup().getId());

        itemRepo.save(item);
        fileService.createFile(file, item);
    }

    @Override
    public Files downloadFile(Long fileId) {
        return fileService.getFileById(fileId);
    }

    @Override
    public FileMetadataDto getFileMetadata(Long fileId) {
        return fileService.getFileMetadata(fileId);
    }

    private Item getBaseSpace() {
        return itemRepo.findByName(Constants.SPACE).orElseThrow(() ->
                new BusinessRuleException(new StringBuilder("Base Space (").append(Constants.SPACE).append(") Not Exists").toString()));
    }

    private Item getBaseFolder() {
        return itemRepo.findByName(Constants.FOLDER).orElseThrow(() ->
                new BusinessRuleException(new StringBuilder("Base Folder (").append(Constants.FOLDER).append(") Not Exists").toString()));
    }
}
