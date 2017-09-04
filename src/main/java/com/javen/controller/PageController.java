package com.javen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.interceptor.annotation.Sessionannotation;
import com.javen.model.User;

@RequestMapping("/")
@Controller
public class PageController {

	// 登录首页
	@RequestMapping("/login")

	public String login(HttpServletRequest request) {
		try {
			request.getSession().removeAttribute("user");// 重新登录删除session缓存
			System.out.println("删除成功");

		} catch (Exception e) {
			System.out.println("删除失败");
		}

		return "login";

	}

	// 注册首页
	@RequestMapping("/register")
	public String register() {
		return "register";

	}

	// 登录后首页
	@RequestMapping("/main")
	@Sessionannotation(CheckSeesion =true)
	public String main(HttpServletRequest request) {

		User attribute = (User) request.getSession().getAttribute("user");

		System.out.println(attribute);
		if (attribute != null) {

			return "main";
		}

		else {
			return "login";
		}

	}

	// 错误页面404首页
	@RequestMapping("/error")
	public String error() {
		return "error";

	}

	@RequestMapping("/top")
	@Sessionannotation(CheckSeesion =true)
	public String top() {
		return "top";

	}

	@RequestMapping("/left")
	@Sessionannotation(CheckSeesion =true)
	public String left() {
		return "left";

	}

	@RequestMapping("/index")
	@Sessionannotation(CheckSeesion =true)
	public String index() {
		return "index";

	}

	@RequestMapping("/UrlIndex")
	@Sessionannotation(CheckSeesion =true)
	public String UrlIndex() {
		return "UrlIndex";

	}

	@RequestMapping("/insert")
	@Sessionannotation(CheckSeesion =true)
	public String insert() {
		return "insert";

	}
	
	@RequestMapping("/remosession")
	@ResponseBody
	public String remosession( HttpServletRequest request) {
		
		
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			return "success";
		
		
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		

	}

}
