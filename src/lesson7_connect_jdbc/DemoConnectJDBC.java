package lesson7_connect_jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import lesson5_view_service_model.SanPham;

public class DemoConnectJDBC {
    public static void main(String[] args) {
        try {
            // B1: Load Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Kết nối
            String dbUser = "sa", dbPass = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433" +
                ";databaseName=su22b2_sof203";
            
            Connection conn = DriverManager
                .getConnection(dbUrl, dbUser, dbPass);
            
            System.out.println("Kết nối thành công");
            
            SanPham sp = new SanPham(0, "Ao dai tay", "WHITE",
                10, 100000, 1);
            
            String sql = "INSERT INTO san_pham"
                + "(ten, mau_sac, so_luong, don_gia, danh_muc_id) "
                + "VALUES (?, ?, ?, ?, ?)";
            //             1  2  3  4  5
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getMauSac());
            ps.setInt(3, sp.getSoLuong());
            ps.setDouble(4, sp.getDonGia());
            ps.setInt(5, sp.getDanhMucId());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
