package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException, ParseException, IOException {

        Scanner sc = new Scanner(System.in);

        // CAPTAR OS INPUTS DOS USUÁRIOS
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // conexao com o banco de dados mysql
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/cinema?useTimeZone=true&serverTimeZone=UTC", "root", "password");

        int option = 10;
        while (option != 0) {
            option = 10;
            System.out.println("");
            System.out.println("OLÁ, SEJA BEM VINDO À LOCADORA ciNEMO \n");
            System.out.println("Menu de opções: \n 1 - Listar filmes \n 2 - Cadastrar um Filme \n 3 - Cadastrar cliente \n 4 - Alugar filme \n" +
                    " 5 - Devolver Filme \n 0 - Sair");
            option = sc.nextInt();

            if (option == 1) {
                Listagem listagem = new Listagem();
                listagem.listar(connection);
            } else if (option == 2) {         //String nome = sc.nextLine();
                Inserir inserir = new Inserir();
                System.out.print("Cadastre o nome do filme: ");
                String nome = reader.readLine();

                System.out.print("Cadastre o genero do filme: ");
                String genero = reader.readLine();

                System.out.print("Cadastre a duração do filme: ");
                String s = sc.next();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                long ms = sdf.parse(s).getTime();
                Time duracao = new Time(ms);

                System.out.print("Cadastre o ator principal do filme: ");
                String ator_principal = reader.readLine();

                System.out.print("Cadastre o diretor do filme: ");
                String diretor = reader.readLine();

                inserir.inserirNoBanco(connection, nome, genero, duracao, ator_principal, diretor);
            }
            else if (option == 3){
                Cliente cliente = new Cliente();
                System.out.print("Cadastre o nome do cliente: ");
                String nome = reader.readLine();

                System.out.print("Cadastre o CPF do cliente: ");
                String cpf = reader.readLine();

                System.out.print("Cadastre a data de nascimento no formato (ano-mes-dia): ");
                Date nascimento = Date.valueOf(reader.readLine());

                cliente.cadastrarCliente(connection, nome, cpf, nascimento);

            }
            else if(option == 4){
                Aluguel aluguel = new Aluguel();
                LocalDate now = LocalDate.now();
                System.out.println("Data do aluguel: " + now);

                System.out.print("Insira data da devolução (ano-mes-dia): ");
                Date devolucao = Date.valueOf(reader.readLine());

                System.out.print("Digite o cpf do cliente: ");
                String cpf = reader.readLine();

                System.out.println("Digite o id do filme: ");
                int id = Integer.parseInt(reader.readLine());

                aluguel.alugarFilme(connection, Date.valueOf(now), devolucao, cpf, id );

            }
            else if(option == 5){
                Aluguel aluguel = new Aluguel();
                LocalDate now = LocalDate.now();
                System.out.println("Data real da devolução: " + now);

                System.out.print("Digite o ID do aluguel ");
                int id = Integer.parseInt(reader.readLine());

                aluguel.devolverFilme(connection, id, Date.valueOf(now));

                System.out.println("\nFilme devolvido com sucesso! ");
            }


        }
        connection.close();
        reader.close();
        sc.close();
    }
}
