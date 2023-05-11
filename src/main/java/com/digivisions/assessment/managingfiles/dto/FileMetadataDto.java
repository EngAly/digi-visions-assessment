package com.digivisions.assessment.managingfiles.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileMetadataDto {

    private Long id;
    private String name;
    private FileMetadataDto parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileMetadataDto getParent() {
        return parent;
    }

    public void setParent(FileMetadataDto parent) {
        this.parent = parent;
    }
}
