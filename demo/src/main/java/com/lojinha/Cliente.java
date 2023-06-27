package com.lojinha;

public class Cliente extends Pessoa {
  public Cliente() {

  }

  public Cliente(int id, String nome, String cpf, String email, int idade, String senha) {
    super(id, nome, cpf, email, idade, senha);
  }
}
