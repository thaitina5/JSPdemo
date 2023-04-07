package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MuaHang
 */
@WebServlet("/mua-hang")
public class MuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MuaHang() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");
		String soLuong = request.getParameter("soLuong");
		
		//forward value
		request.setAttribute("soDienThoai", soDienThoai);
		request.setAttribute("email", email);
		request.setAttribute("soLuong", soLuong);
		
		//check lỗi số lượng
		double num_soLuong = 0;
		boolean check = false;
		try {
			num_soLuong = Double.parseDouble(soLuong);
		} catch (Exception e) {
			check=true;
			request.setAttribute("e_soLuong", "Số lượng ko phù hợp, xin nhập lại");
		}
		
		if(num_soLuong<=0) {
			check=true;
			request.setAttribute("e_soLuong", "Số lượng phải lớn hơn 0");
		}
		
		//check số điện thoại
		Pattern pattern_soDienThoai = Pattern.compile("\\d{10}");
		Matcher matcher_soDienThoai = pattern_soDienThoai.matcher(soDienThoai);
		
		if(!matcher_soDienThoai.matches()) {
			check=true;
			request.setAttribute("e_soDienThoai", "Số điện thoại ko hợp lệ");
		}
		
		//check email
		Pattern pattern_email = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
		Matcher matcher_email = pattern_email.matcher(email);
		
		if(!matcher_email.matches()) {
			check=true;
			request.setAttribute("e_email", "Email ko hợp lệ");
		}
		
		String url = "/succes.jsp";
		if(check) {
			url="/index.jsp";
		}
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
