package com.example.boot05.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot05.dto.EmployeeDto;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public List<EmployeeDto> getList() {
		List<EmployeeDto> list = session.selectList("employee.getList");
		
		return list;
	}
	
	@Autowired
	private SqlSession session;
}