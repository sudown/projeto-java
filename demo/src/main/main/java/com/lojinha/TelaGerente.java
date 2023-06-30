package com.lojinha;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaGerente extends JFrame {
    public TelaGerente() {
        super("Gerente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        
        JLabel label = new JLabel("Escolha uma opção:");
        
        JButton buttonAddCliente = new JButton("1. Adicionar Cliente");
        buttonAddCliente.setSize(80, 50);
        buttonAddCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar cliente
                TelaCadCliente clienteCad = new TelaCadCliente();
                clienteCad.setVisible(true);
                System.out.println("Adicionar Cliente");
            }
        });

        JButton buttonAddGerente = new JButton("2. Adicionar Gerente");
        buttonAddGerente.setSize(80, 50);
        buttonAddGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar gerente
                TelaCadGerente gerenteCad = new TelaCadGerente();
                gerenteCad.setVisible(true);
                System.out.println("Adicionar Gerente");
            }
        });
        
        JButton buttonListCliente = new JButton("3. Listar Clientes");
        buttonListCliente.setSize(80, 50);
        buttonListCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaListarClientes clienteList = new TelaListarClientes();
                clienteList.setVisible(true);
                System.out.println("Listar Clientes");
            }
        });
        
        JButton buttonListGerente = new JButton("4. Listar Gerentes");
        buttonListGerente.setSize(80, 50);
        buttonListGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para listar gerentes
                TelaListarGerentes gerenteList = new TelaListarGerentes();
                gerenteList.setVisible(true);
                System.out.println("Listar Gerentes");
            }
        });
        
        JButton buttonAttCliente = new JButton("5. Atualizar ou Deletar Cliente");
        buttonAttCliente.setSize(80, 50);
        buttonAttCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar cliente
                TelaEscolhaCliente clienteEscolha = new TelaEscolhaCliente();
                clienteEscolha.setVisible(true);
                System.out.println("Atualizar Cliente");
            }
        });
        
        JButton buttonAttGerente = new JButton("6. Atualizar ou Deletar Gerente");
        buttonAttGerente.setSize(80, 50);
        buttonAttGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar gerente
                TelaEscolhaGerente gerenteEscolha = new TelaEscolhaGerente();
                gerenteEscolha.setVisible(true);
                System.out.println("Atualizar Gerente");
            }
        });
        
        JButton buttonProduto = new JButton("6. Cadastrar Produto");
        buttonProduto.setSize(80, 50);
        buttonProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar gerente
                TelaCadProduto produtoCad = new TelaCadProduto();
                produtoCad.setVisible(true);
                System.out.println("Informações");
            }
        });

        JButton buttonListProduto = new JButton("7. Listar Produto");
        buttonListProduto.setSize(80, 50);
        buttonListProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar gerente
                TelaListarProduto produtoList = new TelaListarProduto();
                produtoList.setVisible(true);
                System.out.println("Listar Produto");
            }
        });

        JButton buttonAttProduto = new JButton("8. Atualizar ou deletar Produto");
        buttonAttProduto.setSize(80, 50);
        buttonAttProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar gerente
                TelaEscolhaProduto produtoEscolha = new TelaEscolhaProduto();
                produtoEscolha.setVisible(true);
                System.out.println("Informações");
            }
        });

        JButton buttonInformações = new JButton("9. Informações");
        buttonInformações.setSize(80, 50);
        buttonInformações.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar gerente
                TelaInformacoes informacoes = new TelaInformacoes();
                informacoes.setVisible(true);
                System.out.println("Informações");
            }
        });
        
        JButton buttonSair = new JButton("0. Sair");
        buttonSair.setSize(80, 50);
        buttonSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sair");
                dispose(); // Fecha a janela
            }
        });
        
        add(label);
        add(buttonAddCliente);
        add(buttonAddGerente);
        add(buttonListCliente);
        add(buttonListGerente);
        add(buttonAttCliente);
        add(buttonAttGerente);
        add(buttonProduto);
        add(buttonListProduto);
        add(buttonAttProduto);
        add(buttonInformações);
        add(buttonSair);
        //setVisible(true);
    }
}
