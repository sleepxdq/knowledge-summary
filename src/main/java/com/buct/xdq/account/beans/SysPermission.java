package com.buct.xdq.account.beans;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by acer on 2017/3/25.
 */
@Data
@Entity
@Table(name = "sys_permission")
public class SysPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String permission;

}
