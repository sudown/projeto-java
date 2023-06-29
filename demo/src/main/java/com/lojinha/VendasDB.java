package com.lojinha;

import java.io.*;
import java.time.LocalDate;
import java.sql.Date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VendasDB {
  private List<Venda> vendas;
  private String jsonFilePath = "./demo/src/main/java/com/lojinha/vendas/vendas.json";

  public VendasDB() {
    vendas = new ArrayList<>();
  }

  public void gravarNoBanco() {
    try (Writer writer = new FileWriter(jsonFilePath)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(vendas, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void carregarDoBanco() {
    try (Reader reader = new FileReader(jsonFilePath)) {
      Gson gson = new Gson();
      Venda[] vendasArray = gson.fromJson(reader, Venda[].class);
      vendas = new ArrayList<>();
      Collections.addAll(vendas, vendasArray);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void adicionarVenda(int idCliente, int idBebida, int quantidade, String data) {
    Estoque estoque = new Estoque();
    estoque.carregarEstoqueDoArquivo();
    carregarDoBanco();

    Bebida bebida = estoque.getBebidaId(idBebida);
    estoque.Vender(idBebida, quantidade);
    Venda venda = new Venda(idCliente, idBebida, quantidade, data);
    venda.setValorTotal(quantidade * bebida.getPreco());
    vendas.add(venda);
    gravarNoBanco();
  }

  public int vendasPorMes(int ano, int mes) {
    carregarDoBanco();
    int totalBebidasVendidas = 0;
    for (Venda venda : vendas) {
      Date dataVenda = venda.getData();
      LocalDate localDate = dataVenda.toLocalDate();
      if (localDate.getYear() == ano && localDate.getMonthValue() == mes) {
        totalBebidasVendidas += venda.getQuantidade();
      }
    }
    return totalBebidasVendidas;
  }

  public int quantidadeVendida(int id) {
    carregarDoBanco();
    int totalBebidasVendidas = 0;
    for (Venda venda : vendas) {
      if (venda.getIdProduto() == id) {
        totalBebidasVendidas += venda.getQuantidade();
      }
    }
    return totalBebidasVendidas;
  }

  public void bebidaMaisVendida(){
    carregarDoBanco();
    int quantidadeVendida = 0;
    Bebida bebidaMaisVendida = new Bebida();

    for (Venda venda : vendas) {
      int quantidade = quantidadeVendida(venda.getIdProduto());
      if (quantidade > quantidadeVendida) {
        quantidadeVendida = quantidade;
        Estoque estoque = new Estoque();
        estoque.carregarEstoqueDoArquivo();
        bebidaMaisVendida = estoque.getBebidaId(venda.getIdProduto());
      }
    }
    System.out.println("A bebida mais vendida foi " + bebidaMaisVendida.getNome() + " com " + quantidadeVendida + " unidades vendidas, arrecadacao de R$ " + quantidadeVendida * bebidaMaisVendida.getPreco() + " reais.");
  }

  public void bebidaMenosVendida(){
    carregarDoBanco();
    int quantidadeVendida = Integer.MAX_VALUE;  
    Bebida bebidaMenosVendida = new Bebida();

    for (Venda venda : vendas) {
      int quantidade = quantidadeVendida(venda.getIdProduto());
      if (quantidade < quantidadeVendida) {
        quantidadeVendida = quantidade;
        Estoque estoque = new Estoque();
        estoque.carregarEstoqueDoArquivo();
        bebidaMenosVendida = estoque.getBebidaId(venda.getIdProduto());
      }
    }
    System.out.println("A bebida menos vendida foi " + bebidaMenosVendida.getNome() + " com " + quantidadeVendida + " unidades vendidas, arrecadacao de R$ " + quantidadeVendida * bebidaMenosVendida.getPreco() + " reais.");
  }
}
