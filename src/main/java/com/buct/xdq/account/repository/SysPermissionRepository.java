package com.buct.xdq.account.repository;

import com.buct.xdq.account.beans.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 权限仓库
 * Created by acer on 2017/3/30.
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission, Integer> {
}
