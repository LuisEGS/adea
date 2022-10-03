package com.adea.examen.dto;

import java.util.Map;

public class ObjResponse {
	private boolean error = false;
	private String  errorDesc = "";
	private Map<String, Object> data;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public ObjResponse() {
		super();
	}
	
	
}
