package com.buct.xdq.account.repository;

import com.buct.xdq.account.beans.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by acer on 2017/3/30.
 */
@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Integer> {

    List<SysUserRole> findSysUserRolesByUid(Integer uid);

}
