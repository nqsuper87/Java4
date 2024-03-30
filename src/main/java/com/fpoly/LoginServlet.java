package com.fpoly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpoly.bean.User;
import com.fpoly.bean.Video;

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
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PolyOE");
		EntityManager em = factory.createEntityManager();
		
		String jpql = "Select u from User u";
		TypedQuery<User> usersQuery = em.createQuery(jpql,User.class);
		//Tra ve ket qua cua user list
		List<User> users = usersQuery.getResultList();
		
		for (User user : users) {
			System.out.println("Fullname: " + user.getFullname());
			System.out.println("Email: " + user.getEmail());
		}
		
		
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
			//ck = new Cookie("userid","PC07654");
			HttpSession session = request.getSession();
			session.setAttribute("name","Quoc An");
			
			Video v = new Video();
			v.setTitle("Fpoly Youtube");
			v.setViews(10);
			
			Video v1 = new Video();
			v1.setTitle("Can Tho Youtube");
			v1.setViews(15);
			
			Video v2 = new Video();
			v2.setTitle("Java 4 Youtube");
			v2.setViews(20);
			
			List<Video> videos = new ArrayList<Video>();
			videos.add(v1);
			videos.add(v2);
			videos.add(v);
			
			request.setAttribute("videos", videos);
			//session.setAttribute("videos", videos);
				
			request.getRequestDispatcher("/views/Home.jsp").forward(request, response);
		}
		else {
			//ck = new Cookie("userid","");
			request.setAttribute("error", "Dang nhap sai email va password");
			request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
		}
//		ck.setMaxAge(10*3600);
//		ck.setPath("/");
//		response.addCookie(ck);
		//doGet(request, response);
	}
}
