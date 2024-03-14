package com.fpoly.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
//maxFileSize = 1024*10 (10MB), maxRequestSize = 1024*50 (50MB)
@MultipartConfig (maxFileSize = 1024*1000, maxRequestSize = 1024*5000)
@WebServlet("/Upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/Upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part file = request.getPart("file");
		String path = "/resources/files/" +file.getSubmittedFileName();
		String filename = request.getServletContext().getRealPath(path);
		System.out.println("filename: " + filename);
		file.write(filename);
		request.getRequestDispatcher("/views/Upload.jsp").forward(request, response);
	}

}
