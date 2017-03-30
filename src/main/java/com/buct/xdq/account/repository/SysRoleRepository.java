package com.buct.xdq.account.repository;

import com.buct.xdq.account.beans.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by acer on 2017/3/30.
 */
@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Integer> {

}
