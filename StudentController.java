package ADF2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    Scanner sc = new Scanner(System.in);

    public void add(ArrayList<ThongTinSinhVien> arr) {
        System.out.println("---------------------------");
        String addNext;
        do {
            System.out.print("Please enter maSinhVien: ");
            String newID = sc.nextLine();
            System.out.print("Please enter Ten: ");
            String newName = sc.nextLine();
            System.out.print("Please enter DiaChi : ");
            String newDiaChi = sc.nextLine();
            System.out.print("Please enter DienTHoai : ");
            String newDienTHoai = sc.nextLine();

            arr.add(new ThongTinSinhVien(newID, newName, newDiaChi, newDienTHoai));
            System.out.println("The student you just add is: " + arr.get(arr.size()-1));

            System.out.print("Ban co muon them sinh vien? (Y/N): ");
            addNext = sc.nextLine();
        } while (addNext.equalsIgnoreCase("y"));

    }

    public void display(ArrayList<ThongTinSinhVien> arr) {
        System.out.println("---------------------------");
        System.out.println("Tat ca hoc sinh trong du lieu: ");
        String id = "maSinhVien";
        String name = "Ten";
        String DiaChi = "DiaChi";
        String DienTHoai = "DienTHoai";
        System.out.printf("\n", id, name, DiaChi, DienTHoai);
        for (ThongTinSinhVien ThongTinSinhVien: arr) {
            System.out.printf("\n", ADF2.ThongTinSinhVien.getmaSinhVien(), ADF2.ThongTinSinhVien.getTen(),
                    ADF2.ThongTinSinhVien.getDiaChi(), ADF2.ThongTinSinhVien.getDienTHoai());
        }
    }

    public void save(ArrayList<ThongTinSinhVien> arr) throws SQLException{
        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "");
                Statement st = con.createStatement()
        ) { try {
            con.setAutoCommit(false);
            con.commit();
            int checkUpdate = 0;
            for (ThongTinSinhVien ThongTinSinhVien: arr) {
                String strUpdate = "insert into Student values ('" + ADF2.ThongTinSinhVien.getmaSinhVien() + "', '" +
                        ADF2.ThongTinSinhVien.getTen() + "', '" + ADF2.ThongTinSinhVien.getDiaChi() + "', '" +
                        ADF2.ThongTinSinhVien.getDienTHoai() + "')";
                System.out.println("The SQL Insert Statement is: " + strUpdate);
                if (st.executeUpdate(strUpdate) > 0) checkUpdate++;
            }
            con.commit();

            System.out.println("Total " + checkUpdate + " records are saved");

            System.out.println("Check inserted records:");
            String strSelect = "select * from student";
            ResultSet rs = st.executeQuery(strSelect);
            ResultSetMetaData rsMD = rs.getMetaData();

            int numCols = rsMD.getColumnCount();
            for (int i=1; i<=numCols; i++) {
                System.out.printf("%-30s", rsMD.getColumnName(i));
            }
            System.out.println();

            while (rs.next()) {
                for (int i=1; i<=numCols; i++) {
                    System.out.printf("%-30s", rs.getString(i));
                }
                System.out.println();
            }

            con.close();
            if (con.isClosed()) {
                System.out.println("Connection closed.");
            }
        } catch (SQLException ex) {
            con.rollback();
            ex.printStackTrace();
            System.exit(-1);
        }
        }
    }
}
