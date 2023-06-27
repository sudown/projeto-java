package com.lojinha;

public class App {
  public static void main(String[] args) {
    Estoque estoque = new Estoque();
    GerenteDB gerenteDB = new GerenteDB();
    ClienteDB clienteDB = new ClienteDB();
    gerenteDB.carregarDoBanco();
    clienteDB.carregarDoBanco();

    Cliente cliente1 = new Cliente(2, "Jose", "123.456.789-00", "email", 20);
    Cliente clienteAtualizado = new Cliente(2, "Joao", "123.456.789-00", "email", 20);

    clienteDB.adicionarCliente(clienteAtualizado);

    Gerente gerente1 = new Gerente(1, "Jose", "123.456.789-00", "email", 20, "123");
    Gerente gerenteAtualizado = new Gerente(1, "Jose Alberto", "123.456.789-00", "joseAlberto@gmail.com", 20, "123");

    gerenteDB.adicionarGerente(gerenteAtualizado);

  }
}
