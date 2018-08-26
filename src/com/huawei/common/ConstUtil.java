package com.huawei.common;
/**
 * @ClassName: ConstUtil
 * @ClassNameExplain: 常量工具类
 * @Description: 保存代码中的各种常量
 * @author Ice
 * @date 2016年4月11日 下午2:13:38
 */
public class ConstUtil {
	//服务器配置地址常量
	//------------------------------部署之前必须修改------------------------------------
	public static final String SERVER_ADDRESS = "http://localhost:8080/werunmanager";
	public static final String LOCAL_PIC_ADDRESS = "D:/image/userImage/";
	public static final String PIC_ADDRESS = "http://120.77.212.147:8080/file/userUpload";
	public static final String FILE_ADDRESS = "C:/file/userUpload/";
	public static final String FILE_SERVER_ADDRESS = "http://120.77.212.147:8080/file/userUpload/";
	public static final String FILE_LOCAL_ADDRESS = "C:/file/userUpload/";
	//融云配置常量
	public static final String appKey = "uwd1c0sxuwtw1";//替换成您的appkey
	public static final String appSecret = "hGzQL3hSEi";//替换成匹配上面key的secret
	//接口地址常量
	public static final String BASE_INTERFACE = "/";
	public static final String APP_INTERFACE = "/app";
	public static final String USERS_INTERFACE = APP_INTERFACE + "/users";
	public static final String LOGIN_INTERFACE = "/login.do";
	public static final String REGIST_INTERFACE = "/regist.do";
	//管理地址常量
	public static final String NO_HERF = "#";
	public static final String ADMIN_INTERFACE = "/admin";
	public static final String MANAGER_INTERFACE = ADMIN_INTERFACE + "/manager";
	public static final String USERLIST_INTERFACE = ADMIN_INTERFACE + "/userList";
	public static final String USERINFO_INTERFACE = ADMIN_INTERFACE + "/editUserInfo";
	public static final String NEW_USERINFO_INTERFACE = ADMIN_INTERFACE + "/addUserInfo";
	public static final String GET_USERINFO_LIST_INTERFACE = ADMIN_INTERFACE + "/getUserInfoPage.do";
	public static final String GET_USERINFO_INTERFACE = ADMIN_INTERFACE + "/getUserInfo.do";
	public static final String UPDATE_USERINFO_INTERFACE = ADMIN_INTERFACE + "/updateUserInfo.do";
	public static final String DELETE_USERINFO_INTERFACE = ADMIN_INTERFACE + "/deleteUserInfo.do";
	public static final String ADD_USERINFO_INTERFACE = ADMIN_INTERFACE + "/addUserInfo.do";
	//session信息常量
	public static final String SESSION_USER_INFO = "userInfo";
	//header信息常量
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String HEADER_TOKEN = "token";
	//HQL常量
	//用户登录
	public static final String USER_LOGIN_HQL = "from Users where userName = :username and "
			+ "password = :password and status = :status and isDeleted = :isDeleted";
	//用户注册时检查用户名是否注册过
	public static final String USER_REGIST_CHECK_HQL = "from Users where username = :username and isDeleted = :isDeleted";
	public static final String USER_GET_BY_TOKEN_HQL = "from Users where token = :token and isDeleted = :isDeleted";
	public static final String USER_GET_USER_PAGE_HQL = "select new com.hitwh.api.model.UserInfo(id,username,password,token) from Users where isDeleted = :isDeleted";
	public static final String USER_GET_USER_INFO_HQL = "select new com.hitwh.api.model.UserInfo(id,username,password,token) from Users where id = :id and isDeleted = :isDeleted";
	//数据库通用字段常量
	public static final String DB_ID = "id";
	public static final String DB_STATUS = "status";
	public static final String IS_DELETED = "isDeleted";
	public static final Integer NOT_DELETED = 0;
	public static final Integer DELETED = 1;
	//视图常量
	public static final String BASE_RESULT_NAME = "result";
	public static final String MODEL_TOKEN_ATTRIBUTE = "token";
	public static final String ADMIN_REDIRECT_VIEW = "redirect:/admin";
	public static final String LOGIN_VIEW = "login.jsp";
	public static final String INDEX_VIEW = "/page/admin/index.htm";
	public static final String USERLIST_VIEW = "/page/admin/userList.htm";
	public static final String EDIT_USERINFO_VIEW = "/page/admin/userInfo.htm";
	public static final String ADD_USERINFO_VIEW = "/page/admin/addUserInfo.htm";
	//Users常量
	public static final String STATUS_USERS_NORMAL = "01010100";
	public static final String DB_USERS_USERNAME = "username";
	public static final String DB_USERS_PASSWORD = "password";
	public static final String DB_USERS_TOKEN = "token";
	
	//其他常量
	public static final String DEFULT_PORTRAIT = "http://s16.sinaimg.cn/mw690/003gRgrCzy73OGZAV434f&690";
	//返回消息常量
	public static String STATUS_SUCCESS = "01010100"; // 有效
	public static String LOGIN_SUCCESS = "登录成功"; //99010101
	public static String LOGIN_WRONG_PASSWORD = "账号/密码错误"; //99010102
	public static String REGIST_SUCCESS = "注册成功";//99010201
	public static String HAVE_REGISTED = "账号已被注册";//99010202
	public static String INVALID  = "账号不合法";//99010203
	public static String UPDATE_SUCCESS = "更新成功";//99010301
	public static String UPDATE_FAILED = "更新失败，参数不合法";//99010302
	public static String SAVE_SUCCESS = "保存成功";//99010401
	public static String SAVE_FAILED = "保存失败，参数不合法";//99010402
	//特殊含义常量
	public static String NO_COMPANY_PHONE = "";//厂家没有电话;
	public static String NO_COMPANY_ADDRESS = "";//厂家没有地址;
	public static String DEFAULT_COMPANY = "未知";
	public static String NO_ATTENTION = "无";//没有注意事项

	// headphoto默认网址
	public static String HEADPHOTO_DEFAULT_URL = "/resources/images/user-orange.png";

}
