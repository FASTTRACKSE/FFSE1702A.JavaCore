package DLL;

import DAL.ThiSinhDAL;
import Entity.ThiSinh;
import java.util.ArrayList;

public class ThiSinhDLL {
    ThiSinhDAL dal = new ThiSinhDAL();
    
    public boolean getLogin(int mts , String name)
    {
        return this.dal.getLogin(mts, name) ;
    
    }

    public ArrayList<ThiSinh> getAll() {
        return this.dal.getAll();
    }
    
    public ArrayList<ThiSinh> Search(int MaTS )
    {
        return this.dal.Search(MaTS) ;
    }
     
    public ArrayList<ThiSinh> getByID(int MaTinh )
    {
        return this.dal.getByID(MaTinh) ;
    }
    public boolean AddData(ThiSinh emp) {
        return this.dal.AddData(emp);
    }

    public boolean DeleteData(int u) {
        return this.dal.DeleteData(u);
    }

    public boolean UpdateData(ThiSinh emp) {
        return this.dal.UpdateData(emp);
    }
}