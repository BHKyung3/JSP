
// 오라클에서 만든 product  테이블과 1:1로 매핑되는 클래스

package com.saeyan.dto;

/*
 	code number(5) primary key,
	name varchar2(100),
	price number(8),
	pictureurl varchar2(50),
	description varchar2(1000)
 * */

public class ProductVO { // 클래스 선언!! ProductVO : ???VO가 기재되어 있는 경우 DB와 연결되어 있고 DB 테이블 명은 ???임을 알 수 있어야 한다
				// VO는 Value Object로, 읽기 전용의 데이터 객체를 의미
	
	// private 접근 제한자를 사용해 클래스 외부에서 직접 접근 불가
	private int code; // 필드 5개
	private String name;
	private int price;
	private String pictureurl;
	private String description;
	
	@Override // toString() 메소드 : 객체를 문자열로 표현할 때 자동 호출
	public String toString() {
		return "ProductVO [code=" + code + ", name=" + name + ", price=" + price + ", pictureurl=" + pictureurl
				+ ", description=" + description + "]";
	}
	// getter 메소드 : 각 필드의 값을 읽올 때 사용
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public String getDescription() {
		return description;
	}
	// setter 메소드 : 외부에서 값을 설정할 때 사용
	public void setCode(int code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
	
