package com.lojinha;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public abstract class Pessoa {
  @Expose
  private int id;
  @Expose
  private String nome;
  @Expose
  private String cpf;
  @Expose
  private String email;
  @Expose
  private int idade;
  @Expose
  private String senha;
  private String json;

  public Pessoa() {
  }

  public Pessoa(int id, String nome, String cpf, String email, int idade, String senha) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.idade = idade;
    this.id = id;
    this.senha = senha;
    this.updateJson();
  }

  private void updateJson() {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    this.json = gson.toJson(this);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public void setJson(String json) {
    this.json = json;
  }

  public String getJson() {
    return json;
  }
}
