/* 
 	DB 연결
 	DB 테이블의 정보를 자바에서 얻어와 저장할 공간
 	DB 테이블에서 회원 정보를 얻어와 VO에 저장한다
 */

/*
  	id VARCHAR2(10) not null,
    pass VARCHAR2(10) not null,
    name VARCHAR2(24),
    lev char(1) DEFAULT 'A', -- A : 운영자, B : 일반회원
    enter date default sysdate, -- 등록일
    gender char(1) DEFAULT '1', -- 1 : 남자, 2 : 여자
    phone VARCHAR2(30),
 */

package com.magic.dto;

public class EmployeesVO {
	
	private String id; // 아이디
	private String pass; // 비밀번호
	private String name; // 이름
	private String lev; // 회원등급
	private String enter; // 등록일
	private String gender; // 성별
	private String phone; // 연락처
	
	// 자동으로 오바리이딩된 toString
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", lev=" + lev + ", enter=" + enter
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}
	// 자동 추가된 setter, getter 
	public void setId(String id) {
		this.id = id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public void setEnter(String enter) {
		this.enter = enter;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public String getLev() {
		return lev;
	}
	public String getEnter() {
		return enter;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}

}
