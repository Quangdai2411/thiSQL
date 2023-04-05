package SQLs;

import java.util.Scanner;

public class viewStudent {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Add student records \n2. Display student records \n3. Save \n4.Exit");
            System.out.printf("-> Please enter options : ");
            int ent = sc.nextInt();
            StudentsControl std = new StudentsControl();
            switch (ent){
                case 1 :
                    std.add();
                    break;
                case 2 :
                    std.display();
                    break;
                case 3 :
                    std.save();
                    break;
            case 4 :
                return;
            }
        }while (true);
    }
}
