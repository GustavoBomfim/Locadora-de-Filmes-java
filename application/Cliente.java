package application;

import java.sql.*;

public class Cliente {

    public void cadastrarCliente(Connection connection, String nome_cliente, String cpf, Date nascimento) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CLIENTE(nome_cliente, cpf, nascimento)" +
                " VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, nome_cliente);
        preparedStatement.setString(2, cpf);
        preparedStatement.setDate(3, nascimento);

        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi " + id);
        }
    }
}
