package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.filmDao.UserDao;
import com.filmDaoImp.UserDaoImp;
import com.util.ConnectionFactory;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 747710184283333182L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得参数username的值
		ConnectionFactory cf = ConnectionFactory.getInstance();		
		Connection conn = cf.makeConnection();
		UserDao userdao=new UserDaoImp();
		//boolean st=false;
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("upwd");
		String returnUri = request.getParameter("return_uri");
		System.out.println("用户名 ==》 " + uname);
		System.out.println("密码 ==》 " + passwd);
		System.out.println("return uri ==> " + returnUri);

		RequestDispatcher rd = null;
		if (uname == null || passwd == null) {
			request.setAttribute("msg", "用户名或密码为空");
			rd = request.getRequestDispatcher("/JSP/login.jsp");
			rd.forward(request, response);
		} else {
//			if (uname.equals("123") && passwd.equals("123")) {
			try {
				if (userdao.login(conn, uname)) {
					request.getSession().setAttribute("flag", "login_success");
					if (returnUri != null) {
						rd = request.getRequestDispatcher(returnUri);
						rd.forward(request, response);
					} else {
						rd = request.getRequestDispatcher("/JSP/index.jsp");
						rd.forward(request, response);
					}
				} else {
					request.getSession().setAttribute("flag", "login_error");
					request.setAttribute("msg", "用户名或密码错误！");
					rd = request.getRequestDispatcher("/JSP/login.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
