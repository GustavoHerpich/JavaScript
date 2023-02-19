package nutricionista.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão_Banco {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projeto_ALG2",
                    "root",
                    "root");
            System.out.println("Conectado!");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("nutricionista.utils.Erro ao conectar no banco de dados!");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }
}