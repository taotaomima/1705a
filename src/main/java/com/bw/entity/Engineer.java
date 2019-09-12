package com.bw.entity;


public class Engineer implements java.io.Serializable {

	//columns START
	private Integer eid;
	private String ename;
	private String sex;
	private String area;
	private String registname;
	private String study;
	private Integer sid1;
	private Integer sid2;
	private String zycode;
	private String recode;
	private String edate;
	//columns END
	public Engineer(){
	}
	public Engineer(Integer eid,String ename,String sex,String area,String registname,String study,Integer sid1,Integer sid2,String zycode,String recode,String edate){
		this.eid=eid;		this.ename=ename;		this.sex=sex;		this.area=area;		this.registname=registname;		this.study=study;		this.sid1=sid1;		this.sid2=sid2;		this.zycode=zycode;		this.recode=recode;		this.edate=edate;	}

	public void setEid(Integer eid){
		this.eid=eid;
	}
	public Integer getEid(){
		return eid;
	}

	public void setEname(String ename){
		this.ename=ename;
	}
	public String getEname(){
		return ename;
	}

	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return sex;
	}

	public void setArea(String area){
		this.area=area;
	}
	public String getArea(){
		return area;
	}

	public void setRegistname(String registname){
		this.registname=registname;
	}
	public String getRegistname(){
		return registname;
	}

	public void setStudy(String study){
		this.study=study;
	}
	public String getStudy(){
		return study;
	}

	public void setSid1(Integer sid1){
		this.sid1=sid1;
	}
	public Integer getSid1(){
		return sid1;
	}

	public void setSid2(Integer sid2){
		this.sid2=sid2;
	}
	public Integer getSid2(){
		return sid2;
	}

	public void setZycode(String zycode){
		this.zycode=zycode;
	}
	public String getZycode(){
		return zycode;
	}

	public void setRecode(String recode){
		this.recode=recode;
	}
	public String getRecode(){
		return recode;
	}

	public void setEdate(String edate){
		this.edate=edate;
	}
	public String getEdate(){
		return edate;
	}
}

