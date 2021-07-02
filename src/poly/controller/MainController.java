package poly.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.EmpDTO;
import poly.service.impl.EmpService;


@Controller
public class MainController {
	
	// 로깅을 위한 객체
	private Logger log = Logger.getLogger(this.getClass());
	
	
	
	@RequestMapping(value="jsw")
	public String goJsw(ModelMap model) {
		
		// 해당 매서드가 호출됨을 로그로 기록
		log.info(this.getClass());
		
		String nicName = "장석원";
		
		model.addAttribute("nicName", nicName);
		
		return "/jsw";
	}
	
	
	@RequestMapping(value="index")
	public String Index() {
		// 해당 매서드가 호출됨을 로그로 기록
		log.info(this.getClass());
		
		return "/index";
	}
	
	@RequestMapping(value="table")
	public String Table() {
		// 해당 매서드가 호출됨을 로그로 기록
		log.info(this.getClass());
		
		return "/table";
	}
	
	@RequestMapping(value="get")
	public String Get(HttpServletRequest request, ModelMap model) throws Exception{
		String name = request.getParameter("name");
		
		model.addAttribute("name", name);
		
		return "/get";
	}
	
	
}
