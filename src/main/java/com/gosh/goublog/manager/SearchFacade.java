package com.gosh.goublog.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gosh.goublog.common.ErrorCode;
import com.gosh.goublog.datasource.DataSource;
import com.gosh.goublog.datasource.DataSourceRegistry;
import com.gosh.goublog.exception.ThrowUtils;
import com.gosh.goublog.model.dto.search.SearchRequest;
import com.gosh.goublog.model.enums.SearchTypeEnum;
import com.gosh.goublog.model.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/23 16:42
 * @description 搜索门面
 */
@Component
@Slf4j
public class SearchFacade {

    @Resource
    private DataSourceRegistry dataSourceRegistry;

    public SearchVO search(SearchRequest searchRequest, HttpServletRequest request) {
        String searchText = searchRequest.getSearchText();
        long current = searchRequest.getCurrent();
        long pageSize = searchRequest.getPageSize();
        String type = searchRequest.getType();
        // 根据标题返回搜索建议
        if (type.equals("title")) {
            current = 0;
            pageSize = 0;
            type = "post";
        }
        SearchTypeEnum searchTypeEnum = SearchTypeEnum.getEnumByValue(type);
        ThrowUtils.throwIf(StringUtils.isBlank(type), ErrorCode.PARAMS_ERROR);
        ThrowUtils.throwIf(ObjectUtils.isEmpty(searchTypeEnum), ErrorCode.PARAMS_ERROR);
        //搜索数据
        SearchVO searchVO = new SearchVO();
        //拿到数据源
        DataSource dataSource = dataSourceRegistry.getDataSourceByType(type);
        Page page = dataSource.doSearch(searchText, current, pageSize);
        searchVO.setDataList(page.getRecords());
        return searchVO;
    }
}
