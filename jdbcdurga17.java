import java.sql.*;
import java.util.Scanner;

// Program to display highest/minimun salaried employee info using aggregate function;

public class jdbcdurga17 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        String sql = "SELECT * FROM employees WHERE esal = (SELECT MIN(esal) FROM employees)";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                flag = true;
                int empId = rs.getInt(1);
                String empName = rs.getString(2);
                int empSal = rs.getInt(3);
                String empAddr = rs.getString(4);
                System.out.println("+-------------------------+");
                System.out.println("ID: "+empId);
                System.out.println("Name: "+empName);
                System.out.println("Salary: "+empSal);
                System.out.println("Address:"+empAddr);
                System.out.println();
            }

            if(flag == false)
                System.out.println("no records found");
            sc.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
