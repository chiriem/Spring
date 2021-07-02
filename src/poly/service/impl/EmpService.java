package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.EmpDTO;
import poly.persistance.mapper.IEmpMapper;
import poly.service.IEmpService;

@Service("EmpService")
public class EmpService implements IEmpService{

	@Override
	public List<EmpDTO> getEmpList() {
		// TODO Auto-generated method stub
		return empMapper.getEmpList();
	}
	
	@Resource(name="EmpMapper")
	IEmpMapper empMapper;
}
