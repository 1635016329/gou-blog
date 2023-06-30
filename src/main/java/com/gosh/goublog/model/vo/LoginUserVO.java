package com.gosh.goublog.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 13:03
 * @description 登录用户VO
 */
@Data
public class LoginUserVO implements Serializable {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}