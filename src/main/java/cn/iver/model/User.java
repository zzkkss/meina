package cn.iver.model;

import cn.iver.common.Const;
import cn.iver.ext.jfinal.Model;

import com.jfinal.plugin.ehcache.CacheKit;

import java.security.NoSuchAlgorithmException;
import java.util.Date;


public class User extends Model<User> {
    public static final User dao = new User();
    private static final String USER_CACHE = "user";

    public User() {
        super(USER_CACHE);
    }

    /* get */
    public User get(int id) {
        return loadModel(id);
    }
    public User getByEmailAndPassword(String email, String password){
        return dao.findFirst("select id, username, email, password from bbs_user where email=? and password=?", email, password);
    }
	public User getByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findFirst("select id, username, email, password from bbs_user where username=? and password=?", username, password);
	}
    /* other */
    public void mySave(){
        this.filterText("username", "headImg", "blogUrl", "feeling");
        String password = getMD5(this.getStr("password").getBytes());
        this.set("password", password).set("registDate", new Date());
        this.save();
    }
    public void myUpdate() {
        this.filterText("username", "headImg", "blogUrl", "feeling");
        this.update();
        removeThisCache(this.getInt("id"));
    }
    public boolean containEmail(String email) {
        return dao.findFirst("select email from bbs_user where email=? limit 1", email) != null;
    }
    public boolean containUsername(String username) {
        return dao.findFirst("select username from bbs_user where username=? limit 1", username) != null;
    }
    public boolean containEmailExceptThis(int userID, String email) {
        return dao.findFirst("select email from bbs_user where email=? and id!=? limit 1", email, userID) != null;
    }
    public boolean containUsernameExceptThis(int userID, String username) {
        return dao.findFirst("select username from bbs_user where username=? and id!=? limit 1", username, userID) != null;
    }

    /* getter */
    public boolean getIsAdmin(String email) {
        return Const.ADMIN_EMAIL.equals(email);
    }

    /* private */
    private String getMD5(byte[] src){
        StringBuffer sb=new StringBuffer();
        try {
            java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
            md.update(src);
            for(byte b : md.digest())
                sb.append(Integer.toString(b>>>4&0xF,16)).append(Integer.toString(b&0xF,16));
        } catch (NoSuchAlgorithmException e) {}
        return sb.toString();
    }

    /* cache */
    private void removeThisCache(int id){
        CacheKit.remove(USER_CACHE, id);
    }


}
