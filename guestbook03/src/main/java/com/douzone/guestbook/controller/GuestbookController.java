package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVO;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVO> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String add(GuestbookVO vo) {
		guestbookRepository.insert(vo);
		
		return "redirect:/";
	}
	
//	@RequestMapping(value="/deleteform/{no}", method = RequestMethod.GET)
//	public String form(@PathVariable("no") int boardNo) {
//		System.out.println("boardNo : " + boardNo);
//		
//		return "/WEB-INF/views/deleteform.jsp";
//	}
	
	@RequestMapping(value="/deleteform", method = RequestMethod.GET)
	public String form(@RequestParam(value="no", required=true, defaultValue="1") int boardNo) {
		
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(GuestbookVO vo) {
		guestbookRepository.delete(vo.getNo(), vo.getPassword());
		
		return "redirect:/";
	}
	
	
	
}