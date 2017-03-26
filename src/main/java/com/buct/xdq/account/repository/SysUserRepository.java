package com.buct.xdq.account.repository;

import com.buct.xdq.account.beans.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户dao层
 * Created by acer on 2017/3/26.
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    SysUser findSysUserByUsernameAndPassword(String username, String password);

}
