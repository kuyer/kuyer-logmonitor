package io.github.kuyer.logmonitor.model;

import java.io.Serializable;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = 4826335843797395371L;
	private String code;
	private String desc;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
