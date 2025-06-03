package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.saeyan.dto.ProductVO;

import oracle.jdbc.driver.DBConversion;
import util.DBManager;

public class ProductDAO {
	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {
	}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	// selectAllProducts 시작
	public List<ProductVO> selectAllProducts() { // DB에서 전체 목록을 가지고 온다 : selectAllProducts()
		String sql = "select * from Product order by code desc"; // desc 내림차순으로 정렬하여 불러온다
		
		List<ProductVO> list = new ArrayList<ProductVO>(); // ProductVO 값 또는 ProductVO 하위클래스만 불러온다
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1.DB 연결
			conn = DBManager.getConnection();
			// 2. SQL 구문 전송
			pstmt = conn.prepareStatement(sql);
			// 3. SQL 맴핑
			
			// 4. SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // 여러 건이라 사용한다 반복하면서 저장
				ProductVO pVo = new ProductVO(); 
				// 5회 반복
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
				
				 /*
			rs.getInt("code");
			rs.getString("name");
			rs.getInt("price");
			rs.getString("pictureurl");
			rs.getString("description");
				  */
				list.add(pVo); // 여기에 저장 하고 
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list; // 던치면 
		// selectAllProducts 끝
	}
	
	// inserProduct 시작
	public void inserProduct(ProductVO pVo) {

		String sql="insert into product values(product_seq.nextval, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1.DB 연결
			conn = DBManager.getConnection();
			// 2. SQL 구문 전송
			pstmt = conn.prepareStatement(sql);
			// 3. SQL 맴핑
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureurl());
			pstmt.setString(4, pVo.getDescription());
			// 4. SQL 실행
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	} // inserProduct 끝

	// selectProductByCode 시작
	public ProductVO selectProductByCode(String code) {

		String sql="select * from product where code = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductVO pVo =null; // pVo null 값으로 만들고
		try {
			// 1.DB 연결
			conn = DBManager.getConnection();
			// 2. SQL 구문 전송
			pstmt = conn.prepareStatement(sql);
			// 3. SQL 맴핑
			pstmt.setInt(1, Integer.parseInt(code));
			// 4. SQL 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pVo = new ProductVO(); // pVo 새로운거로 생성하고 
				// 5회 반복
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pVo; // pVo 반복한다
	} // selectProductByCode 끝

	public void updateProduct(ProductVO pVo) {

		String sql= "update product set name=?, price=?, pictureurl=?, description=? where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1.DB 연결
			conn = DBManager.getConnection();
			// 2. SQL 구문 전송
			pstmt = conn.prepareStatement(sql);
			// 3. SQL 맴핑
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureurl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setInt(5, pVo.getCode());
			// 4. SQL 실행
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteProductByCode(int code) {
		
		String sql= "delete from product where code =?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1.DB 연결
			conn = DBManager.getConnection();
			// 2. SQL 구문 전송
			pstmt = conn.prepareStatement(sql);
			// 3. SQL 맴핑
			pstmt.setInt(1, code);
			// 4. 실행
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}