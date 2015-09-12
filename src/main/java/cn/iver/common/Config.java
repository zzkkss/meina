package cn.iver.common;

import cn.iver.controller.*;
import cn.iver.controller.admin.AdminController;
import cn.iver.controller.admin.ModuleController;
import cn.iver.ext.beetl.BeetlRenderFactory;
import cn.iver.interceptor.GlobalInterceptor;
import cn.iver.model.*;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Config extends JFinalConfig {
	private boolean isLocal = isDevMode();

	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		if (isLocal) {
			me.setDevMode(true);
		}
		me.setError404View("/common/404.html");
		me.setError500View("/common/500.html");
		me.setMainRenderFactory(new BeetlRenderFactory(isLocal));
	}

	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/bbs", IndexController.class).add("/bbs/topic", TopicController.class);
		me.add("/bbs/post", PostController.class).add("/bbs/reply", ReplyController.class);
		me.add("/bbs/user", UserController.class);
		me.add("/bbs/admin", AdminController.class).add("/bbs/admin/module", ModuleController.class);
	}

	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		String jdbcUrl, user, password;
		if (isLocal) {
			jdbcUrl = Const.DEV_JDBC_URL;
			user = Const.DEV_USER;
			password = Const.DEV_PASSWORD;
		} else {
			jdbcUrl = Const.JDBC_URL;
			user = Const.USER;
			password = Const.PASSWORD;
		}
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl(jdbcUrl);
		ds.setUser(user);
		ds.setPassword(password);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(ds);
		if (isLocal) {
			arp.setShowSql(true);
		}
		arp.addMapping("bbs_module", Module.class).addMapping("bbs_topic", Topic.class).addMapping("bbs_post", Post.class);
		arp.addMapping("bbs_reply", Reply.class).addMapping("bbs_user", User.class);
		me.add(arp);
		me.add(new EhCachePlugin());
	}

	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		me.add(new SessionInViewInterceptor());
		me.add(new GlobalInterceptor());
	}

	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("base"));
	}

	/**
	 * 初始化常量
	 */
	public void afterJFinalStart() {
	}

	private boolean isDevMode() {
		String osName = System.getProperty("os.name");
		return osName.indexOf("Windows") != -1;
	}

	public static void main(String[] args) throws Exception {
		JFinal.start("WebRoot", 8081, "/bbs", 5);
	}
}