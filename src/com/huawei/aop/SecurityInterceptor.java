package com.huawei.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//import com.hitwh.api.service.UsersService;


/**
* @ClassName: SecurityInterceptor
* @ClassNameExplain: 安全拦截器
* @Description: 校验用户登录信息
* @author Ice
*/

public class SecurityInterceptor implements HandlerInterceptor {

//	@Autowired
//	private UsersService usersService;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		String token = (String) session.getAttribute(ConstUtil.HEADER_TOKEN);
//		Users users = this.usersService.getUsersByToken(token);
//		String authorization = request.getHeader(ConstUtil.HEADER_AUTHORIZATION);
//		if (users== null && authorization == null){
//            System.out.println(request.getRequestURI() + "AuthorizationException:未登录！"+request.getMethod());
//            if("POST".equalsIgnoreCase(request.getMethod())){
//                response.setContentType("text/html; charset=utf-8");
//                PrintWriter out = response.getWriter();
//                out.write(JSON.toJSONString(new BaseObjectResult<Object>(false,"未登录！")));
//                out.flush();
//                out.close();
//            }else{
//                response.sendRedirect(request.getContextPath()+"/");
//            }
//		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
