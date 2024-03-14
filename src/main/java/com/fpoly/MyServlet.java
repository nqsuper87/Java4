package com.fpoly;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Do Get");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/Bai2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("@@@@ Service");
		
		System.out.println("getContextPath:" + request.getContextPath());
		System.out.println("getRequestURI:" + request.getRequestURI());
		System.out.println("getRequestURL:" + request.getRequestURL());
		
		Enumeration<String> names = request.getParameterNames();
		
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getParameter(name);
			
			System.out.println("name" + name);
			System.out.println("value" + value);
		}
	
		
		
		String method = request.getMethod();
		System.out.println(method);
		
		if(method.equals("POST")) {
			// TODO Auto-generated method stub
			String name = request.getParameter("fullname");
			String[] hobbies = request.getParameterValues("hobbies");
			
			System.out.println("Fullname: " + name);
				
			for (int i = 0; i < hobbies.length; i++) {
				System.out.println("Hobbies: " + hobbies[i]);
			}
		}
	}

}
