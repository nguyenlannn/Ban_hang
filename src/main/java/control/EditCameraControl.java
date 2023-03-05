package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Camera;
import entity.User;

@WebServlet("/edit-camera")
public class EditCameraControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.sendRedirect("management-camera");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF8");
		req.setCharacterEncoding("UTF-8");

		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");
			if (user.getIsAdmin() == 1) {
				Camera c = new Camera();
				c.setMa(Integer.parseInt(req.getParameter("ma")));
				c.setTen(req.getParameter("ten"));
				c.setAnh(req.getParameter("anh"));
				c.setGia(Integer.parseInt(req.getParameter("gia")));
				c.setTieuDe(req.getParameter("tieuDe"));
				c.setThuongHieu(req.getParameter("thuongHieu"));
				c.setCamBienAnh(req.getParameter("camBienAnh"));
				c.setDoPhanGiai(req.getParameter("doPhanGiai"));
				c.setOngKinh(req.getParameter("ongKinh"));
				c.setGocNhin(req.getParameter("gocNhin"));
				c.setChuanNenVideo(req.getParameter("chuanNenVideo"));
				c.setCamBien(req.getParameter("camBien"));
				c.setLuuTru(req.getParameter("luuTru"));
				c.setKetNoi(req.getParameter("ketNoi"));
				c.setNguonDien(req.getParameter("nguonDien"));
				c.setHongNgoaiTamNhin(req.getParameter("hongNgoaiTamNhin"));
				c.setTrongLuong(req.getParameter("trongLuong"));
				c.setNhietDoHoatDong(req.getParameter("nhietDoHoatDong"));
				c.setXuatXu(req.getParameter("xuatXu"));
				c.setBaoHanh(Integer.parseInt(req.getParameter("baoHanh")));
				c.setTheLoai(Integer.parseInt(req.getParameter("theLoai")));
				c.setSoLuong(Integer.parseInt(req.getParameter("soLuong")));
				c.setNoiLapDat(req.getParameter("noiLapDat"));
				c.setGiamGia(Integer.parseInt(req.getParameter("giamGia")));
				new DAO().editCamera(c);
				resp.sendRedirect("management-camera");
			} else {
				resp.sendRedirect("login-admin");
			}
		} catch (Exception e) {
			resp.sendRedirect("login-admin");
		}
	}

}
