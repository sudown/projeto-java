package com.lojinha;

public class App {
  public static void main(String[] args) {
    Estoque estoque = new Estoque();
    estoque.carregarEstoqueDoArquivo();
    
    Bebida bebida0 = new Bebida("Coca", 1, 2.5, 10, "Refrigerante", "Coca-Cola", "Refrigerante de cola", "2020-12-01");
    Bebida bebida1 = new Bebida("Fanta", 2, 2.5, 10, "Refrigerante", "Coca-Cola", "Refrigerante de laranja", "2020-12-01");
    Bebida bebida2 = new Bebida("Del vale", 3, 2.5, 10, "Suco", "Coca-Cola", "Suco", "2020-12-01");

    // BebidaAlcoolica bebidaAlcoolica = new BebidaAlcoolica("Cerveja", 2, 2.5, 10, "Cerveja", "Skol", "Cerveja de trigo", "2020-12-01", 5.0, "Cerveja de trigo");
    estoque.listarBebidas();
    estoque.adicionarBebida(bebida0);
    estoque.adicionarBebida(bebida1);
    estoque.adicionarBebida(bebida2);
  }
}
