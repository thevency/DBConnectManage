import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testConnection1 {
    @Test
    public void testConnection1() throws SQLException {
        Connection con1 = ConnectionPool.getConnection();
        System.out.println("connection 1 part 1 Thread info: "+ Thread.currentThread().getId());
        PreparedStatement pst = con1.prepareStatement("SELECT * FROM COUNTRY2");
        ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("connect 1 has: " + rs.getString(1));
            }
        con1.close();
    }
    @Test
    public void testConnection2() throws SQLException {
        Connection con1 = ConnectionPool.getConnection();
        System.out.println("connection 1 part 2 Thread info: "+ Thread.currentThread().getId());
        PreparedStatement pst = con1.prepareStatement("SELECT * FROM COUNTRY2");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println("connect 1 part 2 has: " + rs.getString(1));
        }
        con1.close();
    }
    @Test
    public void testConnection3() throws SQLException {
        Connection con1 = ConnectionPool.getConnection();
        System.out.println("connection 1 part 2 Thread info: "+ Thread.currentThread().getId());
        PreparedStatement pst = con1.prepareStatement("SELECT * FROM COUNTRY2");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println("connect 1 part 2 has: " + rs.getString(1));
        }
        con1.close();
    }
}
