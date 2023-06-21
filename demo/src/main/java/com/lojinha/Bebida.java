package com.lojinha;

import java.sql.Date;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;

public class Bebida {
  String nome;
  int id;
  double preco;
  int quantidade;
  String tipo;
  String marca;
  String descricao;
  Date dataValidade;
  String json;

  public Bebida(String nome, int id, double preco, int quantidade, String tipo, String marca, String descricao,
      String dataValidade) {
    this.nome = nome;
    this.id = id;
    this.preco = preco;
    this.quantidade = quantidade;
    this.tipo = tipo;
    this.marca = marca;
    this.descricao = descricao;
    this.dataValidade = Date.valueOf("2023-12-12");

    HashMap<String, Object> JsonObj = new HashMap<>();
    JsonObj.put("nome", this.nome);
    JsonObj.put("id", this.id);
    JsonObj.put("preco", this.preco);
    JsonObj.put("quantidade", this.quantidade);
    JsonObj.put("tipo", this.tipo);
    JsonObj.put("marca", this.marca);
    JsonObj.put("descricao", this.descricao);
    JsonObj.put("dataValidade", this.dataValidade);

    try (FileWriter file = new FileWriter("./src/main/java/com/lojinha/bebidas/" + this.id + ".json")) {
      file.write(JsonObj.toString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  void cadastrarBebida() {

  }

  void editarBebida() {

  }

  void excluirBebida() {

  }

  void listarBebida() {

  }

  void adicionarEstoque() {

  }

  void removerEstoque() {

  }

  void venderBebida() {

  }

}
