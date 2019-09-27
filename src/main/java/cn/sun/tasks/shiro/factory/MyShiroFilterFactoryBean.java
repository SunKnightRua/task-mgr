package cn.sun.tasks.shiro.factory;

import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sun.tasks.permission.dao.PermissionDao;

public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {
    
    @Autowired
    private PermissionDao permissionDao;
    
    @Override
    public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
        
    }
}
