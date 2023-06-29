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
    vendasDB.bebidaMaisVendida();
  }
}
