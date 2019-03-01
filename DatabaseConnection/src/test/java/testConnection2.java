import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testConnection2 {
    @Test
    public void testConnection2() throws SQLException {

        Connection con1 = ConnectionPool.getConnection();
        System.out.println("connection 2 Thread info: "+ Thread.currentThread().getId());

        PreparedStatement pst = con1.prepareStatement("SELECT * FROM COUNTRY2");
        ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("connect 2 has: " + rs.getString(1));
//            System.out.println("connect 1 has: " + rs.getArray(1).toString());
            }

        con1.close();
    }
}
