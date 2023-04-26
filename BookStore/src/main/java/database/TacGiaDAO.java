package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {
//	private ArrayList<TacGia> data = new ArrayList<TacGia>();

//	public static TacGiaDAO getInstance() {
//		return new TacGiaDAO();
//	}

	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> ketQua = new ArrayList<TacGia>();

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from tacgia;";

			PreparedStatement pst = conn.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String tenTacGia = rs.getString("tentacgia");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");

				TacGia u = new TacGia(maTacGia, tenTacGia, ngaySinh, tieuSu);
				ketQua.add(u);
			}
			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia ketQua = null;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from tacgia where matacgia=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("tentacgia");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");

				ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
//				break;
			}

			System.out.println(sql);
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(TacGia t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "insert into tacgia values (?, ?, ?, ?);";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());
			pst.setString(2, t.getHoVaTen());
			pst.setDate(3, t.getNgaySinh());
			pst.setString(4, t.getTieuSu());

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
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem+=this.insert(tacGia);
		}
		return dem;
	}

	@Override
	public int delete(TacGia t) {
		int ketQua = 0;

		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "delete from tacgia where matacgia=?;";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaTacGia());

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
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem+=this.delete(tacGia);
		}
		return dem;
	}

	@Override
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE tacgia "+
					 " SET " +
					 " hovaten=?"+
					 ", ngaysinh=?"+
					 ", tieusu=?"+
					 " WHERE matacgia=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getHoVaTen());
			st.setDate(2, t.getNgaySinh());
			st.setString(3, t.getTieuSu());
			st.setString(4, t.getMaTacGia());

			ketQua = st.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	public static void main(String[] args) {
		TacGiaDAO tgd = new TacGiaDAO();
		ArrayList<TacGia> kq = tgd.selectAll();
		for (TacGia tacGia : kq) {
			System.out.println(tacGia.toString());
		}

//		TacGia tg = tgd.selectById(new TacGia("TG01", "", null, ""));
//		System.out.println(tg);
//
//		TacGia tg2 = new TacGia("TG10", "ThaoUyen", new Date(2000 - 1900, 10, 15), "");
//		tgd.insert(tg2);

		TacGia tg3 = new TacGia("TG10", "ThaoUyen", new Date(2000 - 1900, 10, 15), "");
		tgd.delete(tg3);
	}
}
