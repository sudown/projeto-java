package com.lojinha;

import java.sql.Date;

import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.sql.Date;

public class Venda {
  @Expose
  private String id;
  @Expose
  private int idCliente;
  @Expose
  private int idProduto;
  @Expose
  private int quantidade;
  @Expose
  private double valorTotal;
  @Expose
  private Date  data;
  private String json;

  public Venda(int idCliente, int idProduto, int quantidade, String data) {
    this.id = UUID.randomUUID().toString();
    this.idCliente = idCliente;
    this.idProduto = idProduto;
    this.quantidade = quantidade;
    this.data = Date.valueOf(data.toString());

    this.updateJson();
  }

    private void updateJson() {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    this.json = gson.toJson(this);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public int getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(int idProduto) {
    this.idProduto = idProduto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date Data) {
    this.data = Data;
  }

  public Venda() {
  }

}
