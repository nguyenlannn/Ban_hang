package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.User;
import service.Service;

@WebServlet("/get-password")
public class GetPasswordControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.getRequestDispatcher("GetPassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setTaiKhoan(req.getParameter("taiKhoan"));
		user.setEmail(req.getParameter("email"));
		if (new DAO().checkAccount(user) != null) {
			String s = new Service().random();
			new DAO().updatePassword(s, user);
			new Service().sendCode(user.getEmail(), s);
			req.setAttribute("thongBao", "Chúng tôi đã gửi một mật khẩu đến địa chỉ '"+user.getEmail()+"'. Bạn hãy sử dụng nó để đăng nhập vào tài khoản '"+user.getTaiKhoan()+"'");
			req.getRequestDispatcher("GetPassword.jsp").forward(req, resp);
		} else {
			req.setAttribute("loi", "Không tìm thấy");
			req.getRequestDispatcher("GetPassword.jsp").forward(req, resp);
		}
	}

}
