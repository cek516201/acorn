package com.example.boot05.dao;

import java.util.List;

import com.example.boot05.dto.EmployeeDto;

public interface EmployeeDao {
	public List<EmployeeDto> getList();
}