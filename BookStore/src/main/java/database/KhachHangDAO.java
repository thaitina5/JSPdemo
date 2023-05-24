package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {
//	private ArrayList<KhachHang> data = new ArrayList<KhachHang>();

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from khachhang;";

			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiMuaHang = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoiGianHieuLucMaXacThuc = rs.getDate("thoigianhieulucmaxacthuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				String duongDanAnh = rs.getString("duongdananh");

				KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi,
						diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLucMaXacThuc, trangThaiXacThuc, duongDanAnh);
				ketQua.add(kh);
			}
			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from khachhang where makhachhang=?;";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiMuaHang = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoiGianHieuLucMaXacThuc = rs.getDate("thoigianhieulucmaxacthuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				String duongDanAnh = rs.getString("duongdananh");

				ketQua = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiMuaHang,
						diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLucMaXacThuc, trangThaiXacThuc, duongDanAnh);
			}
			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public KhachHang selectByUsernameAndPassword(KhachHang t) {
		KhachHang ketQua = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from khachhang where tendangnhap=? and matkhau=?;";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getTenDangNhap());
			pst.setString(2, t.getMatKhau());

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiMuaHang = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoiGianHieuLucMaXacThuc = rs.getDate("thoigianhieulucmaxacthuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				String duongDanAnh = rs.getString("duongdananh");

				ketQua = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiMuaHang,
						diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLucMaXacThuc, trangThaiXacThuc, duongDanAnh);
			}
			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "insert into khachhang values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());
			pst.setString(2, t.getTenDangNhap());
			pst.setString(3, t.getMatKhau());
			pst.setString(4, t.getHoVaTen());
			pst.setString(5, t.getGioiTinh());
			pst.setString(6, t.getDiaChi());
			pst.setString(7, t.getDiaChiNhanHang());
			pst.setString(8, t.getDiaChiMuaHang());
			pst.setDate(9, t.getNgaySinh());
			pst.setString(10, t.getSoDienThoai());
			pst.setString(11, t.getEmail());
			pst.setBoolean(12, t.isDangKyNhanBangTin());
			pst.setString(13, null);
			pst.setDate(14, null);
			pst.setBoolean(15, false);

			ketQua = pst.executeUpdate();

			System.out.println(sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		int count = 0;
		for (KhachHang KhachHang : arr) {
			count += this.insert(KhachHang);
		}
		return count;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "delete from khachhang where makhachhang=?;";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());

			ketQua = pst.executeUpdate();

			System.out.println(sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int count = 0;
		for (KhachHang KhachHang : arr) {
			count += this.delete(KhachHang);
		}
		return count;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update khachhang " + " set " + " tendangnhap=?" + ", matkhau=?" + ", hovaten=?" + ", gioitinh=?"
					+ ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
					+ ", email=?" + ", dangkynhanbangtin=?" + " WHERE makhachhang=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getTenDangNhap());
			pst.setString(2, t.getMatKhau());
			pst.setString(3, t.getHoVaTen());
			pst.setString(4, t.getGioiTinh());
			pst.setString(5, t.getDiaChi());
			pst.setString(6, t.getDiaChiNhanHang());
			pst.setString(7, t.getDiaChiMuaHang());
			pst.setDate(8, t.getNgaySinh());
			pst.setString(9, t.getSoDienThoai());
			pst.setString(10, t.getEmail());
			pst.setBoolean(11, t.isDangKyNhanBangTin());
			pst.setString(12, t.getMaKhachHang());

			ketQua = pst.executeUpdate();

			System.out.println(sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public int updateInfo(KhachHang t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update khachhang " + " set " + " hovaten=?" + ", gioitinh=?"
					+ ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
					+ ", email=?" + ", dangkynhanbangtin=?" + " WHERE makhachhang=?;";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getHoVaTen());
			pst.setString(2, t.getGioiTinh());
			pst.setString(3, t.getDiaChi());
			pst.setString(4, t.getDiaChiNhanHang());
			pst.setString(5, t.getDiaChiMuaHang());
			pst.setDate(6, t.getNgaySinh());
			pst.setString(7, t.getSoDienThoai());
			pst.setString(8, t.getEmail());
			pst.setBoolean(9, t.isDangKyNhanBangTin());
			pst.setString(10, t.getMaKhachHang());

			ketQua = pst.executeUpdate();

			System.out.println(sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public int updateVerifyAccount(KhachHang t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update khachhang " + " set " + " maxacthuc=?" + ", thoigianhieulucmaxacthuc=?" + ", trangthaixacthuc=?"
					+ " WHERE makhachhang=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaXacThuc());
			pst.setDate(2, t.getThoiGianHieuLucMaXacThuc());
			pst.setBoolean(3, t.isTrangThaiXacThuc());
			pst.setString(4, t.getMaKhachHang());

			ketQua = pst.executeUpdate();

			System.out.println(sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public int updateImage(KhachHang t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update khachhang " + " set " + " duongdananh=?" + " WHERE makhachhang=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getDuongDanAnh());
			pst.setString(2, t.getMaKhachHang());

			ketQua = pst.executeUpdate();

			System.out.println(sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public boolean kiemTraTenDangNhap(String tenDangNhap) {
		boolean ketQua = false;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from khachhang where tendangnhap=?;";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, tenDangNhap);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ketQua = true;
			}
			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public boolean changePassword(KhachHang t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update khachhang " + " set " + "matkhau=?" + " WHERE makhachhang=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMatKhau());
			pst.setString(2, t.getMaKhachHang());

			ketQua = pst.executeUpdate();

			System.out.println(sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua>0;
	}
}
