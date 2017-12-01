package com.night.blog.service.impl;


import com.night.blog.dao.AlbumDao;
import com.night.blog.model.Album;
import com.night.blog.model.PageBean;
import com.night.blog.service.AlbumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class AlbumServiceImpl implements AlbumService{

    @Resource
    private AlbumDao albumDao;

    @Override
    public List<Album> findAll() {
        return albumDao.findAll();
    }

    @Override
    public PageBean<Album> findByPage(Integer page) {
        PageBean<Album> pageBean = new PageBean<Album>(page);
        pageBean.setTotalCount(albumDao.findCount());
        pageBean.setBeans(albumDao.findByPage(pageBean.getPageSize()*(page-1),pageBean.getPageSize()));
        return pageBean;
    }
}
