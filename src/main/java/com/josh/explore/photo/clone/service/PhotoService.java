package com.josh.explore.photo.clone.service;

import com.josh.explore.photo.clone.model.Photo;
import com.josh.explore.photo.clone.repository.PhotoRepository;
import org.springframework.stereotype.Component;

import java.util.*;

//
@Component //Services are loaded on initialization
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo put(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photo.setId(1);
        photoRepository.save(photo);
        return photo;
    }
}
