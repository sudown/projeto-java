package com.lojinha;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    ClienteDB clienteDB = new ClienteDB();
    VendasDB vendasDB = new VendasDB();
    clienteDB.carregarDoBanco();

    // Bebida cerveja = new Bebida("Cerveja", 1, 5.00, 10, "Alcoolica", "Skol",
    // "Cerveja", "2021-12-31");
    // Bebida refrigerante = new Bebida("Refrigerante", 2, 3.00, 10, "Não
    // alcoolica", "Coca-cola", "Refrigerante",
    // "2021-12-31");
    // Bebida suco = new Bebida("Suco", 3, 2.00, 10, "Não alcoolica", "Del Valle",
    // "Suco", "2021-12-31");

    // estoque.adicionarBebida(cerveja);
    // estoque.adicionarBebida(refrigerante);
    // estoque.adicionarBebida(suco);

    vendasDB.adicionarVenda(1, 1, 3, 10, "2021-12-31");

  }
}
