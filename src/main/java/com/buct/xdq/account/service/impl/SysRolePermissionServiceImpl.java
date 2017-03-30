package com.buct.xdq.account.service.impl;

import com.buct.xdq.account.beans.SysRolePermission;
import com.buct.xdq.account.repository.SysRolePermissionRepository;
import com.buct.xdq.account.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer on 2017/3/30.
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    private final SysRolePermissionRepository rolePermissionRepository;

    @Autowired
    public SysRolePermissionServiceImpl(SysRolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @Override
    public List<SysRolePermission> findAll(List<Integer> rids) {
        return rolePermissionRepository.findAll(rids);
    }
}
