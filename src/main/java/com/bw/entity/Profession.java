package com.bw.entity;


public class Profession implements java.io.Serializable {

	//columns START
	private Integer pid;
	private String pname;
	//columns END
	public Profession(){
	}
	public Profession(Integer pid,String pname){
		this.pid=pid;		this.pname=pname;	}

	public void setPid(Integer pid){
		this.pid=pid;
	}
	public Integer getPid(){
		return pid;
	}

	public void setPname(String pname){
		this.pname=pname;
	}
	public String getPname(){
		return pname;
	}
}

