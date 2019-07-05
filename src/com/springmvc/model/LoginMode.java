package com.springmvc.model;

import java.io.Serializable;

public class LoginMode extends BaseMode  implements Serializable {
	/*Alt + S */	
	/**
	 * 
	 */
	private Integer COLUMN1; // id
	private String NAME; // name
	private String PWD; // name
	private String COMESITEID; // name 
	public Integer getCOLUMN1() {
		return COLUMN1;
	}
	public void setCOLUMN1(Integer cOLUMN1) {
		COLUMN1 = cOLUMN1;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pWD) {
		PWD = pWD;
	}
	public String getCOMESITEID() {
		return COMESITEID;
	}
	public void setCOMESITEID(String cOMESITEID) {
		COMESITEID = cOMESITEID;
	}
	
}
