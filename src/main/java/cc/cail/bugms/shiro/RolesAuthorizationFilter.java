package cc.cail.bugms.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
/**
 * 
 * 自定义过滤器，or或者,之前的roles是and的关系，这里需要一种过滤器，开发者和测试者都可以通过是or的逻辑
 *
 */
public class RolesAuthorizationFilter extends AuthorizationFilter{  
	  
    @Override  
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)  
            throws Exception {  
        Subject subject = getSubject(request, response);   
        String[] rolesArray = (String[]) mappedValue;   
  
        if (rolesArray == null || rolesArray.length == 0) {   
            //no roles specified, so nothing to check - allow access.   
            return true;   
        }   
  
        for(int i=0;i<rolesArray.length;i++){    
            if(subject.hasRole(rolesArray[i])){    
                return true;    
            }    
        }    
        return false;    
    }  
  
}
