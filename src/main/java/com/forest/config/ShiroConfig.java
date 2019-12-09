package com.forest.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置文件
 */
@Configuration
public class ShiroConfig {
	
    /**
     * Session Manager：会话管理
     * - 即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；
     * - 会话可以是普通JavaSE环境的，也可以是如Web环境的；
     */
    @Bean("sessionManager")
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // 去掉shiro登录时url里的JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     * SecurityManager：安全管理器
     */
    @Bean("securityManager")
    public SecurityManager securityManager( UserRealm userRealm,SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager);
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean("UserRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    /**
     * ShiroFilter是整个Shiro的入口点，用于拦截需要安全控制的请求进行处理
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    	
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        
        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/assets/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/scss/**", "anon");
        filterChainDefinitionMap.put("/umeditor-1.2.3/**", "anon");
        filterChainDefinitionMap.put("/uploading.css", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/uploading.js", "anon");

        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/picture/**", "anon");
        filterChainDefinitionMap.put("/head/**", "anon");
        filterChainDefinitionMap.put("/commodity/**", "anon");
        filterChainDefinitionMap.put("/color/**", "anon");
        
        filterChainDefinitionMap.put("/find", "anon");
        filterChainDefinitionMap.put("/getRandomCode", "anon");
        //filterChainDefinitionMap.put("/finderror", "anon");
        filterChainDefinitionMap.put("/loginOut", "anon");

        filterChainDefinitionMap.put("/queryAll", "anon");
        
        filterChainDefinitionMap.put("/query", "anon");
        filterChainDefinitionMap.put("/querySandP", "anon");
        filterChainDefinitionMap.put("/queryPos", "anon");
        filterChainDefinitionMap.put("/queryShop", "anon");
        filterChainDefinitionMap.put("/queryStaffId", "anon");
        filterChainDefinitionMap.put("/session", "anon");
        filterChainDefinitionMap.put("/upload", "anon");
        
        //过滤链定义，从上向下顺序执行，一般将/**放在最为下边.这是一个坑呢，一不小心代码就不好使了
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/**", "authc");

        // 配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/statistics/toPage");
        // 设置无权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/finderror");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
        
        /**
         * - 一个URL可以配置多个Filter，使用逗号分隔
         * - 当设置多个过滤器时，全部验证通过，才视为通过
         * - 部分过滤器可指定参数，如perms，roles
         * - Shiro内置的FilterChain，这里面举出几个常见的的FilterChain
         * - anon: 所有url都都可以匿名访问
         * - authc: 需要认证才能进行访问
         * - roles: 参数可写多个，表示是某个或某些角色才能通过，多个参数时写 roles["admin，user"]，
         * -										当有多个参数时必须每个参数都通过才算通过
         * - user：配置记住我或认证通过可以访问
         * - perms：参数可写多个，表示需要某个或某些权限才能通过，多个参数时写 perms["user, admin"]，
         * - 										当有多个参数时必须每个参数都通过才算通过
         */
    }

    /**
     * - 密码加密配置bean
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");//散列算法:MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512等。
        hashedCredentialsMatcher.setHashIterations(3);//散列的次数，默认1次， 设置两次相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

    /**
     * - 管理Shiro中一些bean的生命周期
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    
    /**
     * - 扫描上下文，寻找所有的Advistor(通知器）
     * - 将这些Advisor应用到所有符合切入点的Bean中。
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }
    
    /**
     * - 匹配所有加了 Shiro 认证注解的方法
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    
}