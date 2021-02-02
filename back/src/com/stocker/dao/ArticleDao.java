package com.stocker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import com.stocker.dto.ArticleDto;
//import com.stocker.model.Article;
import com.stocker.utils.DbUtils;

public class ArticleDao {
	//DAO(data access object)
	//TODO create method : getArticle(id)
	
	public static List<ArticleDto> selectAll() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT "
				+ "a.id, title, nm AS author_nm, file_nm "
				+ "FROM t_article AS a "
				+ "JOIN t_user AS u "
				+ "ON author_id = u.id "
				+ "ORDER BY regdate DESC";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<ArticleDto> list = new ArrayList<>();
			
			while(rs.next()) {
				ArticleDto dto = new ArticleDto();
				
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor_nm(rs.getString("author_nm"));
				dto.setFile_nm(rs.getString("file_nm"));
//				System.out.println(dto);
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return null;
	}
	
	public static ArticleDto select(int id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT"
				+ " title, caption, regdate, file_nm, nm As author_nm"
				+ " FROM t_article as a"
				+ " JOIN t_user As u"
				+ " ON a.author_id = u.id"
				+ " WHERE a.id = ?";
		
		try {
			
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ArticleDto data = new ArticleDto();
				
				data.setId(id);
				data.setTitle(rs.getString("title"));
				data.setCaption(rs.getString("caption"));
				data.setRegdate(rs.getString("regdate"));
				data.setFile_nm(rs.getString("file_nm"));
				data.setAuthor_nm(rs.getString("author_nm"));
				
				return data;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		return null;
	}

}
