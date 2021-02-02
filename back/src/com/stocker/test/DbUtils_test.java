package com.stocker.test;

import java.sql.Connection;

import com.stocker.utils.DbUtils;

public class DbUtils_test {
	
	public static void main(String[] args) {
		Connection con = null;
		
		try {
			con = DbUtils.getCon();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				DbUtils.close(con, null);
				System.out.println("닫기 성공");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
