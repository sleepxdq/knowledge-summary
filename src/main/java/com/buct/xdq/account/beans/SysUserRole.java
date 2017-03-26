package com.buct.xdq.account.beans;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户与角色关联关系
 * Created by acer on 2017/3/25.
 */
@Data
@Entity
@Table(name = "sys_user_role")
public class SysUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer uid;
    private Integer rid;

}
