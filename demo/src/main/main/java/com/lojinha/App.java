package com.lojinha;

import com.lojinha.TelaInicial;

import java.time.LocalDate;
import java.util.Scanner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.lojinha.ClienteDB;

public class App {
  public static void main(String[] args) {
    System.out.println("Bem vindo a Lojinha!");
    
    ClienteDB clienteDB = new ClienteDB();
    VendasDB vendasDB = new VendasDB();
    GerenteDB gerenteDB = new GerenteDB();
    gerenteDB.carregarDoBanco();
    clienteDB.carregarDoBanco();
    Estoque estoque = new Estoque();
    estoque.carregarEstoqueDoArquivo();

    //INSERIR DADOS NO BANCO

    // Cliente cliente = new Cliente(1, "Joao", "12987654432",
    // "joaozinho@gmail.com", 21, "192");
    // clienteDB.adicionarCliente(cliente);

    // Cliente cliente = new Cliente(2, "Neto", "12356527432",
    // "netinho@gmail.com", 21, "192");
    // clienteDB.adicionarCliente(cliente);

    // Cliente cliente2 = new Cliente(3, "Miro", "32156527432",
    // "miromar@gmail.com", 21, "192");
    // clienteDB.adicionarCliente(cliente2);

    // Gerente gerente = new Gerente(1, "Carlos", "12987654432", "carlos@gmail.com",
    // 21, "192", "123");
    // gerenteDB.adicionarGerente(gerente);

    // Bebida bebida = new Bebida("Wisky", 1, 40, 100, "Wisky", "Wisky",
    // "Destilado", "2020-12-12");
    // Bebida bebida2 = new Bebida("Vodka", 2, 40, 100, "Vodka", "Vodka",
    // "Destilado", "2020-12-12");
    // Bebida bebida3 = new Bebida("Coca-Cola", 3, 7, 100, "Coca-Cola", "Coca-Cola",
    // "Fermentado", "2020-12-12");
    // Bebida bebida4 = new Bebida("Cerveja", 4, 7, 3, "Cerveja", "Skol",
    // "Fermentado", "2020-12-12");

    // estoque.adicionarBebida(bebida);
    // estoque.adicionarBebida(bebida2);
    // estoque.adicionarBebida(bebida3);
    // estoque.adicionarBebida(bebida4);

    // vendasDB.adicionarVenda(1, 1, 2, "2023-06-06");
    // vendasDB.adicionarVenda(2, 2, 3, "2023-06-06");
    // vendasDB.adicionarVenda(1, 2, 1, "2023-06-06");
    // vendasDB.adicionarVenda(2, 4, 1, "2023-06-06");


    // System.out.println(vendasDB.quantidadeVendida(1));
    // vendasDB.adicionarVenda(2, 2, 1, "2023-2-25");
    // vendasDB.bebidaMenosVendida();
    // vendasDB.bebidaMaisVendida();
    // vendasDB.bebidaMenosVendida();

    // vendasDB.melhorCLiente();

    // System.out.println(vendasDB.vendasPorDia(2023, 01, 29));
    // vendasDB.melhorDia();

    /*INTERFACE GRAFICA */
    JFrame frame = new JFrame("Lojinha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 200));

        JButton buttonGerente = new JButton("GERENTE");
        buttonGerente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //frame.setVisible(false);
                TelaGerente gerente = new TelaGerente();
                gerente.setVisible(true);
                System.out.println("Gerente");
            }
        });
        JButton buttonCliente = new JButton("CLIENTE");
        buttonCliente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TelaCliente cliente = new TelaCliente();
                cliente.setVisible(true);
                System.out.println("Cliente");
            }
        });

        frame.add(buttonGerente);
        frame.add(buttonCliente);

        frame.setVisible(true);
  }
}
