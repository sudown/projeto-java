package com.lojinha;

import java.sql.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class Bebida {
  @Expose
  private String nome;
  @Expose
  private int id;
  @Expose
  private double preco;
  @Expose
  private int quantidade;
  @Expose
  private String tipo;
  @Expose
  private String marca;
  @Expose
  private String descricao;
  @Expose
  private Date dataValidade;
  private String json;

  public Bebida() {
  }

  public Bebida(String nome, int id, double preco, int quantidade, String tipo, String marca, String descricao,
      String dataValidade) {
    this.nome = nome;
    this.id = id;
    this.preco = preco;
    this.quantidade = quantidade;
    this.tipo = tipo;
    this.marca = marca;
    this.descricao = descricao;
    this.dataValidade = Date.valueOf(dataValidade);

    this.updateJson();
  }

  private void updateJson() {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    this.json = gson.toJson(this);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
    this.updateJson();
  }

  public int getId() {
    return id;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
    this.updateJson();

  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
    this.updateJson();

  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
    this.updateJson();

  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
    this.updateJson();

  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
    this.updateJson();

  }

  public Date getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(Date dataValidade) {
    this.dataValidade = dataValidade;
    this.updateJson();
  }

  public String getJson() {
    return json;
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
