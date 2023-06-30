package com.gosh.goublog.model.dto.post;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 10:06
 * @description 帖子更新请求
 */
@Data
public class PostUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表
     */
    private List<String> tags;

    private static final long serialVersionUID = 1L;
}