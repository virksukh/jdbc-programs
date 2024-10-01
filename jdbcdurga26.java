import java.lang.reflect.Type;
import java.sql.*;
import java.util.Scanner;

// jdbc program to call stored procedure which can take employee number as input and provide emp salary

public class jdbcdurga26 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            CallableStatement cst = con.prepareCall("{call getSal(?,?)}");
            cst.setInt(1,1);
            cst.registerOutParameter(2, Types.INTEGER);
            cst.execute();
            int result = cst.getInt(2);
            System.out.println("Salary.."+result);
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
