package com.buct.xdq.account.service.impl;

import com.buct.xdq.account.beans.SysUser;
import com.buct.xdq.account.repository.SysUserRepository;
import com.buct.xdq.account.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * Created by acer on 2017/3/26.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository userRepository;

    public SysUserServiceImpl(SysUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SysUser findUser(String username, String password) {
        return userRepository.findSysUserByUsernameAndPassword(username, password);
    }

    @Override
    public void create(SysUser user) {
        userRepository.save(user);
    }

    @Override
    public void update(SysUser user) {
//        userRepository
    }

    @Override
    public SysUser findUserById(Integer id) {
        return userRepository.findOne(id);
    }
}
