package cn.iver.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StringKit;

public class UserCheckInterceptor implements Interceptor {
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        String userID = controller.getSessionAttr("userID").toString();
        if(StringKit.notBlank(userID) && userID.equals(controller.getPara(0, "0") + "")){
            ai.invoke();
        }else{
            controller.setAttr("msg", "只有该登录用户本人才有权操作");
            controller.renderError(500);
        }
    }
}
