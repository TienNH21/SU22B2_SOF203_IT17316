package lesson5_view_service_model;

public class SanPham {
    private int id;
    private String tenSP;
    private String mauSac;
    private int soLuong;
    private double donGia;
    private int danhMucId;

    public SanPham() {
    }

    public SanPham(int id, String tenSP, String mauSac, int soLuong, double donGia, int danhMucId) {
        this.id = id;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.danhMucId = danhMucId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(int danhMucId) {
        this.danhMucId = danhMucId;
    }
    
    
}
