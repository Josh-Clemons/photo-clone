package com.josh.explore.photo.clone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@RestController // needed for REST api, let's 'server' know this is an end point
public class PhotoController {

    private PhotoService photoService;
    public void photoController(PhotoService photoService) {
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
        Photo photo = db.get(id);
        if (photo ==null ) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @DeleteMapping("/photo")
    public void delete(@PathVariable String id) {
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException { // need mark annotation (@) for these rest apis
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }
}
