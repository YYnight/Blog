package com.night.blog.controller;

import com.night.blog.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/photos")
public class AlbumController {

    @Resource
    private AlbumService albumService;

//    @GetMapping
//    public Object findAll(){
//        return albumService.findAll();
//    }

    @GetMapping("/{page}")
    public Object findByPage(@PathVariable(value="page",required = false)String page){
        if(page==""||page==null){
            page="1";
        }
        return albumService.findByPage(Integer.valueOf(page));
    }
}
