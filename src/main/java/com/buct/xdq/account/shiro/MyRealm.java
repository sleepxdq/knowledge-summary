package com.buct.xdq.account.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义realm
 * Created by acer on 2017/3/26.
 */
public class MyRealm {

    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);

    /**
     * 授权
     * @param principalCollection
     * @return
     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
//    /**
//     * 登陆验证
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        log.info("登陆验证");
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//
//        return null;
//    }
}
