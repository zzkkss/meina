package cn.iver.controller;

import cn.iver.model.Topic;
import com.jfinal.core.Controller;

public class IndexController extends Controller {
    public void index(){
        setAttr("topicPage", Topic.dao.getPage(getParaToInt(0, 1)));
        setAttr("actionUrl", "/");
        render("/common/index.html");
    }
    public void leaveMsg(){
        render("/common/leaveMsg.html");
    }
    public void android(){
//        setAttr("topicPage", Topic.dao.getPage(getParaToInt(0, 1)));
//        setAttr("actionUrl", "/bbs/android/");
        setAttr("topicPage", Topic.dao.getHotPage(getParaToInt(0, 1)));
        setAttr("actionUrl", "/bbs/topic/hot/");
        render("/common/indexAndroid.html");
    }
    public void regist(){
        render("/user/regist.html");
    }
    public void toLogin(){
        render("/user/login.html");
    }
    public void test(){
        render("/common/test.html");
    }
}
