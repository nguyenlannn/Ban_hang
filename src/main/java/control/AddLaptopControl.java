package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Laptop;
import entity.User;

@WebServlet("/add-laptop")
public class AddLaptopControl extends HttpServlet {
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
				Laptop l = new Laptop();
				l.setTen(req.getParameter("ten"));
				l.setAnh(req.getParameter("anh"));
				l.setGia(Integer.parseInt(req.getParameter("gia")));
				l.setTieuDe(req.getParameter("tieuDe"));
				l.setThuongHieu(req.getParameter("thuongHieu"));
				l.setChip(req.getParameter("chip"));
				l.setManHinh(req.getParameter("manHinh"));
				l.setRam(req.getParameter("ram"));
				l.setoCung(req.getParameter("oCung"));
				l.setCardDoHoa(req.getParameter("cardDoHoa"));
				l.setWebcam(req.getParameter("webcam"));
				l.setKetNoiKhongDay(req.getParameter("ketNoiKhongDay"));
				l.setCongGiaoTiep(req.getParameter("congGiaoTiep"));
				l.setPin(req.getParameter("pin"));
				l.setTrongLuong(req.getParameter("trongLuong"));
				l.setChatLieu(req.getParameter("chatLieu"));
				l.setMauSac(req.getParameter("mauSac"));
				l.setBaoHanh(Integer.parseInt(req.getParameter("baoHanh")));
				l.setTheLoai(Integer.parseInt(req.getParameter("theLoai")));
				l.setDongMay(req.getParameter("dongMay"));
				l.setSoLuong(Integer.parseInt(req.getParameter("soLuong")));
				l.setGiamGia(Integer.parseInt(req.getParameter("giamGia")));
				new DAO().addLaptop(l);
				resp.sendRedirect("management-laptop");
			} else {
				resp.sendRedirect("login-admin");
			}
		} catch (Exception e) {
			resp.sendRedirect("login-admin");
		}
	}

}
