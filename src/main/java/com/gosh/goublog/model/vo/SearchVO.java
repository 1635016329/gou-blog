package com.gosh.goublog.model.vo;

import com.gosh.goublog.model.eneity.Picture;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/23 16:51
 * @description 搜索视图对象
 */
@Data
public class SearchVO implements Serializable {
    private static final long serialVersionUID = -6204509378495625488L;
    private List dataList;

}

