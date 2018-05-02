package DLL;

import DAL.TinhThanhDAL;
import Entity.TinhThanh;
import java.util.ArrayList;

public class TinhThanhDLL {
    TinhThanhDAL dal = new TinhThanhDAL();

    public ArrayList<TinhThanh> getByName(String TenTinh) {
        return this.dal.GetByName(TenTinh);
    }
    public ArrayList<TinhThanh> getByID(int id) {
        return this.dal.GetByID(id);
    }

    
    public ArrayList<TinhThanh> getAll() {
        return this.dal.getAll();
    }
}