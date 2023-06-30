package com.lojinha;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClienteDB {
  private List<Cliente> clientes;
  private String jsonFilePath = "projeto-java-no-interface\\demo\\src\\main\\java\\com\\lojinha\\pessoas\\clientes.json";

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

  public void alterarCliente(Cliente cliente) {
    for (Cliente clienteAtual : clientes) {
      if (clienteAtual.getId() == cliente.getId()) {
        clientes.set(clientes.indexOf(clienteAtual), cliente);
        gravarNoBanco();
        break;
      }
    }
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

  public Cliente getClienteById(int id) {
    for (Cliente cliente : clientes) {
      if (cliente.getId() == id) {
        return cliente;
      }
    }
    return null;
  }

  public ArrayList<Cliente> getClientes() {
    return new ArrayList<>(clientes);
  }


  public void atualizarCliente(Cliente clienteAtualizado) {
    for (Cliente cliente : clientes) {
      if (cliente.getId() == clienteAtualizado.getId()) {
        clientes.set(clientes.indexOf(cliente), clienteAtualizado);
        gravarNoBanco();
        break;
      }
    }
  }

  public Boolean autenticaCliente(String email, String senha) {
    for (Cliente cliente : clientes) {
      if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
        return true;
      }
    }
    return false;
  }

  public void listarClientes() {
    for (Cliente cliente : clientes) {
      System.out.println(cliente.getJson());
    }
  }
}