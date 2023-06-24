package com.lojinha;

public class App {
  public static void main(String[] args) {
    Estoque estoque = new Estoque();
    estoque.carregarEstoqueDoArquivo();

    // Bebida bebida0 = new Bebida("Coca", 1, 2.5, 10, "Refrigerante", "Coca-Cola", "Refrigerante de cola", "2020-12-01");
    // Bebida bebida1 = new Bebida("Fanta", 2, 2.5, 10, "Refrigerante", "Coca-Cola", "Refrigerante de laranja",
    //     "2020-12-01");
    // Bebida bebida2 = new Bebida("Del vale", 3, 2.5, 10, "Suco", "Coca-Cola", "Suco", "2020-12-01");

    // BebidaAlcoolica bebidaAlcoolica0 = new BebidaAlcoolica("Skol", 4, 2.5, 10, "Cerveja", "Ambev", "Cerveja", "2020-12-01", 4.5, "Pilsen");

    // Bebida b = new Bebida();
    // b = estoque.bebidas.get(0);
    // estoque.removerBebida(b);
    // System.out.println(b.getJson());

  }
}
