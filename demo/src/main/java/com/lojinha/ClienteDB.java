package com.lojinha;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClienteDB {
  private List<Cliente> clientes;
  private String jsonFilePath = "./demo/src/main/java/com/lojinha/pessoas/clientes.json";

  public ClienteDB() {
    clientes = new ArrayList<>();
  }

  private static class ClienteDeserializable extends Cliente {
    public ClienteDeserializable() {
      // Construtor padrão vazio
    }
  }

  private void gravarNoBanco() {
    try (Writer writer = new FileWriter(jsonFilePath)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(clientes, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void carregarDoBanco() {
    try (Reader reader = new FileReader(jsonFilePath)) {
      Gson gson = new Gson();
      ClienteDeserializable[] clientesArray = gson.fromJson(reader, ClienteDeserializable[].class);
      clientes = new ArrayList<>();
      Collections.addAll(clientes, clientesArray);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void adicionarCliente(Cliente cliente) {
    clientes.add(cliente);
    gravarNoBanco();
  }

  public void removerClienteById(int id) {
    for (Cliente cliente : clientes) {
      if (cliente.getId() == id) {
        clientes.remove(cliente);
        gravarNoBanco();
        break;
      }
    }
  }

  public void atualizarCliente(Cliente clienteAtualizado) {
    for (Cliente cliente : clientes) {
      if (cliente.getId() == clienteAtualizado.getId()) {
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setIdade(clienteAtualizado.getIdade());
        gravarNoBanco();
        break;
      }
    }

  }

  public void listarClientes() {
    for (Cliente cliente : clientes) {
      System.out.println(cliente.getJson());
    }
  }
}