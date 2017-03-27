package com.buct.xdq.account.service;

import com.buct.xdq.account.beans.SysUser;

/**
 * 用户服务层
 * Created by acer on 2017/3/26.
 */
public interface SysUserService {

    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    SysUser findUser(String username, String password);

    /**
     * 创建用户
     * @param user
     */
    void create(SysUser user);

    /**
     * 更新用户数据
     * @param user
     */
    void update(SysUser user);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysUser findUserById(Integer id);

}
