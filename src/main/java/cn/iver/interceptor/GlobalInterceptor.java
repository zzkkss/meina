package cn.iver.interceptor;

import cn.iver.common.Const;
import cn.iver.model.Module;
import cn.iver.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StringKit;

public class GlobalInterceptor implements Interceptor {
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();

        controller.setAttr("moduleList", Module.dao.getList());
        // validate user info from bbs_id
 /*       if(session.getServletContext().getContext("")!=null){  
            HttpSession t2_session = (HttpSession)session.getServletContext().getContext("/test2").getAttribute("t2_session");  
            if(t2_session!=null){  
                String str = (String)t2_session.getAttribute("test2Session");  
                String path = request.getContextPath();  
                out.println("Application "+path +":"+str+"<br>");  
            }else{  
                out.println("Application /test2 no data!");  
            }  
        }*/  
     /*   HttpSession session1 =req .getSession();  
        ServletContext Context = session1.getServletContext();  
        ServletContext Context1= Context.getContext("/myweb"); // 项目A的虚拟路径
        HttpSession session2 =(HttpSession)Context1.getAttribute("session");
        System.out.println("base传过来的user为:"+session2.getAttribute("name")); */
        
        
        
        if(controller.getSessionAttr("user") == null && StringKit.notBlank(controller.getCookie("bbsID"))){
            String bbsID = controller.getCookie("bbsID");
            if(StringKit.notBlank(bbsID)){
                String[] userAndEmail = bbsID.split(Const.BBS_ID_SEPARATOR);
                User user = null;
                if(userAndEmail != null && userAndEmail.length == 2){
                    user = User.dao.getByEmailAndPassword(userAndEmail[0], userAndEmail[1]);
                }
                if(user != null){
                    controller.getSession().setMaxInactiveInterval(1800);
                    controller.setSessionAttr("user", user);
                    controller.setSessionAttr("userID", user.get("id"));
                }else{
                    ai.getController().removeCookie("bbsID");
                }
            }
        }
        ai.invoke();
        controller.setAttr("v", Const.TIMESTAMP);
    }
}
