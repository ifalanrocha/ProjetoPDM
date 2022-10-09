package projetoPDM.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDb {
    
    public static String status = "Não conectado...";

    public ConexaoDb() {

    }

    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;
        try {
            //String driverName = "com.mysql.jdbc.Driver";
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";    
            String mydatabase ="dbDispositivosM";        
            //String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            //String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useSSL=false";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "admin";
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            System.out.println("Erro" + e.getMessage());
            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean FecharConexao() {
        try {
           ConexaoDb.getConexaoMySQL().close();
           return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoDb.getConexaoMySQL();
    }
}
