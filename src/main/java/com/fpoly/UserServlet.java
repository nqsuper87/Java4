package com.fpoly;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fpoly.bean.User;
import com.fpoly.dao.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/User","/User/edit/*","/User/create","/User/update","/User/delete"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Khởi tạo một đối tượng UserDAO để thực hiện các thao tác với cơ sở dữ liệu
        UserDAO userDao = new UserDAO();
        // Khởi tạo một đối tượng User để lưu trữ thông tin về người dùng
        User user = new User();

        // Lấy URI của request để xác định hành động cần thực hiện
        String uri = req.getRequestURI();

        // Nếu URI chứa "edit", nghĩa là muốn chỉnh sửa thông tin người dùng
        if (uri.contains("edit")) {
            String id = uri.substring(uri.lastIndexOf("/") + 1);
            // Tìm kiếm người dùng theo ID và gán vào đối tượng user
            user = userDao.findById(id);
            req.setAttribute("userForm", user);
        }
        // Nếu URI chứa "create", nghĩa là muốn tạo mới người dùng
        else if (uri.contains("create")) {
            try {
                // Đổ dữ liệu từ request vào đối tượng user bằng phương thức populate của BeanUtils
                BeanUtils.populate(user, req.getParameterMap());

                // Thêm người dùng vào cơ sở dữ liệu
                userDao.create(user);

                req.setAttribute("message", "Thêm người dùng mới thành công");
            } catch (IllegalAccessException | InvocationTargetException e) {
                req.setAttribute("message", "Lỗi thêm người dùng mới");
                e.printStackTrace();
            }
        }
        // Nếu URI chứa "update", nghĩa là muốn cập nhật thông tin người dùng
        else if (uri.contains("update")) {
            try {
                BeanUtils.populate(user, req.getParameterMap());

                // Cập nhật thông tin của người dùng trong cơ sở dữ liệu
                userDao.update(user);

                req.setAttribute("message", "Cập nhật người dùng thành công");
            } catch (IllegalAccessException | InvocationTargetException e) {
                req.setAttribute("message", "Lỗi cập nhật người dùng");
                e.printStackTrace();
            }
        }
        // Nếu URI chứa "delete", nghĩa là muốn xóa người dùng
        else if (uri.contains("delete")) {
            try {
                String id = req.getParameter("id");
                // Tìm kiếm người dùng theo ID để xóa
                user = userDao.findById(id);
                // Xóa người dùng khỏi cơ sở dữ liệu
                userDao.delete(user);
                req.setAttribute("message", "Xóa người dùng thành công");
            } catch (Exception e) {
                req.setAttribute("message", "Lỗi xóa người dùng");
                e.printStackTrace();
            }
        }
        // Nếu không phải các hành động trên, reset form để thêm mới người dùng
        else {
            req.setAttribute("userForm", user);
        }

        // Lấy danh sách tất cả người dùng từ cơ sở dữ liệu và gán vào thuộc tính 'users' của request
        List<User> users = userDao.findAll();
        req.setAttribute("users", users);

        // Chuyển hướng request đến trang hiển thị thông tin người dùng
        req.getRequestDispatcher("/views/User.jsp").forward(req, resp);
    }
}
