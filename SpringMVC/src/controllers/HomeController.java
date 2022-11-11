package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping({"/", "/home"})
	public String home() {

//		return "home"; //viewResolver: prefix + viewName + suffix = "/WEB-INF/views/home.jsp
		return "chao";  //trả về tên định nghĩa trong tiles.xml
	}
	
	//cookie
	@RequestMapping("/setCookie")
	@ResponseBody
	public String setCookie(HttpServletResponse response) {
		Cookie ck1 = new Cookie("brif","Chill");
		Cookie ck2 = new Cookie("ten", "Chi");
		response.addCookie(ck1);
		response.addCookie(ck2);
		return "Da thiet lap cookie"; //response body
	}
	@RequestMapping("/getCookie")
	@ResponseBody
	public String getCookie(HttpServletRequest request) {
		Cookie[] mck = request.getCookies();
		String ten ="";
		for(Cookie ck : mck) {
			if(ck.getName().equals("ten")) {
				ten = ck.getValue();
			}
		}
		return "Lay cookie ten la: " +ten; //response body
	}
	
	@RequestMapping("/getCookies")
	@ResponseBody
	public String getCookies(HttpServletRequest request) {
		Cookie[] mck = request.getCookies();
		List<String> cks = new ArrayList<>();
		for(Cookie ck : mck) {
			if(ck.getName().equals("ten")) {
				cks.add(ck.getValue());
			}
		}
		return "Cookies: " + cks.toString(); //response body
	}
	
	//
	@RequestMapping("/getCookie2")
	@ResponseBody
	public String getCookie2(@CookieValue(name = "ten") String ten) {
		return "Lay cookie ten la: " +ten; //response body
	}
}
