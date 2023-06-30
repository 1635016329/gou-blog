package com.gosh.goublog.model.dto.post;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 10:05
 * @description 帖子添加请求
 */
@Data
public class PostAddRequest implements Serializable {

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