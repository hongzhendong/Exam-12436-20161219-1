package com.filmDaoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.filmDao.FilmDao;
import com.javabean.Film;
import com.mysql.jdbc.Statement;


public class filmDaoImp implements FilmDao {

	public void save(Connection conn, Film film) throws SQLException {
		String sql="INSERT INTO film values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, film.getFilm_id());
		ps.setString(2, film.getTitle());
		ps.setString(3, film.getDescription());
		ps.setDate(4, film.getRelease_year());
		ps.setInt(5, film.getLangguage_id());
		ps.setInt(6, film.getOriginal_language_id());
		ps.setInt(7, film.getRental_duration());
		ps.setInt(8, film.getRental_rate());
		ps.setInt(9, film.getLength());
		ps.setInt(10, film.getReplacement_cost());
		ps.setString(11, film.getRating());
		ps.setString(12, film.getSpecial_features());
		ps.setDate(13, film.getLast_update());
		ps.execute();
		
//		String sql="SELECT * FROM film WHERE name = ?";
//		Statement st = (Statement) conn.createStatement();
//		((PreparedStatement) st).setString(1, name);//创建用于执行静态sql语句的Statement对象，st属局部变量  
//
//		ResultSet rs = st.executeQuery(sql); //执行sql查询语句，返回查询数据的结果集  
//	

	}

	@Override
	public void update(Connection conn, Long id, Film film) throws SQLException {
		// TODO Auto-generated method stub
//		String updateSql = "UPDATE tbl_user SET name = ?, password = ?, email = ? WHERE id = ?";
//		PreparedStatement ps = conn.prepareStatement(updateSql);
//		ps.setString(1, user.getName());
//		ps.setString(2, user.getPassword());
//		ps.setString(3, user.getEmail());
//		ps.setLong(4, id);
//		ps.execute();
//		
	}

	@Override
	public void delete(Connection conn, Film film) throws SQLException {
		// TODO Auto-generated method stub
//		PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_user WHERE id = ?");
//		ps.setLong(1, user.getId());
//		ps.execute();
//		
	}

	@Override
	public ResultSet get(Connection conn, Film film) throws SQLException {
//		PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_user WHERE name = ? AND password = ?");
//		ps.setString(1, user.getName());
//		ps.setString(2, user.getPassword());
//		return ps.executeQuery();
		return null;
	}



}
