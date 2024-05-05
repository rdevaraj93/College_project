package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vw_department")
public class DepartmentViewEntiry {
		
	@Id
	@Column(name="Depart_id_pk")
	private Integer departmentID;
	
	@Column(name="depart_name")
	private String departmentName;
	
}
