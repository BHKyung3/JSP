package com.saeyan.dto;

import java.sql.Timestamp;

/*
 	create table board(
    num number(5) PRIMARY key,
    pass varchar2(30),
    name varchar2(30),
    email varchar2(30),
    title varchar2(50),
    content varchar2(1000),
   readcount number(4) default 0, -- 조회수
   writedate date default sysdate -- 작성일
);
  */

public class BoardVO {
	
	private int num;
	private String pass;
	private String name;
	private String email;
	private String title;
	private String content;
	private int readCount;
	private Timestamp writeDate;
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", pass=" + pass + ", name=" + name + ", email=" + email + ", title=" + title
				+ ", content=" + content + ", readCount=" + readCount + ", writeDate=" + writeDate + "]";
	}
	public int getNum() {
		return num;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getReadCount() {
		return readCount;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

}
