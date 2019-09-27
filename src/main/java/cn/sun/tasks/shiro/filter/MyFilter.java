package cn.sun.tasks.shiro.filter;

import java.io.IOException;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import cn.sun.tasks.permission.domain.Permission;
import cn.sun.tasks.user.domain.ActiveUser;


public class MyFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("----> 开始自定义授权");
        boolean flag = false;
        String url = req.getRequestURI().substring(req.getContextPath().length());
        
        ActiveUser activeUser = (ActiveUser) SecurityUtils.getSubject().getPrincipal();
        List<Permission> permissions = new ArrayList<Permission>();
        if(activeUser != null) {
            permissions = activeUser.getPermissions();
        }
        if(permissions != null && permissions.size() != 0) {
            for(Permission permission : permissions) {
                if(url != null) {
                    if(url.equals(permission.getUrl())) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }
       
//    @Override
//    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
//            throws IOException {
//        System.out.println("----> 开始自定义授权");
//        boolean flag = false;
//        Subject subject = getSubject(request, response);
//        String[] perms = (String[]) mappedValue;
//        if(perms != null && perms.length > 0) {
//            for(String permission : perms) {
//                if(subject.isPermitted(permission)) {
//                    flag = true;
//                }
//            }
//        }
//        
//        return flag;
//    }
}
