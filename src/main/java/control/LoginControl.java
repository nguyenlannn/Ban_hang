package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.User;

@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setTaiKhoan(req.getParameter("taiKhoan"));
		user.setMatKhau(req.getParameter("matKhau"));
		User u = new DAO().login(user);
		if (u != null) {
			HttpSession session = req.getSession();
			session.setAttribute("acc", u);
			resp.sendRedirect("home");

		} else {
			req.setAttribute("loi", "Đăng nhập thất bại");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}

	}
}
