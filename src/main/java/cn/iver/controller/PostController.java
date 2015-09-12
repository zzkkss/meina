package cn.iver.controller;

import cn.iver.interceptor.AdminInterceptor;
import cn.iver.interceptor.LoginInterceptor;
import cn.iver.validator.PostValidator;
import cn.iver.model.Post;
import cn.iver.model.Topic;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class PostController extends Controller {
    public void index(){
        int topicID = getParaToInt(0);
        Page<Post> postPage = Post.dao.getPage(topicID, getParaToInt(1, 1));
        setAttr("postPage", postPage);
        setAttr("topic", Topic.dao.get(topicID));
        //render("/post/post.html");
        render("/post/postAndroid.html");
    }

    @Before({LoginInterceptor.class, PostValidator.class})
    public void save(){
        Post post = getModel(Post.class);
        post.set("userID", getSessionAttr("userID")).mySave();
        redirect("/bbs/post/" + post.getInt("topicID"));
    }

    @Before(AdminInterceptor.class)
    public void edit(){
        setAttr("post", Post.dao.get(getParaToInt(0)));
        render("/post/edit.html");
    }
    @Before(AdminInterceptor.class)
    public void editAdmin(){
        setAttr("post", Post.dao.get(getParaToInt(0)));
        render("/post/editAdmin.html");
    }
    @Before(AdminInterceptor.class)
    public void delete(){
        Post.dao.deleteByID(getParaToInt(0));
        forwardAction("/admin/postList/" + getParaToInt(1));
    }

    @Before({AdminInterceptor.class, PostValidator.class})
    public void update(){
        Post post = getModel(Post.class);
        post.myUpdate();
        redirect("/bbs/topic/" + post.get("topicID"));
    }
}
