package com.buct.xdq.config;

import com.buct.xdq.account.service.SysUserService;
import com.buct.xdq.account.shiro.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置
 * Created by acer on 2017/3/27.
 */
@Configuration
public class ShiroConfig {

    private static final Logger log = LoggerFactory.getLogger(ShiroConfig.class);

    private final SysUserService userService;

    @Autowired
    public ShiroConfig(SysUserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/account/login");
        shiroFilterFactoryBean.setSuccessUrl("/home/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        Map<String, String> filterChain = new LinkedHashMap<String, String>();
        filterChain.put("/account/login", "anon");
        filterChain.put("/home/index", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChain);
        log.info("拦截器注入成功");
        return shiroFilterFactoryBean;
    }

    /**
     * 核心管理
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //管理MyRealm
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    public MyRealm myRealm(){
        return new MyRealm(userService);
    }

}
