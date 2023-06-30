package com.gosh.goublog.controller;

import com.gosh.goublog.common.BaseResponse;
import com.gosh.goublog.common.ResultUtils;
import com.gosh.goublog.manager.SearchFacade;
import com.gosh.goublog.model.dto.search.SearchRequest;
import com.gosh.goublog.model.vo.SearchVO;
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
 * @date 2023/6/23 16:39
 * @description 搜索控制器
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    private SearchFacade searchFacade;

    @PostMapping("/data")
    public BaseResponse<SearchVO> search(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        SearchVO searchVO = searchFacade.search(searchRequest, request);
        return ResultUtils.success(searchVO);
    }
}