package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SanPham;
import model.TacGia;
import model.TheLoai;

public class SanPhamDAO implements DAOInterface<SanPham> {

//	private ArrayList<SanPham> data = new ArrayList<SanPham>();

	@Override
	public ArrayList<SanPham> selectAll() {
		ArrayList<SanPham> ketQua = new ArrayList<SanPham>();

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from sanpham;";

			PreparedStatement pst = conn.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String masanpham = rs.getString("masanpham");
				String tensanpham = rs.getString("tensanpham");
				String matacgia = rs.getString("matacgia");
				int namxuatban = rs.getInt("namxuatban");
				double gianhap = rs.getDouble("gianhap");
				double giagoc = rs.getDouble("giagoc");
				double giaban = rs.getDouble("giaban");
				double soluong = rs.getDouble("soluong");
				String matheloai = rs.getString("matheloai");
				String ngonngu = rs.getString("ngonngu");
				String mota = rs.getString("mota");

				TacGia tacGia = new TacGiaDAO().selectById(new TacGia(matacgia,"", null, ""));
				TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(matheloai, ""));
				
				SanPham sp = new SanPham(masanpham, tensanpham, tacGia, theLoai, namxuatban, gianhap, giagoc, giaban, soluong, ngonngu, mota);
				ketQua.add(sp);
			}
			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public SanPham selectById(SanPham t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(SanPham t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<SanPham> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SanPham t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<SanPham> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SanPham t) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
