package com.gosh.goublog.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 10:04
 * @description 用户注册请求
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}