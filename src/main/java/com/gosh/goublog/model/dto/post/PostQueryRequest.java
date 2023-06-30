package com.gosh.goublog.model.dto.post;

import com.gosh.goublog.common.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 10:06
 * @description 帖子查询请求
 */
@Data
public class PostQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * id
     */
    private Long notId;

    /**
     * 搜索词
     */
    private String searchText;

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

    /**
     * 至少有一个标签
     */
    private List<String> orTags;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 收藏用户 id
     */
    private Long favourUserId;

    private static final long serialVersionUID = 1L;
}
