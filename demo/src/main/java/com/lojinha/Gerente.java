package com.lojinha;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class Gerente extends Pessoa {
  @Expose
  private String cod;

  public String getCod() {
    return cod;
  }

  public void setCod(String cod) {
    this.cod = cod;
  }

  public Gerente() {
  }

  public Gerente(String nome, String cpf, String email, int idade, String cod) {
    super(nome, cpf, email, idade);
    this.cod = cod;
  }

  private void updateJson() {
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    this.setJson(gson.toJson(this));
  }

  public String getJson() {
    this.updateJson();
    return super.getJson();
  }
}
