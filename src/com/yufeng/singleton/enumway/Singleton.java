package com.yufeng.singleton.enumway;

import java.sql.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 20:31
 */
public enum Singleton {
    connectionFactory;

    private Connection connection;

    private Singleton() {
        try {
            System.out.println("调用了MyObject的构造");
            String url = "jdbc:sqlserver://localhost:1079;databaseName=ghydb";
            String username = "sa";
            String password = "";
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args){
        System.out.println(Singleton.connectionFactory.getConnection());
     System.out.println(Singleton.connectionFactory.getConnection());
    }

}
