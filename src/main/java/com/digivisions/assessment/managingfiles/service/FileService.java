package com.digivisions.assessment.managingfiles.service;

import com.digivisions.assessment.managingfiles.dto.FileMetadataDto;
import com.digivisions.assessment.managingfiles.entity.Files;
import com.digivisions.assessment.managingfiles.entity.Item;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void createFile(MultipartFile file, Item item);

    Files getFileById(Long id);

    FileMetadataDto getFileMetadata(Long fileId);
}
