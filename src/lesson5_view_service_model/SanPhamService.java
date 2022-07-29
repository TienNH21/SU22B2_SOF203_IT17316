package lesson5_view_service_model;

import java.util.ArrayList;

public class SanPhamService {
    private SanPhamRepository spRepo;
    
    public SanPhamService()
    {
        this.spRepo = new SanPhamRepository();
    }
    
    public void insert(SanPham sp)
    {
        this.spRepo.insert(sp);
    }
    
    public void update(int id, SanPham sp)
    {
        this.spRepo.update(id, sp);
    }
    
    public void delete(int id)
    {
        this.spRepo.delete(id);
    }

    public ArrayList<SanPham> getListSP()
    {
        return this.spRepo.all();
    }
}
