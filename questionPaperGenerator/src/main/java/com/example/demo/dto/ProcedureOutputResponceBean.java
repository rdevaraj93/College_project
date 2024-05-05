package com.example.demo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProcedureOutputResponceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer po_new_id;
	private Integer po_success_flag;
	private String po_message;
	
	public ProcedureOutputResponceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProcedureOutputResponceBean(Integer po_user_id, Integer po_success_flag, String po_message) {
		super();
		this.po_new_id = po_user_id;
		this.po_success_flag = po_success_flag;
		this.po_message = po_message;
	}

	public Integer getPo_new_id() {
		return po_new_id;
	}

	public void setPo_new_id(Integer po_user_id) {
		this.po_new_id = po_user_id;
	}

	public Integer getPo_success_flag() {
		return po_success_flag;
	}

	public void setPo_success_flag(Integer po_success_flag) {
		this.po_success_flag = po_success_flag;
	}

	public String getPo_message() {
		return po_message;
	}

	public void setPo_message(String po_message) {
		this.po_message = po_message;
	}
	
}
