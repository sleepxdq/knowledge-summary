package com.buct.xdq.account.beans;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体类
 * Created by sleepxdq on 2017/3/25.
 */
@Data
@Entity
@Table(name = "sys_user")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 账户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最近登陆时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 状态0：表示禁用，1：开启
     */
    private String status;

    public SysUser() {}

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.lastLoginTime = new Date();
        this.status = "1";
    }
}
