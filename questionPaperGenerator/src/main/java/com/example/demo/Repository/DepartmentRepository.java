package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.DepartmentViewEntiry;
import com.example.demo.Entity.ExamQuestionListViewEntity;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentViewEntiry, Integer> {
	@Query("SELECT questionlist FROM DepartmentViewEntiry questionlist")
	public List<DepartmentViewEntiry> getAllDepartment();	
}



