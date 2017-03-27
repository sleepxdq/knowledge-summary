package com.buct.xdq.account.shiro;

import com.buct.xdq.account.beans.SysUser;
import com.buct.xdq.account.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;

/**
 * 自定义realm
 * Created by acer on 2017/3/26.
 */
public class MyRealm extends AuthorizingRealm{

    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);

    private final SysUserService userService;

    @Autowired
    public MyRealm(SysUserService userService) {
        this.userService = userService;
    }
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登陆验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("登陆验证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //与数据库验证是否有此用户
        SysUser user = userService.findUser(token.getUsername(), String.valueOf(token.getPassword()));
        if (Objects.isNull(user)) {
            throw new AccountException("账号或密码错误");
        }
        if (user.getStatus().equals("0")) {
            throw new DisabledAccountException("账号已被禁止");
        }
        user.setLastLoginTime(new Date());
        userService.update(user);
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName()) ;
    }
}
