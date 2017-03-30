package com.buct.xdq.account.service.impl;

import com.buct.xdq.account.beans.SysPermission;
import com.buct.xdq.account.beans.SysUserRole;
import com.buct.xdq.account.repository.SysPermissionRepository;
import com.buct.xdq.account.service.SysPermissionService;
import com.buct.xdq.account.service.SysRolePermissionService;
import com.buct.xdq.account.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by acer on 2017/3/30.
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    private final SysPermissionRepository permissionRepository;

    private final SysUserRoleService userRoleService;

    private final SysRolePermissionService rolePermissionService;

    @Autowired
    public SysPermissionServiceImpl(SysPermissionRepository permissionRepository,
                                    SysUserRoleService userRoleService,
                                    SysRolePermissionService rolePermissionService) {
        this.permissionRepository = permissionRepository;
        this.userRoleService = userRoleService;
        this.rolePermissionService = rolePermissionService;
    }

    @Override
    public List<SysPermission> findPermissionByUid(Integer uid) {
        //先获得角色ID，再获得权限ID，之后获得所有权限
        List<Integer> rids = userRoleService.findByUid(uid)
                .stream()
                .map(userRole -> userRole.getRid())
                .distinct()
                .collect(Collectors.toList());
        List<Integer> pids = rolePermissionService.findAll(rids)
                .stream()
                .map(rolePermission -> rolePermission.getPid())
                .distinct()
                .collect(Collectors.toList());
        return permissionRepository.findAll(pids);
    }
}
