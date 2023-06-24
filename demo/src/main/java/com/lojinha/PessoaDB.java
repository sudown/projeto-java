package com.lojinha;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PessoaDB {
  public List<Pessoa> pessoas;
  public String jsonFilePath = "./demo/src/main/java/com/lojinha/pessoas/pessoas.json";

  public PessoaDB() {
    pessoas = new ArrayList<>();
  }

  private static class PessoaDeserializable extends Pessoa {
    public PessoaDeserializable() {
      // Construtor padrão vazio
    }
  }

  private void gravarNoBanco() {
    try (Writer writer = new FileWriter(jsonFilePath)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(pessoas, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void carregarDoBanco() {
    try (Reader reader = new FileReader(jsonFilePath)) {
      Gson gson = new Gson();
      PessoaDeserializable[] pessoasArray = gson.fromJson(reader, PessoaDeserializable[].class);
      pessoas = new ArrayList<>();
      for (PessoaDeserializable pessoa : pessoasArray) {
        pessoas.add(pessoa);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void adicionarPessoa(Pessoa pessoa) {
    pessoas.add(pessoa);
    gravarNoBanco();
  }

  public void removerPessoaById(int id) {
    for (Pessoa pessoa : pessoas) {
      if (pessoa.getId() == id) {
        pessoas.remove(pessoa);
        gravarNoBanco();
      }
    }
  }

  public void listarPessoas() {
    for (Pessoa pessoa : pessoas) {
      System.out.println(pessoa.getJson());
    }
  }

  public void listarGerentes() {
    for (Pessoa pessoa : pessoas) {
      if (pessoa instanceof Gerente) {
        System.out.println(pessoa.getJson());
      }
    }
  }

  public void listarClientes() {
    for (Pessoa pessoa : pessoas) {
      if (pessoa instanceof Cliente) {
        System.out.println(pessoa.getJson());
      }
    }
  }

}
