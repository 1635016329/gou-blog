package com.gosh.goublog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gosh.goublog.model.eneity.Picture;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/26 16:27
 * @description
 */
public interface PictureService {
    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);
}

