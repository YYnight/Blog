package com.night.blog.service.impl;

import com.night.blog.dao.PhotographDao;
import com.night.blog.model.PageBean;
import com.night.blog.model.Photograph;
import com.night.blog.service.PhotographService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class PhotographServiceImpl implements PhotographService {
    @Resource private PhotographDao photographDao;
    @Override
    public PageBean<Photograph> findPhotographByPhotoIdAndPage(Integer photoId, Integer pageNow) {
        PageBean<Photograph> pageBean = new PageBean<Photograph>(pageNow);
        pageBean.setTotalCount(photographDao.findCountByPhotoId(photoId));
        pageBean.setBeans(photographDao.finByPhotoIdAndPage(photoId,pageBean.getPageSize()*(pageNow-1),pageBean.getPageSize()));
        return pageBean;
    }
}
