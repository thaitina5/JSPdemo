package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

/**
 * Servlet implementation class DoiMatKhau
 */
@WebServlet("/doi-mat-khau")
public class DoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoiMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matkhauhientai = request.getParameter("matkhauhientai");
		String matkhaumoi = request.getParameter("matkhaumoi");
		String xacnhanmatkhau = request.getParameter("xacnhanmatkhau");
		
		String matkhauhientai_SHA1 = MaHoa.toSHA1(matkhauhientai);
		String matkhaumoi_SHA1 = MaHoa.toSHA1(matkhaumoi);
		String xacnhanmatkhau_SHA1 = MaHoa.toSHA1(xacnhanmatkhau);
		
		String baoLoi = "";
		String url = "/doimatkhau.jsp";
		
		//Kiem tra mat khau hien tai co giong ko
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("khachhang");
		KhachHang khachhang = null;
		if(obj!=null) {
			khachhang = (KhachHang)obj;
		}
		
		if(obj==null) {
			baoLoi = "Bạn chưa đăng nhập vào hệ thống";
			url="/index.jsp";
		}else {
			if(!matkhauhientai_SHA1.equals(khachhang.getMatKhau())) {
				baoLoi = "Mật khẩu hiện tại ko chính xác";
			} else if(matkhauhientai_SHA1.equals(matkhaumoi)) {
				baoLoi = "Mật khẩu mới bị trùng mật khẩu hiện tại";
			} else if(!xacnhanmatkhau.equals(matkhaumoi)) {
				baoLoi = "Mật khẩu xác nhận ko trùng mật khẩu mới";
			} else {
				khachhang.setMatKhau(matkhaumoi_SHA1);
				KhachHangDAO khd = new KhachHangDAO();
				if(khd.changePassword(khachhang)) {
					url="/thanhcong.jsp";
				}else {
					url="/thatbai.jsp";
				}
			}
		}
		request.setAttribute("baoLoi", baoLoi);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
