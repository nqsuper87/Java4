package com.fpoly;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			Cookie ck = cookies[i];
			String cookieName = ck.getName();
			String cookieValue = ck.getValue();
			if(cookieName.equals("userid")) {
				if(cookieValue.equals("PC07654")) {
					response.getWriter().append("Chao " + "Vo Quoc An!").append(request.getContextPath());
					return;
				}
			}
		}
		
		response.getWriter().append("Nguoi dung chua xac thuc").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Cookie ck;
		
		if(email.equals("fpoly@fpt.edu.vn") && password.equals("fpolycantho")) {
			//userid is PC07654 - Võ Quốc An
			ck = new Cookie("userid","PC07654");
		}
		else {
			ck = new Cookie("userid","");
		}
		
		ck.setMaxAge(10*3600);
		ck.setPath("/");
		response.addCookie(ck);
		
		doGet(request, response);
	}

}
