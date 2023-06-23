package com.lojinha;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Estoque {
  private List<Bebida> bebidas;
  private String jsonFilePath = "./demo/src/main/java/com/lojinha/estoque/estoque.json";

  public Estoque() {
    bebidas = new ArrayList<>();
  }

  public void gravarEstoqueEmArquivo() {
    try (Writer writer = new FileWriter(jsonFilePath)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(bebidas, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void carregarEstoqueDoArquivo() {
    try (Reader reader = new FileReader(jsonFilePath)) {
      Gson gson = new Gson();
      Bebida[] bebidasArray = gson.fromJson(reader, Bebida[].class);
      bebidas = new ArrayList<>();
      Collections.addAll(bebidas, bebidasArray);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void adicionarBebida(Bebida bebida) {
    bebidas.add(bebida);
    gravarEstoqueEmArquivo();
  }

  public void removerBebida(Bebida bebida) {
    bebidas.remove(bebida);
  }

  public void listarBebidas() {
    for (Bebida bebida : bebidas) {
      System.out.println(bebida.getJson());
    }
  }
}
