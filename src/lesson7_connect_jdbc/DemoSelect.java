package lesson7_connect_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import lesson5_view_service_model.SanPham;

public class DemoSelect {
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
            
            ArrayList<SanPham> listSP = new ArrayList<>();
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
