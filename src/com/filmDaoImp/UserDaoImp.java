package com.filmDaoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.filmDao.UserDao;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UserDaoImp implements UserDao {

	@Override
	public boolean login(Connection conn, String name) throws SQLException {
		// TODO Auto-generated method stub
//		PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE name = ? AND password = ?");
//		ps.setString(1, user.getName());
//		ps.setString(2, user.getPassword());
//		return ps.executeQuery();
		
		boolean b=false;
//		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM film WHERE name = ?");
//		ps.setString(1, name);
//		String str = "so ：sa ："+sn+" ss ：";
//        String sql1 = "select * from student where sn= '"+sn+"'; ";
		String name1=name;
		String sql="SELECT first_name FROM customer WHERE first_name = '"+name1+"'; ";
		PreparedStatement pstmt;
		//Statement st = (Statement) conn.createStatement();
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
//        pstmt.setString(1, student.getName());
//        pstmt.setString(2, student.getSex());
//        pstmt.setString(3, student.getAge());
       // pstmt.setString(1, name);//创建用于执行静态sql语句的Statement对象，st属局部变量  
//
		ResultSet rs = pstmt.executeQuery(sql); //执行sql查询语句，返回查询数据的结果集  
		if(rs.next()){
			b=true;
			
		}
		return b;
		
	
	}

}
