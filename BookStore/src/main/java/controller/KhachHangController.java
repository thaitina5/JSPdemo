package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

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
 * Servlet implementation class KhachHangController
 */
@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hanhdong = request.getParameter("hanhdong");
		if(hanhdong.equals("dang-ky")) {
			dangKy(request, response);
		}else if(hanhdong.equals("dang-nhap")) {
			dangNhap(request, response);
		}else if(hanhdong.equals("dang-xuat")) {
			dangXuat(request, response);
		}else if(hanhdong.equals("doi-mat-khau")) {
			doiMatKhau(request, response);
		}else if(hanhdong.equals("thay-doi-thong-tin")) {
			thayDoiThongTin(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void dangKy(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");
			
			request.setAttribute("tenDangNhap", tenDangNhap);		
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("dongYNhanMail", dongYNhanMail);
			
			
			String url = "";
			String baoLoi = "";
			KhachHangDAO khDAO = new KhachHangDAO();
			
			if(khDAO.kiemTraTenDangNhap(tenDangNhap)) {
				baoLoi += "Tên đã tồn tại, vui lòng nhập tên khác";
			}
			if(!matKhau.equals(matKhauNhapLai)) {
				baoLoi += "Mật khẩu ko trùng khớp";
			}else {
				matKhau = MaHoa.toSHA1(matKhau);
			}
			
			
			if(baoLoi.length()>0) {
				url = "/khachhang/dangky.jsp";
			}else {
				Random rd = new Random();
				String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) +"";
				KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail!=null);
				khDAO.insert(kh);
				url = "/khachhang/thanhcong.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			matKhau = MaHoa.toSHA1(matKhau);
			
			KhachHang kh = new KhachHang();
			kh.setTenDangNhap(tenDangNhap);
			kh.setMatKhau(matKhau);
			
			KhachHangDAO khd = new KhachHangDAO();
			KhachHang khachhang = khd.selectByUsernameAndPassword(kh);
			
			String url = "";
			if(khachhang != null) {
				HttpSession session = request.getSession();
				session.setAttribute("khachhang", khachhang);
				url="/index.jsp";
			}else {
				request.setAttribute("baoLoi", "Tên tài khoản hoặc mật khẩu sai!");
				url = "/khachhang/dangnhap.jsp";
			}
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
				
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();

			response.sendRedirect(url+"/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void doiMatKhau(HttpServletRequest request, HttpServletResponse response) {
		try {
			String matkhauhientai = request.getParameter("matkhauhientai");
			String matkhaumoi = request.getParameter("matkhaumoi");
			String xacnhanmatkhau = request.getParameter("xacnhanmatkhau");
			
			String matkhauhientai_SHA1 = MaHoa.toSHA1(matkhauhientai);
			String matkhaumoi_SHA1 = MaHoa.toSHA1(matkhaumoi);
			String xacnhanmatkhau_SHA1 = MaHoa.toSHA1(xacnhanmatkhau);
			
			String baoLoi = "";
			String url = "/khachhang/doimatkhau.jsp";
			
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
				} else if(matkhaumoi_SHA1.equals(matkhauhientai_SHA1)) {
					baoLoi = "Mật khẩu mới bị trùng mật khẩu hiện tại";
				} else if(!xacnhanmatkhau_SHA1.equals(matkhaumoi_SHA1)) {
					baoLoi = "Mật khẩu xác nhận ko trùng mật khẩu mới";
				} else {
					khachhang.setMatKhau(matkhaumoi_SHA1);
					KhachHangDAO khd = new KhachHangDAO();
					if(khd.changePassword(khachhang)) {
						url="/khachhang/thanhcong.jsp";
					}else {
						url="/khachhang/thatbai.jsp";
					}
				}
			}
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response) {
		try {
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");
			
			request.setAttribute("hoVaTen", hoVaTen);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChiKhachHang", diaChiKhachHang);
			request.setAttribute("diaChiMuaHang", diaChiMuaHang);
			request.setAttribute("diaChiNhanHang", diaChiNhanHang);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("dongYNhanMail", dongYNhanMail);
			
			String url = "";
			String baoLoi = "";
			KhachHangDAO khDAO = new KhachHangDAO();
			
			if(baoLoi.length()>0) {
				url = "/khachhang/dangky.jsp";
			}else {
				HttpSession session = request.getSession();
				Object obj = session.getAttribute("khachhang");
				KhachHang khachHang = null;
				
				if (obj!=null){
					khachHang = (KhachHang)obj;
					if(khachHang!=null){
						String maKhachHang = khachHang.getMaKhachHang();
						KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail!=null);
						khDAO.updateInfo(kh);
						//sau khi update thông tin thì set lại session 
						//để hiển thị thông tin mới
						KhachHang kh2 = khDAO.selectById(kh);
						request.getSession().setAttribute("khachhang", kh2);
						url = "/khachhang/thanhcong.jsp";
					}	
				}
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
