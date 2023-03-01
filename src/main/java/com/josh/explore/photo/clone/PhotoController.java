package com.josh.explore.photo.clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // needed for REST api, let's 'server' know this is an end point
public class PhotoController {

    @GetMapping("/") // get request, mapped to "/"
    public String hello() {
        return "Hello World";
    }
}
