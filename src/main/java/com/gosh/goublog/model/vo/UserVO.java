package com.gosh.goublog.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 13:21
 * @description 脱敏用户
 */
@Data
public class UserVO implements Serializable {

    /**
     * id
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

    private static final long serialVersionUID = 1L;
}
