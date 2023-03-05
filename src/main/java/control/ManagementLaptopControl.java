package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Laptop;
import entity.User;

@WebServlet("/management-laptop")
public class ManagementLaptopControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF8");
		try {

			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");
			if (user.getIsAdmin() == 1) {
				req.setAttribute("listCategory", new DAO().getAllCategory());
				
				req.setAttribute("listLaptop", new DAO().getAllLaptop());
				req.setAttribute("sumL", new DAO().getAllLaptop().size());
				req.setAttribute("sumC", new DAO().getAllCamera().size());
				req.setAttribute("tag", "Laptop");
				req.getRequestDispatcher("ProductManagement.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("login-admin");
			}
		} catch (Exception e) {
			resp.sendRedirect("login-admin");
		}
	}
}
