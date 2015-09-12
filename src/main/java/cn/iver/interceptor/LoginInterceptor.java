package cn.iver.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

public class LoginInterceptor implements Interceptor {
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        if(controller.getSessionAttr("user") != null){
            ai.invoke();
        }else{
            controller.setAttr("msg", "需要登录才可以进行改操作：）");
            controller.render("/common/500.html");
        }
    }
}
