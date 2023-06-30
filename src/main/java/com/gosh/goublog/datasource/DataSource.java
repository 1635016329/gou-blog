package com.gosh.goublog.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/23 16:46
 * @description 数据源接口
 */
public interface DataSource<T> {

    /**
     * 搜索
     * @param searchText
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<T> doSearch(String searchText, long pageNum, long pageSize);
}
