import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_insert{

    public static void main(String[] args) throws SQLException {



        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/item?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("liyan");

        Connection connection = dataSource.getConnection();

        int id = 2;
        String manage = "李四";
        String information = "贫困补助";
        String place = "宝鸡";

        String sql = "insert into items values(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,id);
        statement.setString(2,manage);
        statement.setString(3,information);
        statement.setString(4,place);

        // insert  delete  update 都使用 executeUpdate 方法来执行
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        statement.close();
        connection.close();
    }
}
