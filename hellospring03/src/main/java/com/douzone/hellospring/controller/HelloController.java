package com.douzone.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	public void a() {
		
	}
	
	public void b() {
		
	}
	
	public void c() {
		
	}
	
	@RequestMapping("/hello") // 어노테이션 : 'hello' 라는 요청이 들어왔을 때 실행
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}

	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		// ModelAndView : View와 Model 둘다 return 해야함
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");

		return mav;
	}

	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);

		return "/WEB-INF/views/hello3.jsp";
	}

	// @ResponseBody : 이 메소드가 직접 return 타입을 쓰겠다
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {

		return "<h1>hello world5</h1>";
	}

	@RequestMapping("/hello6")
	public String hello6() {
		System.out.println("hello6() called");
		return "redirect:/hello";
	}
	
	@RequestMapping("/hello7")
	public void hello7 (HttpServletRequest request, HttpServletResponse response, HttpSession session, Writer out)  throws IOException {
		String no = request.getParameter("n");
			out.write("<h1>Hello World</h1>");
	}
	
	
	
	
}