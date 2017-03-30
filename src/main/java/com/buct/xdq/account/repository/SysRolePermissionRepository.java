package com.buct.xdq.account.repository;

import com.buct.xdq.account.beans.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by acer on 2017/3/30.
 */
@Repository
public interface SysRolePermissionRepository extends JpaRepository<SysRolePermission, Integer> {

}
