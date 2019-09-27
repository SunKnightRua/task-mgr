package cn.sun.tasks.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sun.tasks.permission.dao.PermissionDao;
import cn.sun.tasks.permission.domain.Permission;
import cn.sun.tasks.user.domain.ActiveUser;
import cn.sun.tasks.user.domain.User;
import cn.sun.tasks.user.service.UserService;

public class MyRealm extends AuthorizingRealm {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PermissionDao permissionDao;
    
    @Override
    public void setName(String name) {
        super.setName("myRealm");
    };
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.getUserByUsername(username);
        if(user == null) {
            return null;
        }
        String password = user.getPassword();
        
        List<Permission> permissions = new ArrayList<>();
        permissions = permissionDao.listPermissions(user.getId());
        
        ActiveUser activeUser = new ActiveUser();
        activeUser.setId(user.getId());
        activeUser.setUsername(username);
        activeUser.setPassword(password);
        activeUser.setPermissions(permissions);
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, password, this.getName());
        return info;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("---->开始授权");
        ActiveUser activeUser =  (ActiveUser) principals.getPrimaryPrincipal();
        List<Permission> permissionList = activeUser.getPermissions();
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> permissions = new ArrayList<String>();
        if(permissionList !=null) {
            for(Permission permission : permissionList) {
                permissions.add(permission.getPerCode());
            }
        }
        info.addStringPermissions(permissions);
        return info;
    }
}
