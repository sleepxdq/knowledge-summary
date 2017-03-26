package com.buct.xdq.account.beans;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色与权限关系
 * Created by acer on 2017/3/25.
 */
@Data
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer rid;

    private Integer pid;

}
