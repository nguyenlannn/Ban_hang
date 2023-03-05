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
import entity.Laptop;
import service.Service;

@WebServlet("/search")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txtSearch = req.getParameter("txt");
		if (txtSearch.equals("")) {
			txtSearch = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";
		}

		List<Laptop> listLaptop = new DAO().getSearchByNameLaptop(txtSearch);
		List<Camera> listCamera = new DAO().getSearchByNameCamera(txtSearch);
		PrintWriter out = resp.getWriter();
		for (Laptop l : listLaptop) {
			out.println("<div class=' col-12 col-sm-6 col-lg-4'>\r\n"
					+ "							<div class='card card-body'>\r\n"
					+ "								<a href='detail?ma=" + l.getMa() + "&theLoai=" + l.getTheLoai()
					+ "'\r\n"
					+ "									title='Xem chi tiết sản phẩm' style='color: black;'><span\r\n"
					+ "									style=\"position: absolute;  margin-top: 25px; color: white;\" class=\"nhapNhay\">Giảm "+l.getGiamGia()+"%</span> <img\r\n"
					+ "									class='img-fluid' src='" + l.getAnh() + "'>\r\n"
					+ "									<h5 class='card-title'>" + l.getTen() + "</h5>\r\n"
					+ "								</a>\r\n<p class=\"text-center text-secondary\"><del>"+new Service().formatNumberLL(l.getGia())+"</del><sup>đ</sup></p>"
					+ "								<p class='bloc_left_price'><b>"+new Service().formatNumberL(l.getGia(), l.getGiamGia())+"</b><sup>đ</sup>\r\n"
					+ "								</p>\r\n" + "							</div>\r\n"
					+ "						</div>");
		}

		for (Camera l : listCamera) {
			out.println("<div class=' col-12 col-sm-6 col-lg-4'>\r\n"
					+ "							<div class='card card-body'>\r\n"
					+ "								<a href='detail?ma=" + l.getMa() + "&theLoai=" + l.getTheLoai()
					+ "'\r\n"
					+ "									title='Xem chi tiết sản phẩm' style='color: black;'><span\r\n"
					+ "									style=\"position: absolute;  margin-top: 25px; color: white;\" class=\"nhapNhay\">Giảm "+l.getGiamGia()+"%</span> <img\r\n"
					+ "									class='img-fluid' src='" + l.getAnh() + "'>\r\n"
					+ "									<h5 class='card-title'>" + l.getTen() + "</h5>\r\n"
					+ "								</a>\r\n<p class=\"text-center text-secondary\"><del>"+new Service().formatNumberLL(l.getGia())+"</del><sup>đ</sup></p>"
					+ "								<p class='bloc_left_price'>" +new Service().formatNumberL(l.getGia(), l.getGiamGia())+ "<sup>đ</sup>\r\n"
					+ "								</p>\r\n" + "							</div>\r\n"
					+ "						</div>");
		}
	}

}
