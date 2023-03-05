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

@WebServlet("/delete-laptop")
public class DeleteLaptopControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.sendRedirect("management-laptop");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");
			if (user.getIsAdmin() == 1) {
				new DAO().deleteLaptop(req.getParameter("ma"));
				resp.sendRedirect("management-laptop");
			} else {
				resp.sendRedirect("login-admin");
			}
		} catch (Exception e) {
			resp.sendRedirect("login-admin");
		}
	}
}
