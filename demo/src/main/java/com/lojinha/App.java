package com.lojinha;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    ClienteDB clienteDB = new ClienteDB();
    VendasDB vendasDB = new VendasDB();
    clienteDB.carregarDoBanco();

    Estoque estoque = new Estoque();
    estoque.carregarEstoqueDoArquivo();

    // System.out.println(vendasDB.quantidadeVendida(1));
    // vendasDB.bebidaMenosVendida();
    vendasDB.bebidaMenosVendida();

    Interface interfacePrincipal = new Interface();
  }
}
