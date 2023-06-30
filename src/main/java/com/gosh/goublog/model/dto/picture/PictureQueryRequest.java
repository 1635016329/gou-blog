package com.gosh.goublog.model.dto.picture;

import com.gosh.goublog.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/26 16:23
 * @description 图片搜索DTO
 */
@Data
public class PictureQueryRequest extends PageRequest implements Serializable {

    private String searchText;
    private static final long serialVersionUID = -688952969092604698L;
}
