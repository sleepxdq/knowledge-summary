package com.buct.xdq.account.service.impl;

import com.buct.xdq.account.beans.SysUser;
import com.buct.xdq.account.repository.SysUserRepository;
import com.buct.xdq.account.service.SysUserService;

/**
 * Created by acer on 2017/3/26.
 */
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository userRepository;

    public SysUserServiceImpl(SysUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SysUser findUser(String username, String password) {
        return userRepository.findSysUserByUsernameAndPassword(username, password);
    }
}
