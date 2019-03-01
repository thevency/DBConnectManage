import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testConnection4 {
    @Test
    public  void testConnection4() throws SQLException {
        Connection con1 = ConnectionPool.getConnection();
        System.out.println("connection 4 Thread info: "+ Thread.currentThread().getId());

        PreparedStatement pst = con1.prepareStatement("SELECT * FROM COUNTRY2");
        ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("connect 4 has: " + rs.getString(1));
            }

        con1.close();
    }
}
