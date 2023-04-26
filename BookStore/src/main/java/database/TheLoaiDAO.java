package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai> {

	private ArrayList<TheLoai> data = new ArrayList<TheLoai>();

	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> ketQua = new ArrayList<TheLoai>();
		
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from theloai;";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				
				TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
				ketQua.add(tl);
			}
			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai ketQua = null;
		
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select from theloai where matheloai=?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaTheLoai());
			
			ResultSet rs = pst.executeQuery(sql);
			while(rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				
				ketQua = new TheLoai(maTheLoai, tenTheLoai);
			}
			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insert(TheLoai t) {
		int ketQua = 0;
		
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "inser into theloai values(?,?);";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaTheLoai());
			pst.setString(2, t.getTenTheLoai());
			
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
	public int insertAll(ArrayList<TheLoai> arr) {
		int count = 0;
		for (TheLoai TheLoai : arr) {
			count += this.insert(TheLoai);
		}
		return count;
	}

	@Override
	public int delete(TheLoai t) {
		int ketQua = 0;
		
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "delete from theloai where matheloai=?;";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaTheLoai());
			
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
	public int deleteAll(ArrayList<TheLoai> arr) {
		int count = 0;
		for (TheLoai TheLoai : arr) {
			count += this.delete(TheLoai);
		}
		return count;
	}

	@Override
	public int update(TheLoai t) {
		int ketQua = 0;
		
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "update theloai "+
						 "set tentheloai=? "+
						 "where matheloai=?;";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getTenTheLoai());
			pst.setString(2, t.getMaTheLoai());
			
			ketQua = pst.executeUpdate();
			
			System.out.println(sql);
			System.out.println("Co " + ketQua + " dong bi thay doi");
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
