package com.josh.explore.photo.clone.web;

import com.josh.explore.photo.clone.service.PhotoService;
import com.josh.explore.photo.clone.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController // needed for REST api, let's 'server' know this is an end point
public class PhotoController {

    private PhotoService photoService;
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping("/") // get request, mapped to "/"
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photo")
    public Collection<Photo> get() {

        return photoService.get();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id) { //@PathVariable uses the parameter in case there are naming issue
        Photo photo = photoService.get(id);
        if (photo ==null ) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photo")
    public void delete(@PathVariable String id) {
        Photo photo = photoService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException { // need mark annotation (@) for these rest apis
        Photo photo = photoService.put(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
