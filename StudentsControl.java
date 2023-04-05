package SQLs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsControl {
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> list = new ArrayList<>();
    public int add() {
            System.out.printf("Enter StudentID : ");
            String id = sc.nextLine();
            System.out.printf("Enter StudentName : ");
            String studentName = sc.nextLine();
            System.out.printf("Enter Address : ");
            String address = sc.nextLine();
            System.out.printf("Enter Phone : ");
            String phone = sc.nextLine();

            Student std = new Student(id, studentName, address, phone);
            list.add(std);
            return 0;
    }
    public void display(){
        for (Student std : list){
            System.out.println(std.toString());
        }
    }

    public void save(){
        for (Student std : list){
            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien", "root", "");
                PreparedStatement pstm = cn.prepareStatement("insert into students values (?,?,?,?)");

                pstm.setString(1, std.getStudentID());
                pstm.setString(2, std.getStudentName());
                pstm.setString(3, std.getAddress());
                pstm.setString(4, std.getPhone());

                int check = pstm.executeUpdate();
                int i = -1;
                i++;
                list.remove(i);
                if (check > 0){
                    System.out.println("Successfully added!!");
                }else {
                    System.out.println("False");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
