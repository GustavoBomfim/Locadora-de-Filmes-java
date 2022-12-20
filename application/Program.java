package application;

import java.sql.*;

public class Program {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/cinema?useTimeZone=true&serverTimeZone=UTC", "root", "password");

        System.out.println("Hello World!");
        System.out.println("connection successful");

        // String result = Listagem(connection);
        listagem(connection);

        /*
        Statement statement = connection.createStatement();
        statement.execute("SELECT  id, nome, genero, duracao, ator_principal, diretor FROM FILME");
        ResultSet resultSet = statement.getResultSet();

        // System.out.println(resultSet);
        while (resultSet.next()){
            System.out.println();
            Integer id = resultSet.getInt("id");
            System.out.println("Id do filme: " + id);
            String nome = resultSet.getString("nome");
            System.out.println("Nome do filme: " + nome);
            String genero = resultSet.getString("genero");
            System.out.println("Gênero: " + genero);

            //COMO CONSULTAR A COLUNA duracao
            Time duracao = resultSet.getTime("duracao");
            System.out.println("Duração: " + duracao);

            String ator_principal = resultSet.getString("ator_principal");
            System.out.println("Ator principal: " + ator_principal);
            String diretor = resultSet.getString("diretor");
            System.out.println("Diretor: " + diretor);

            System.out.println("---------------------------------------------------------------------------");

        }

         */


        connection.close();
    }


    public static void listagem(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SELECT  id, nome, genero, duracao, ator_principal, diretor FROM FILME");
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()){
            System.out.println();
            Integer id = resultSet.getInt("id");
            System.out.println("Id do filme: " + id);
            String nome = resultSet.getString("nome");
            System.out.println("Nome do filme: " + nome);
            String genero = resultSet.getString("genero");
            System.out.println("Gênero: " + genero);

            //COMO CONSULTAR A COLUNA duracao
            Time duracao = resultSet.getTime("duracao");
            System.out.println("Duração: " + duracao);

            String ator_principal = resultSet.getString("ator_principal");
            System.out.println("Ator principal: " + ator_principal);
            String diretor = resultSet.getString("diretor");
            System.out.println("Diretor: " + diretor);

            System.out.println("---------------------------------------------------------------------------");

        }
    }


}
