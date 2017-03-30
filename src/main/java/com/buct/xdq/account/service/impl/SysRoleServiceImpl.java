package com.buct.xdq.account.service.impl;

import com.buct.xdq.account.beans.SysRole;
import com.buct.xdq.account.repository.SysRoleRepository;
import com.buct.xdq.account.repository.SysUserRoleRepository;
import com.buct.xdq.account.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by acer on 2017/3/30.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleRepository roleRepository;

    private final SysUserRoleRepository userRoleRepository;

    @Autowired
    public SysRoleServiceImpl(SysRoleRepository roleRepository, SysUserRoleRepository userRoleRepository) {
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<SysRole> findRolesByUid(Integer uid) {
        //根据uid获得rids
        List<Integer> rids = userRoleRepository.findSysUserRolesByUid(uid)
                .stream()
                .map(role -> role.getRid())
                .distinct()
                .collect(Collectors.toList());
        return roleRepository.findAll(rids);
    }
}
