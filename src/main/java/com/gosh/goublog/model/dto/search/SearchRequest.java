package com.gosh.goublog.model.dto.search;

import com.gosh.goublog.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/23 16:50
 * @description 搜索请求
 */
@Data
public class SearchRequest extends PageRequest implements Serializable {
    private static final long serialVersionUID = 414600295413108451L;
    private String searchText;

    /**
     * 类型
     */
    private String type;
}
