package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	public static List<LoaiSua> docTatCa(){
		List<LoaiSua> dsls = new ArrayList<>();
		try (Connection ketNoi = CSDL.getKetNoi()){
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery("select * from loai_sua");
			while(rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				dsls.add(ls);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsls;
	}
	public static int them(LoaiSua ls) {
		String sql = "insert into loai_sua(ma_loai_sua, ten_loai) values (?,?)";
		try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, ls.getMaLoai());
			pst.setString(2, ls.getTenLoai());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static LoaiSua tim(String maLoai) {
		LoaiSua ls = null;
		String sql = "select * from loai_sua where ma_loai_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1,maLoai);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	public static int sua(LoaiSua ls) {
		String sql = "update loai_sua set ten_loai = ? where ma_loai_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1,ls.getTenLoai());
			pst.setString(2,ls.getMaLoai());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static int xoa(String maLoai) {
		String sql = "delete from loai_sua where ma_loai_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1,maLoai);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
