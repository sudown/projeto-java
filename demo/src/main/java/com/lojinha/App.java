package com.lojinha;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDB clienteDB = new ClienteDB();
        GerenteDB gerenteDB = new GerenteDB();

        int opcao;
        do {
            System.out.println("========= LOJINHA =========");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Gerente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Listar Gerentes");
            System.out.println("5. Atualizar Cliente");
            System.out.println("6. Atualizar Gerente");
            System.out.println("0. Sair");
            System.out.println("===========================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    // Adicionar Cliente
                    Cliente novoCliente = criarCliente(scanner);
                    clienteDB.adicionarCliente(novoCliente);
                    break;
                case 2:
                    // Adicionar Gerente
                    Gerente novoGerente = criarGerente(scanner);
                    gerenteDB.adicionarGerente(novoGerente);
                    break;
                case 3:
                    // Listar Clientes
                    clienteDB.listarClientes();
                    break;
                case 4:
                    // Listar Gerentes
                    gerenteDB.listarGerentes();
                    break;
                case 5:
                    // Atualizar Cliente
                    System.out.print("Informe o ID do Cliente a ser atualizado: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Cliente clienteAtualizado = criarCliente(scanner);
                    clienteAtualizado.setId(idCliente);
                    clienteDB.atualizarCliente(clienteAtualizado);
                    break;
                case 6:
                    // Atualizar Gerente
                    System.out.print("Informe o ID do Gerente a ser atualizado: ");
                    int idGerente = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Gerente gerenteAtualizado = criarGerente(scanner);
                    gerenteAtualizado.setId(idGerente);
                    gerenteDB.atualizarGerente(gerenteAtualizado);
                    break;
                case 0:
                    // Sair
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        } while (opcao != 0);
        
        scanner.close();
    }

    private static Cliente criarCliente(Scanner scanner) {
        System.out.println("Id do Cliente: ");
        int id = scanner.nextInt();
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();
        System.out.print("Idade do Cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        return new Cliente(id, nome, cpf, email, idade);
    }

    private static Gerente criarGerente(Scanner scanner) {
        System.out.println("Id do Gerente: ");
        int id = scanner.nextInt();
        System.out.print("Nome do Gerente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Gerente: ");
        String cpf = scanner.nextLine();
        System.out.print("Email do Gerente: ");
        String email = scanner.nextLine();
        System.out.print("Idade do Gerente: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Código do Gerente: ");
        String codigo = scanner.nextLine();

        return new Gerente(id, nome, cpf, email, idade, codigo);
    }
}
