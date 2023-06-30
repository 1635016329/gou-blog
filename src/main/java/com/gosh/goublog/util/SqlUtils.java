package com.gosh.goublog.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 13:32
 * @description
 */
public class SqlUtils {

    /**
     * 校验排序字段是否合法（防止 SQL 注入）
     *
     * @param sortField
     * @return
     */
    public static boolean validSortField(String sortField) {
        if (StringUtils.isBlank(sortField)) {
            return false;
        }
        return !StringUtils.containsAny(sortField, "=", "(", ")", " ");
    }
}
