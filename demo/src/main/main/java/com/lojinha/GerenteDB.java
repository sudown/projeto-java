package com.lojinha;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GerenteDB {
  private List<Gerente> gerentes;
  
  private String jsonFilePath = "projeto-java-no-interface\\demo\\src\\main\\java\\com\\lojinha\\pessoas\\gerentes.json";

  public GerenteDB() {
    gerentes = new ArrayList<>();
  }

  private static class GerenteDeserializable extends Gerente {
    public GerenteDeserializable() {
      // Construtor padrão vazio
    }
  }

  private void gravarNoBanco() {
    try (Writer writer = new FileWriter(jsonFilePath)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(gerentes, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void carregarDoBanco() {
    try (Reader reader = new FileReader(jsonFilePath)) {
      Gson gson = new Gson();
      GerenteDeserializable[] gerentesArray = gson.fromJson(reader, GerenteDeserializable[].class);
      gerentes = new ArrayList<>();
      Collections.addAll(gerentes, gerentesArray);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void adicionarGerente(Gerente gerente) {
    gerentes.add(gerente);
    gravarNoBanco();
  }

  public void removerGerenteById(int id) {
    for (Gerente gerente : gerentes) {
      if (gerente.getId() == id) {
        gerentes.remove(gerente);
        gravarNoBanco();
        break;
      }
    }
  }

  public Gerente getGerenteById(int id) {
    for (Gerente gerente : gerentes) {
      if (gerente.getId() == id) {
        return gerente;
      }
    }
    return null;
  }

  public ArrayList<Gerente> getGerentes() {
    return (ArrayList<Gerente>) gerentes;
  }

  public void atualizarGerente(Gerente gerenteAtualizado) {
    for (Gerente gerente : gerentes) {
      if (gerente.getId() == gerenteAtualizado.getId()) {
        gerentes.set(gerentes.indexOf(gerente), gerenteAtualizado);
        gravarNoBanco();
        break;
      }
    }
  }

  public void listarGerentes() {
    for (Gerente gerente : gerentes) {
      System.out.println(gerente.getJson());
    }
  }
}
