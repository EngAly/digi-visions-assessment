package com.digivisions.assessment.managingfiles.controller;

import com.digivisions.assessment.managingfiles.entity.Files;
import com.digivisions.assessment.managingfiles.entity.Item;
import com.digivisions.assessment.managingfiles.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/items")
public class ItemController extends GenericController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/space")
    public void createSpace(@RequestBody Item item) {
        itemService.createSpace(item);
    }

    @PostMapping("/folder")
    public void createFolder(@RequestBody Item item) {
        itemService.createFolder(item);
    }

    @PostMapping("/file")
    public void createFile(@RequestParam String itemName, @RequestParam Long permissionGroupId, @RequestParam("file") MultipartFile file) {
        itemService.createFile(itemName, permissionGroupId, file);
    }

    @GetMapping("/file/{fileId}/download")
    public void downloadFile(@PathVariable Long fileId, HttpServletResponse response) {

        Files file = itemService.downloadFile(fileId);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getItem() + "\""));
        response.setContentLength(file.getBinary().length);

        try (OutputStream os = response.getOutputStream()) {
            os.write(file.getBinary(), 0, file.getBinary().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/file/{fileId}/metadata")
    public ResponseEntity<?> fileMetadata(@PathVariable Long fileId) {
        return getResponse(itemService.getFileMetadata(fileId));
    }

}
