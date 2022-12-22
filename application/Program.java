package application;

import java.sql.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/cinema?useTimeZone=true&serverTimeZone=UTC", "root", "password");

        System.out.println("Hello World!");
        System.out.println("connection successful");

        Listagem listagem = new Listagem();
        listagem.listar(connection);

        inserir(connection);

        //Receber inputs do usuário
        /*Scanner sc = new Scanner(System.in);

        System.out.print("Cadastre o nome do filme: ");
        String nome = sc.next();

        System.out.print("Cadastre o genero do filme: ");
        String genero = sc.next();

        System.out.print("Cadastre o ator principal do filme: ");
        String ator_principal = sc.next();

        System.out.print("Cadastre o diretor do filme: ");
        String diretor = sc.next();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FILME (nome, genero, ator_principal, diretor) VALUES (?,?,?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, genero);
        preparedStatement.setString(3, ator_principal);
        preparedStatement.setString(4, diretor);

        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi " + id);
        }

         */




        connection.close();
    }


    public static void inserir(Connection connection) throws SQLException{
        Scanner sc = new Scanner(System.in);

        System.out.print("Cadastre o nome do filme: ");
        String nome = sc.next();

        sc.next();
        System.out.print("Cadastre o genero do filme: ");
        String genero = sc.next();

        sc.next();
        System.out.print("Cadastre o ator principal do filme: ");
        String ator_principal = sc.next();

        sc.next();
        System.out.print("Cadastre o diretor do filme: ");
        String diretor = sc.next();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FILME (nome, genero, ator_principal, diretor) VALUES (?,?,?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, genero);
        preparedStatement.setString(3, ator_principal);
        preparedStatement.setString(4, diretor);

        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi " + id);
        }

    }


}
