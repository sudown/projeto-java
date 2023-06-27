package com.lojinha;

public class Cliente extends Pessoa {
  public Cliente() {

  }

  public Cliente(int id, String nome, String cpf, String email, int idade) {
    super(id, nome, cpf, email, idade);
  }
}
