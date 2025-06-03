package com.saeyan.dto; // 이 클래스는 com.saeyan.dto 패키지에 속해 있다.

/*
	name varchar2(30) NOT null,
    userid varchar2(30),
    pwd varchar2(20) NOT null,
    email varchar2(30),
    phone char(13), 
    admin number(1) default 0,
    primary key(userid)
 */

public class MemberVO {
	// 주석에 해당하는 자바 필드들
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", userid=" + userid + ", pwd=" + pwd + ", email=" + email + ", phone="
				+ phone + ", admin=" + admin + "]";
	}
// 	Getter/Setter 각각의 필드에 대해 데이터를 가져오거나(set/get) 설정하는 역할
	public void setName(String name) {
		this.name = name;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public String getUserid() {
		return userid;
	}

	public String getPwd() {
		return pwd;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getAdmin() {
		return admin;
	}

}
