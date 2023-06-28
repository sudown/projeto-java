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

  public void adicionarVenda(int idCliente, int idBebida, int quantidade, double valorTotal, String  data) {
    Estoque estoque = new Estoque();
    estoque.carregarEstoqueDoArquivo();

    Bebida bebida = estoque.getBebidaId(idBebida);
    estoque.Vender(idBebida, quantidade);
    Venda venda = new Venda(idCliente, idBebida, quantidade, valorTotal, data);
    vendas.add(venda);
    gravarNoBanco();
  }
}
