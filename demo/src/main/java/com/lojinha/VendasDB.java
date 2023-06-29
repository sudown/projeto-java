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
}
