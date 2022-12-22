package application;

import java.sql.*;

public class Listagem {
    Integer id;
    String nome;
    String genero;
    Time duracao;
    String ator_principal;
    String diretor;


    public String listar(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        statement.execute("SELECT  id, nome, genero, duracao, ator_principal, diretor FROM FILME");
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            System.out.println();
            id = resultSet.getInt("id");
            System.out.println("Id do filme: " + id);
            nome = resultSet.getString("nome");
            System.out.println("Nome do filme: " + nome);
            genero = resultSet.getString("genero");
            System.out.println("Gênero: " + genero);

            //COMO CONSULTAR A COLUNA duracao
            duracao = resultSet.getTime("duracao");
            System.out.println("Duração: " + duracao);

            ator_principal = resultSet.getString("ator_principal");
            System.out.println("Ator principal: " + ator_principal);
            diretor = resultSet.getString("diretor");
            System.out.println("Diretor: " + diretor);

            System.out.println("---------------------------------------------------------------------------");

            //return toString();
        }
        return null;
    }

    // MELHORIA FUTURA: IMPLEMENTAR O TO STRING
    /*
    @Override
    public String toString() {
        return "ID do filme: " + id;
    }
     */
}
