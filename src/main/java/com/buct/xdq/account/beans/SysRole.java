package com.buct.xdq.account.beans;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色实体类
 * Created by acer on 2017/3/25.
 */
@Data
@Entity
@Table(name = "sys_role")
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String role;

    private String type;
}
