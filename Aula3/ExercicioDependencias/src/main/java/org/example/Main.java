package org.example;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Informações para conectar ao bd
        String url = "jdbc:mysql://localhost:3306/statlog";
        String user = "root";
        String password = "root";  
        
        try {
            // Conexão com o bd
            Connection connection = DriverManager.getConnection(url, user, password);
            
            // Criação do statement
            Statement statement = connection.createStatement();

            // Fazer um select das 5 primeiras linhas do dataset
            String query = "SELECT * FROM germancredit LIMIT 5";
            ResultSet resultSet = statement.executeQuery(query);

            // Pegar informações do dataset
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Mostrar resultados
            while (resultSet.next()){
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(metaData.getColumnName(i) + " = " + resultSet.getInt(i));
                }
                System.out.println(" ");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



