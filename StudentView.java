package ADF2;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ArrayList<ThongTinSinhVien> studentModels = new ArrayList<>();
        StudentController studentController = new StudentController();
        int choice;
        System.out.println("Chao mung ban den voi chuong trinh quan ly sinh vien");
        do {
            System.out.println("==========================");
            System.out.println("Menu: ");
            System.out.println("1. Them Thong tin sinh vien");
            System.out.println("2. Hien thi ho so sinh vien");
            System.out.println("3. Luu.");
            System.out.println("4. Thoat");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    studentController.add(studentModels);
                    break;
                case 2:
                    studentController.display(studentModels);
                    break;
                case 3:
                    studentController.save(studentModels);
                    break;
                case 4:
                    System.out.println("Thoat!!!");
                    break;
                default:
                    System.out.println("Du lieu khong hop le ... xin vui long thu lai !!");
            }
        } while (choice != 4);
    }
}
