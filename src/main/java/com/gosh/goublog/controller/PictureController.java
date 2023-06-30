package com.gosh.goublog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gosh.goublog.common.BaseResponse;
import com.gosh.goublog.common.ResultUtils;
import com.gosh.goublog.model.dto.picture.PictureQueryRequest;
import com.gosh.goublog.model.eneity.Picture;
import com.gosh.goublog.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/26 16:30
 * @description
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Resource
    private PictureService pictureService;

    @PostMapping("/list/page/vo")
    public BaseResponse<Page<Picture>> listPictureByPage(@RequestBody PictureQueryRequest pictureQueryRequest, HttpServletRequest request) {
        long current = pictureQueryRequest.getCurrent();
        long size = pictureQueryRequest.getPageSize();

        String searchText = pictureQueryRequest.getSearchText();
        Page<Picture> picturePage = pictureService.searchPicture(searchText, current, size);
        return ResultUtils.success(picturePage);
    }
}
