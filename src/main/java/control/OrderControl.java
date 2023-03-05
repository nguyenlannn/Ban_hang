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

@WebServlet("/order")
public class OrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		Order order = new Order();
		order.setTheLoai(Integer.parseInt(req.getParameter("theLoai")));
		order.setMaSP(Integer.parseInt(req.getParameter("ma")));
		order.setTen(req.getParameter("ten"));
		order.setAnh(req.getParameter("anh"));
		order.setSoLuong(Integer.parseInt(req.getParameter("soLuong")));
		
		
		order.setGia((long)(Double.parseDouble(req.getParameter("gia"))));
		
		order.setGia(order.getGia() * order.getSoLuong());

		order.setDiaChi(req.getParameter("diaChi"));
		order.setSdt(req.getParameter("soDienThoai"));
		order.setMaKH(Integer.parseInt(req.getParameter("maKH")));

		if (order.getTheLoai() == 1) {
			if (order.getSoLuong() <= new DAO().getDetailByLaptop(order.getMaSP(), order.getTheLoai()).getSoLuong()
					&& new DAO().getDetailByLaptop(order.getMaSP(), order.getTheLoai()).getSoLuong() > 0) {
				if (new DAO().order(order)) {
					new DAO().minusLaptop(order);
					req.setAttribute("success", "1");
				} else {
					req.setAttribute("fail", "1");
				}
			} else {
				req.setAttribute("fail", "1");
			}
		} else {
			if (order.getSoLuong() <= new DAO().getDetailByCamera(order.getMaSP(), order.getTheLoai()).getSoLuong()
					&& new DAO().getDetailByCamera(order.getMaSP(), order.getTheLoai()).getSoLuong() > 0) {
				if (new DAO().order(order)) {
					new DAO().minusCamera(order);
					req.setAttribute("success", "1");
				} else {
					req.setAttribute("fail", "1");
				}
			} else {
				req.setAttribute("fail", "1");
			}
		}

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

		req.setAttribute("topLaptop", new DAO().getDetailByLaptop(new DAO().getTopLaptop(), 1));
		req.setAttribute("topCamera", new DAO().getDetailByCamera(new DAO().getTopCamera(), 2));
		req.setAttribute("listCategary", new DAO().getAllCategory());
		req.setAttribute("detailLaptop", new DAO().getDetailByLaptop(order.getMaSP(), order.getTheLoai()));
		req.setAttribute("detailCamera", new DAO().getDetailByCamera(order.getMaSP(), order.getTheLoai()));
		req.getRequestDispatcher("Detail.jsp").forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("home");
	}
}
