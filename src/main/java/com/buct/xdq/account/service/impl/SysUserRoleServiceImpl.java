package com.buct.xdq.account.service.impl;

import com.buct.xdq.account.beans.SysUserRole;
import com.buct.xdq.account.repository.SysUserRoleRepository;
import com.buct.xdq.account.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer on 2017/3/30.
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    private final SysUserRoleRepository userRoleRepository;

    @Autowired
    public SysUserRoleServiceImpl(SysUserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<SysUserRole> findByUid(Integer uid) {
        return userRoleRepository.findSysUserRolesByUid(uid);
    }
}
