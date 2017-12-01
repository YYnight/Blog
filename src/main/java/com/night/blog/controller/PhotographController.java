package com.night.blog.controller;

import com.night.blog.service.PhotographService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/photograph")
public class PhotographController {

    @Resource private PhotographService  photographService;

    @GetMapping("/{photoId}/{page}")
    public Object findByPhotoIdAndSize(@PathVariable Integer photoId, @PathVariable Integer page){
        return photographService.findPhotographByPhotoIdAndPage(photoId,page);
    }
}
