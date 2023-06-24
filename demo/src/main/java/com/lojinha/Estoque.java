package com.lojinha;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Estoque {
  public List<Bebida> bebidas;
  public String jsonFilePath = "./demo/src/main/java/com/lojinha/estoque/estoque.json";

  public Estoque() {
    bebidas = new ArrayList<>();
  }

  private void gravarEstoqueEmArquivo() {
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

  public void removerBebidaByBebida(Bebida bebida) {
    bebidas.remove(bebida);
    gravarEstoqueEmArquivo();
  }

  public void removerBebidaById(int id) {
    for (Bebida bebida : bebidas) {
      if (bebida.getId() == id) {
        bebidas.remove(bebida);
        gravarEstoqueEmArquivo();
      }
    }
  }

  public void listarBebidas() {
    for (Bebida bebida : bebidas) {
      System.out.println(bebida.getJson());
    }
  }

  public void listarBebidasNaoAlcoolicas() {
    for (Bebida bebida : bebidas) {
      if (!bebida.getTipo().equals("Alcoolica")) {
        System.out.println(bebida.getJson()); //pensar em melhorar isso
      }
    }
  }

  public void listarBebidasAlcoolicas() {
    for (Bebida bebida : bebidas) {
      if (bebida.getTipo().equals("Alcoolica")) {
        System.out.println(bebida.getJson()); //pensar em melhorar isso
      }
    }
  }

  public void atualizarBebida(){
    
  }
}
