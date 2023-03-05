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

@WebServlet("/detail")
public class DetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		int ma = Integer.parseInt(req.getParameter("ma"));
		int theLoai = Integer.parseInt(req.getParameter("theLoai"));

		try {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("acc");
			req.setAttribute("orderAccount", new DAO().getOrderByAccount(user));
		} catch (Exception e) {
		}
		
		req.setAttribute("cxn", "Chờ xác nhận");
		req.setAttribute("dg", "Đang giao");
		req.setAttribute("tc", "Thành công");
		
		req.setAttribute("listCategary", new DAO().getAllCategory());
		req.setAttribute("topLaptop", new DAO().getDetailByLaptop(new DAO().getTopLaptop(), 1));
		req.setAttribute("topCamera", new DAO().getDetailByCamera(new DAO().getTopCamera(), 2));
		req.setAttribute("detailLaptop", new DAO().getDetailByLaptop(ma, theLoai));
		req.setAttribute("detailCamera", new DAO().getDetailByCamera(ma, theLoai));
		req.getRequestDispatcher("Detail.jsp").forward(req, resp);

	}

}
