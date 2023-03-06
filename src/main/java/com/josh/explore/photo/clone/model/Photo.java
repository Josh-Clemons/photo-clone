package com.josh.explore.photo.clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTOS")
public class Photo {

    private Integer id;
    @NotEmpty
    private String fileName;
    @JsonIgnore
    private byte[] data;
    private String contentType;
    public Photo() {

    }
    public Photo(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getData() {
        return data;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
