import java.util.ArrayList;
import java.util.Scanner;

public class Sinhvien {
  private String id ;
  private String name ;
  int age ;
  String address ;
  float gpa;
  public Sinhvien() {}
  public Sinhvien(String id, String name, int age, String address, float gpa) {
    super();
    this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
    this.gpa = gpa;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public float getGpa() {
    return gpa;
  }
  public void setGpa(float gpa) {
    this.gpa = gpa;
  }
  public void hienthi()
  {
    System.out.print("\n------------------------------------------------\n");
    System.out.println( "- ID      : " + getId()+ "\n- tên     : " + getName() + " \n- tuổi    : " + getAge() + " \n- địa chỉ : " + getGpa() );
  }
  
  public static void main(String args[]) {
    int controller = 9 ;
    int soluong = 0;
    Sinhvien[] listSv = new Sinhvien[50];
    
    
    do { 
    System.out.print("\n*************************************************\n");
    System.out.print("* số 1 : thêm sinh viên                         *\n");
    System.out.print("* số 2 : cập nhật thông tin sinh viên theo ID   *\n");
    System.out.print("* số 3 : xoá sinh viên theo ID                  *\n");
    System.out.print("* số 4 : sắp xếp sinh viên theo tên             *\n");
    System.out.print("* số 5 : hiển thị danh sách sinh viên           *\n");
    System.out.print("* số 0 : kết  thúc chương trình                 *\n");
    System.out.print("*************************************************\n");
    System.out.print("\n chọn chức năng bạn muốn : ");
    Scanner scanner = new Scanner(System.in);
    controller = Integer.parseInt(scanner.nextLine());
    System.out.print(controller);
    if( controller == 1 ) {
      
      System.out.print(" bạn muốn thêm bao nhiêu sinh viên :");
      int number = Integer.parseInt(scanner.nextLine());
      
      for(int i = 0 ; i< number ; i++ ) {
    	  boolean  chk = true ;
        Sinhvien sv = new Sinhvien();
        int dem = i+1;
        
      System.out.println("sinh vien thu " + dem );  
      
      //id
      System.out.println("nhập ID sinh viên : ");
      String id = scanner.nextLine();
      sv.setId(id);
      //tên 
      System.out.println("nhập tên sinh viên : ");
      String name = scanner.nextLine();
      sv.setName(name);
      //tuổi 
      while(chk) 
      {
        System.out.println("nhập tuổi sinh viên : ");
        try
        {
          int age = Integer.parseInt(scanner.nextLine());
          sv.setAge(age);
          chk = false;
        }
        catch(Exception e) 
        {
          System.out.println("nhap sai du lieu , vui long nhap lai ");
        }
      }
      //địa chỉ 
      System.out.println("nhập địa chỉ sinh viên :");
      String address = scanner.nextLine();
      sv.setAddress(address);
      //điểm 
    
        System.out.println("nhập điểm  sinh viên :");
     
          float gpa = Integer.parseInt(scanner.nextLine());
          sv.setGpa(gpa); 
      listSv[soluong] = sv ;
      soluong ++ ;
      }
    }else if (controller == 2 ) {
    System.out.print("nhập ID cần thay đổi : ");
    String id = scanner.nextLine();
    
    for( int  i = 0; i < soluong ; i++ ) {
      if(listSv[i].getId().equals(id)) {
        //cập nhật tên 
        System.out.println("nhập tên sinh viên : ");
        String name = scanner.nextLine();
        listSv[i].setName(name);
        //tuổi 
        System.out.println("nhập tuổi sinh viên : ");
        int age = Integer.parseInt(scanner.nextLine());
        listSv[i].setAge(age);
        //địa chỉ 
        System.out.println("nhập địa chỉ sinh viên :");
        String address = scanner.nextLine();
        listSv[i].setAddress(address);
        //điểm 
        System.out.println("nhập điểm  sinh viên :"); 
        float gpa = Integer.parseInt(scanner.nextLine());
        listSv[i].setGpa(gpa);  
      }
    }
    
    }
    else  if (controller == 3) 
    {
      System.out.print("nhập ID cần xoá : ");
      String id = scanner.nextLine();
      for( int  i = 0; i < soluong ; i++ )
        {
          if(listSv[i].getId().equals(id)) 
          {
            for(int j = i + 1 ; j < soluong ; j++) 
            {
              listSv[i] = listSv[j];
            }
          }
        }
      listSv[soluong - 1] = null;
      soluong -- ;
    }
    else  if (controller == 4) 
    {
      for (int i = 0; i < soluong-1; i++) 
      {
        for (int j = i+1; j < soluong; j++) 
        { 
          int result = listSv[i].getName().compareTo(listSv[j].getName());
          if (result > 0 )
          {
            Sinhvien tam  = listSv[i];
            listSv[i] = listSv[j];
            listSv[j] = tam ;
          }
        } 
      }
      for(int  j=0 ; j < soluong ; j++) {
          listSv[j].hienthi();
          
        }
      
    }
    else  if (controller == 5) {
     for(int  j=0 ; j < soluong ; j++) {
       listSv[j].hienthi();
       
     }
    }
  }
  
    while(controller != 0);

  }
}

  

