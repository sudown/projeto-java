package com.lojinha;

public class BebidaAlcoolica extends Bebida {
    private double teorAlcoolico;
    private String tipoBebidaAlcoolica;

    public double getTeorAlcoolico() {
      return teorAlcoolico;
    }

    public void setTeorAlcoolico(double teorAlcoolico) {
      this.teorAlcoolico = teorAlcoolico;
    }

    public String getTipoBebidaAlcoolica() {
      return tipoBebidaAlcoolica;
    }

    public void setTipoBebidaAlcoolica(String tipoBebidaAlcoolica) {
      this.tipoBebidaAlcoolica = tipoBebidaAlcoolica;
    }

    public BebidaAlcoolica(String nome, int id, double preco, int quantidade, String tipo, String marca, String descricao, String dataValidade, double teorAlcoolico, String tipoBebidaAlcoolica) {
        super(nome, id, preco, quantidade, tipo, marca, descricao, dataValidade);
        this.teorAlcoolico = teorAlcoolico;
        this.tipoBebidaAlcoolica = tipoBebidaAlcoolica;
    }
}
