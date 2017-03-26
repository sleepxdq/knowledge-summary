package com.buct.xdq.account.service;

import com.buct.xdq.account.beans.SysUser;
import org.springframework.stereotype.Service;

/**
 * 用户服务层
 * Created by acer on 2017/3/26.
 */
@Service
public interface SysUserService {

    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    SysUser findUser(String username, String password);

}
