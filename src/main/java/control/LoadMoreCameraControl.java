package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Camera;

@WebServlet("/loadCamera")
public class LoadMoreCameraControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		int dem = Integer.parseInt(req.getParameter("camera"));
		List<Camera> list = new DAO().getNext6Camera(dem);
		PrintWriter out = resp.getWriter();
		for (Camera c : list) {
			out.println("<div class='camera col-12 col-sm-6 col-lg-4'>\r\n"
					+ "							<div class='card card-body'>\r\n"
					+ "								<a href='detail?ma=" + c.getMa() + "&theLoai=" + c.getTheLoai()
					+ "'\r\n"
					+ "									title='Xem chi tiết sản phẩm' style='color: black;'> <img\r\n"
					+ "									class='img-fluid' src='" + c.getAnh() + "'>\r\n"
					+ "									<h5 class='card-title'>" + c.getTen() + "</h5>\r\n"
					+ "								</a>\r\n"
					+ "								<p class='bloc_left_price'>" + c.getGia() + "<sup>đ</sup>\r\n"
					+ "								</p>\r\n" + "							</div>\r\n"
					+ "						</div>");
		}
	}
}
