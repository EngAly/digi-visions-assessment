package com.digivisions.assessment.managingfiles.service;

import com.digivisions.assessment.managingfiles.dto.FileMetadataDto;
import com.digivisions.assessment.managingfiles.entity.Files;
import com.digivisions.assessment.managingfiles.entity.Item;
import org.springframework.web.multipart.MultipartFile;

public interface ItemService {

    void createSpace(Item entity);

    void createFolder(Item item);

    void createFile(String itemName, Long permissionGroupId, MultipartFile file);

    Files downloadFile(Long fileId);

    FileMetadataDto getFileMetadata(Long fileId);
}
