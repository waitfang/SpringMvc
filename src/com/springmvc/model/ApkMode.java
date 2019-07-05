package com.springmvc.model;

import java.io.File;
import java.io.Serializable;

public class ApkMode  extends BaseMode  implements Serializable{

	private String serverapkpath; // name
	
	private String apkpath; // name

	private String versions; // name

	private String key0jks; // name

	private String keyAlias; // name

	private String keypass; // name

	private String keyStorepass; // name 
  

	public String getServerapkpath() {
		return serverapkpath;
	}

	public void setServerapkpath(String serverapkpath) {
		this.serverapkpath = serverapkpath;
	}

	public String getApkpath() {
		return apkpath;
	}

	public void setApkpath(String apkpath) {
		this.apkpath = apkpath;
	}

	public String getKey0jks() {
		return key0jks;
	}

	public void setKey0jks(String key0jks) {
		this.key0jks = key0jks;
	}

	public String getVersions() {
		return versions;
	}

	public void setVersions(String versions) {
		this.versions = versions;
	}
 

	public String getKeyAlias() {
		return keyAlias;
	}

	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}

	public String getKeypass() {
		return keypass;
	}

	public void setKeypass(String keypass) {
		this.keypass = keypass;
	}

	public String getKeyStorepass() {
		return keyStorepass;
	}

	public void setKeyStorepass(String keyStorepass) {
		this.keyStorepass = keyStorepass;
	}
	
	
	

}
