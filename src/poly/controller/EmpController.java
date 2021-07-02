package poly.controller;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

import poly.dto.EmpDTO;
import poly.service.IEmpService;

@Controller
public class EmpController {
	
	//로거
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "EmpService")
	IEmpService empService;
	
	@RequestMapping(value="scott/empList")
	public String EmpList(ModelMap model) {
		// 해당 매서드가 호출됨을 로그로 기록
		log.info("empList start!!");
		
		List<EmpDTO> rList = empService.getEmpList();
		
		if (rList == null) {
			rList = new ArrayList<>();
		}
		
		for (EmpDTO rDTO : rList) {
			log.info("empno : " + rDTO.getEmpno());
		}
		
		model.addAttribute("rList", rList);
		
		return "/scott/empList";
	}
}
