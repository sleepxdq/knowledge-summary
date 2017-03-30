package com.buct.xdq.account.service;

import com.buct.xdq.account.beans.SysRole;

import java.util.List;

/**
 * Created by acer on 2017/3/30.
 */
public interface SysRoleService {

    /**
     * 根据用户id获得角色
     * @return
     */
    List<SysRole> findRolesByUid(Integer uid);

}
