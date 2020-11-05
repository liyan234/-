import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_update {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入想要修改的项目id");
        int id = scanner.nextInt();
        System.out.print("请输入想要修改的项目管理人");
        String manage = scanner.next();

        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/item?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("liyan");

        Connection connection = dataSource.getConnection();

        String sql = "update items set manage_name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,manage);
        statement.setInt(2,id);

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
