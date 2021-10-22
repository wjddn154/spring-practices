package com.douzone.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douzone.aoptest.service.ProductService;
import com.douzone.aoptest.vo.ProductVO;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ac 
			= new ClassPathXmlApplicationContext("config/applicationContext.xml");

		ProductService ps = ac.getBean(ProductService.class);
		ProductVO vo = ps.find("TV");
		System.out.println(vo);
		
		((AbstractXmlApplicationContext)ac).close();
		
	}

}
