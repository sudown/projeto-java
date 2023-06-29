package com.lojinha;

import java.time.LocalDate;
import java.util.Scanner;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public class App {
  public static void main(String[] args) {
    ClienteDB clienteDB = new ClienteDB();
    VendasDB vendasDB = new VendasDB();
    GerenteDB gerenteDB = new GerenteDB();
    gerenteDB.carregarDoBanco();
    clienteDB.carregarDoBanco();
    Estoque estoque = new Estoque();
    estoque.carregarEstoqueDoArquivo();

    //INSERIR DADOS NO BANCO

    // Cliente cliente = new Cliente(1, "Joao", "12987654432",
    // "joaozinho@gmail.com", 21, "192");
    // clienteDB.adicionarCliente(cliente);

    // Gerente gerente = new Gerente(1, "Carlos", "12987654432", "carlos@gmail.com",
    // 21, "192", "123");
    // gerenteDB.adicionarGerente(gerente);

    // Bebida bebida = new Bebida("Wisky", 1, 40, 100, "Wisky", "Wisky",
    // "Destilado", "2020-12-12");
    // Bebida bebida2 = new Bebida("Vodka", 2, 40, 100, "Vodka", "Vodka",
    // "Destilado", "2020-12-12");
    // Bebida bebida3 = new Bebida("Coca-Cola", 3, 7, 100, "Coca-Cola", "Coca-Cola",
    // "Fermentado", "2020-12-12");

    // estoque.adicionarBebida(bebida);
    // estoque.adicionarBebida(bebida2);
    // estoque.adicionarBebida(bebida3);

    // vendasDB.adicionarVenda(1, 1, 2, "2023-06-06");
    // vendasDB.adicionarVenda(2, 2, 3, "2023-06-06");
    // vendasDB.adicionarVenda(1, 2, 1, "2023-06-06");

    //--------------------------------------------------//

    // System.out.println(vendasDB.quantidadeVendida(1));
    // vendasDB.adicionarVenda(2, 2, 1, "2023-2-25");
    // vendasDB.bebidaMenosVendida();
    // vendasDB.bebidaMaisVendida();
    // vendasDB.bebidaMenosVendida();

    // vendasDB.melhorCLiente();

    // System.out.println(vendasDB.vendasPorDia(2023, 01, 29));
    // vendasDB.melhorDia();

  }
}
