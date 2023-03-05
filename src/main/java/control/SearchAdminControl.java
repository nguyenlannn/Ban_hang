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

@WebServlet("/search-admin")
public class SearchAdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF8");
		req.setCharacterEncoding("UTF-8");
		try {

			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");
			if (user.getIsAdmin() == 1) {
				
				String txt=req.getParameter("txt");
				req.setAttribute("listCamera",new DAO().getSearchByNameCamera(txt));
				req.setAttribute("listLaptop",new DAO().getSearchByNameLaptop(txt));
				req.setAttribute("txt",txt);
				req.setAttribute("listCategory", new DAO().getAllCategory());
				req.setAttribute("sumC", new DAO().getAllCamera().size());
				req.setAttribute("sumL", new DAO().getAllLaptop().size());
				req.getRequestDispatcher("ProductManagement.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("login-admin");
			}
		} catch (Exception e) {
			resp.sendRedirect("login-admin");
		}
	}
}
