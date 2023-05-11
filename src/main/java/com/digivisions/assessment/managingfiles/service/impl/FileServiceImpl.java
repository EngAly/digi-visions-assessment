package com.digivisions.assessment.managingfiles.service.impl;

import com.digivisions.assessment.managingfiles.dao.FilesRepository;
import com.digivisions.assessment.managingfiles.dto.FileMetadataDto;
import com.digivisions.assessment.managingfiles.entity.Files;
import com.digivisions.assessment.managingfiles.entity.Item;
import com.digivisions.assessment.managingfiles.service.FileService;
import com.digivisions.assessment.managingfiles.service.PermissionService;
import com.digivisions.assessment.utils.FileUtil;
import com.digivisions.assessment.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.digivisions.assessment.utils.StringUtils.not;

@Service
public class FileServiceImpl implements FileService {

    private final FilesRepository filesRepo;
    private final PermissionService permissionService;

    public FileServiceImpl(FilesRepository filesRepo, PermissionService permissionService) {
        this.filesRepo = filesRepo;
        this.permissionService = permissionService;
    }

    @Override
    public void createFile(MultipartFile file, Item item) {

        Files fileData = new Files();
        fileData.setItem(item);
        fileData.setBinary(FileUtil.getFileAsByteArray(file));
        filesRepo.save(fileData);
    }

    @Override
    public Files getFileById(Long id) {

        Files file = filesRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("File not exists"));
        permissionService.isUserHasAccessPermission(file.getItem().getPermissionGroup().getId());

        if (not(file.getItem().isItemTypeFile())) throw new EntityNotFoundException("Item type not file");

        return file;
    }

    @Override
    public FileMetadataDto getFileMetadata(Long fileId) {

        Files file = getFileById(fileId);

        permissionService.isUserHasAccessPermission(file.getItem().getPermissionGroup().getId());

        List<Object[]> fileMetadataDB = filesRepo.getFileMetadata(fileId);

        if (StringUtils.isEmpty(fileMetadataDB)) return null;

        return getFileMetadata(fileMetadataDB, 0, new FileMetadataDto());
    }

    private FileMetadataDto getFileMetadata(List<Object[]> fileMetadataDB, int idx, FileMetadataDto fileMetadata) {

        FileMetadataDto tempFileMetadata = new FileMetadataDto();
        tempFileMetadata.setId(Long.valueOf(String.valueOf(fileMetadataDB.get(idx)[0])));
        tempFileMetadata.setName(String.valueOf(fileMetadataDB.get(idx)[1]));

        if (idx == 0) {
            fileMetadata = tempFileMetadata;
        }else{
            fileMetadata.setParent(tempFileMetadata);
        }

        if (fileMetadataDB.size() != idx + 1) {
            getFileMetadata(fileMetadataDB, ++idx, tempFileMetadata);
        }

        return fileMetadata;
    }
}
