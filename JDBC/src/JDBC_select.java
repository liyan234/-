import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_select {

    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/item?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("liyan");

        Connection connection = dataSource.getConnection();

        String sql = "select * from items";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String manage = resultSet.getString("manage_name");
            String information = resultSet.getString("item_information");
            String place = resultSet.getString("item_place");

            System.out.println(" " +id + " " + manage + " " + information + " " + place);

        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
