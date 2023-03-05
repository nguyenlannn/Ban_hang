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

@WebServlet("/set-account")
public class SetAccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("home");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");

		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");

			if (user.getIsAdmin() == 0) {
				User user1 = new User();
				user1.setMa(user.getMa());
				user1.setTaiKhoan(req.getParameter("taiKhoan"));
				user1.setEmail(req.getParameter("email"));
				user1.setMatKhau(req.getParameter("matKhau"));
				user1.setSdt(req.getParameter("sdt"));
				user1.setDiaChi(req.getParameter("diaChi"));

				if (new DAO().setAccount(user1)) {
					session.invalidate();
				}
				resp.sendRedirect("home");

			} else {
				resp.sendRedirect("login");
			}
		} catch (Exception e) {
			resp.sendRedirect("login");
		}
	}

}
