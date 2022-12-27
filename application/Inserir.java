package application;

import java.sql.*;

public class Inserir {

    public void inserirNoBanco(Connection connection, String nome, String genero, Time duracao, String ator_principal, String diretor) throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FILME (nome, genero, duracao, ator_principal, diretor) VALUES (?,?,?, ?,?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, genero);
        preparedStatement.setString(3, String.valueOf(duracao));
        preparedStatement.setString(4, ator_principal);
        preparedStatement.setString(5, diretor);

        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi " + id);
        }
    }

}
