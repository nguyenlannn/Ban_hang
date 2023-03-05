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

@WebServlet("/management-order")
public class ManagementOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF8");
		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");
			
			if (user.getIsAdmin() == 1) {
				req.setAttribute("cxn", "Chờ xác nhận");
				req.setAttribute("dg", "Đang giao");
				req.setAttribute("tc", "Thành công");
				req.setAttribute("listOrder", new DAO().getAllOrder());
				req.setAttribute("choXacNhan", new DAO().cxn());
				req.setAttribute("dangGiao", new DAO().dg());
				req.setAttribute("thanhCong", new DAO().tc());
				req.getRequestDispatcher("OrderManagement.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("login-admin");
			}
		} catch (Exception e) {
			resp.sendRedirect("login-admin");
		}
	}

}
