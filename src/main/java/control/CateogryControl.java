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

@WebServlet("/category")
public class CateogryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String cid = req.getParameter("cid");
		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");
			req.setAttribute("orderAccount", new DAO().getOrderByAccount(user));
		} catch (Exception e) {
			// TODO: handle exception
		}
		req.setAttribute("cxn", "Chờ xác nhận");
		req.setAttribute("dg", "Đang giao");
		req.setAttribute("tc", "Thành công");

		req.setAttribute("listLaptop", new DAO().getLaptopByCID(cid));
		req.setAttribute("listCamera", new DAO().getCameraByCID(cid));
		req.setAttribute("listCategary", new DAO().getAllCategory());
		req.setAttribute("topLaptop", new DAO().getDetailByLaptop(new DAO().getTopLaptop(), 1));
		req.setAttribute("topCamera", new DAO().getDetailByCamera(new DAO().getTopCamera(), 2));
		req.setAttribute("tag", cid);
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}
}
