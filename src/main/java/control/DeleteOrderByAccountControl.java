package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Order;
import entity.User;

@WebServlet("/delete-order-user")
public class DeleteOrderByAccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.sendRedirect("home");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");
			if (user.getIsAdmin() == 0) {

				Order order = new Order();
				order.setMa(Integer.parseInt(req.getParameter("ma")));
				order.setMaSP(Integer.parseInt(req.getParameter("maSP")));
				order.setTheLoai(Integer.parseInt(req.getParameter("theLoai")));
				order.setSoLuong(Integer.parseInt(req.getParameter("soLuong")));

				if (new DAO().deleteOrder(order)) {
					new DAO().plusLaptop(order);
					new DAO().plusCamera(order);
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
