package com.fpoly;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fpoly.bean.UserBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/BeanUtils.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Bai 2
//		String fullname = request.getParameter("fullName");
//		String age = request.getParameter("age");
//		String salary = request.getParameter("salary");
//		
//		System.out.println("Fullname: " + fullname);
//		System.out.println("Age: " + age);
//		System.out.println("Salary: " + salary);
//		
//		doGet(request, response);
		
//		Bai 3
		
		UserBean userBean = new UserBean();
		try {
			BeanUtils.populate(userBean, request.getParameterMap());
			System.out.println("UserBean:" + userBean.getFullname());
			System.out.println("UserBean:" + userBean.getCountry());
			System.out.println("UserBean:" + userBean.getSalary());
			System.out.println("UserBean:" + userBean.getGender());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
