package java_1;

public class Student {
        private String name = "Hung";
        private int age = 24;
    public void showStudent() {
        System.out.println("Name " + name);
        System.out.println("Tuoi " + age);
    }
    public int addNumber(int a, int b) {
        int sum = a+b;
        return sum;
    }
    public static void main(String args[ ]) {
        Student st = new Student();
        st.showStudent();       
        System.out.println("Tong so" + st.addNumber(3, 15));
    }
}
