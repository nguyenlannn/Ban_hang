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

@WebServlet("/logup")
public class LogupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Logup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setTaiKhoan(req.getParameter("taiKhoan"));
		user.setEmail(req.getParameter("email"));
		user.setMatKhau(req.getParameter("matKhau"));
		if (new DAO().logup(user)) {
			User u = new DAO().login(user);
			HttpSession session = req.getSession();
			session.setAttribute("acc", u);
			resp.sendRedirect("home");
		} else {
			req.setAttribute("loi", "Tài khoản hoặc email đã được đăng ký trước đó");
			req.getRequestDispatcher("Logup.jsp").forward(req, resp);
		}
	}

}
