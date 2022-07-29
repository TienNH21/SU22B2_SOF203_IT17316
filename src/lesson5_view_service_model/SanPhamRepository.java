package lesson5_view_service_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamRepository {
    public void insert(SanPham sp)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "INSERT INTO san_pham"
                + "(ten, mau_sac, so_luong, don_gia, danh_muc_id) "
                + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getMauSac());
            ps.setInt(3, sp.getSoLuong());
            ps.setDouble(4, sp.getDonGia());
            ps.setInt(5, sp.getDanhMucId());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(int id, SanPham sp)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "UPDATE san_pham SET " +
                "ten = ?, mau_sac = ?, so_luong = ?, " +
                "don_gia = ?, danh_muc_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getMauSac());
            ps.setInt(3, sp.getSoLuong());
            ps.setDouble(4, sp.getDonGia());
            ps.setInt(5, sp.getDanhMucId());
            ps.setInt(6, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "DELETE FROM san_pham WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<SanPham> all()
    {
        ArrayList<SanPham> listSP = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM san_pham";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String mauSac = rs.getString("mau_sac");
                int soLg = rs.getInt("so_luong");
                double gia = rs.getDouble("don_gia");
                int danhMucId = rs.getInt("danh_muc_id");
                
                SanPham sp = new SanPham(id, ten, mauSac,
                    soLg, gia, danhMucId);
                listSP.add(sp);
            }
            
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listSP;
    }
}
