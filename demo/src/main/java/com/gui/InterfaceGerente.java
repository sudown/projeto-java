package com.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class InterfaceGerente extends JFrame {
    public InterfaceGerente() {
        super("Interface Gerente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        
        
        JLabel label = new JLabel("Escolha uma opção:");

        JButton buttonAddCliente = new JButton("1. Adicionar Cliente");
        buttonAddCliente.setSize(80, 50);
        buttonAddCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar cliente
                System.out.println("Adicionar Cliente");
            }
        });

        JButton buttonAddGerente = new JButton("2. Adicionar Gerente");
        buttonAddGerente.setSize(80, 50);
        buttonAddGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar gerente
                CoisaGerente gerentePanel = new CoisaGerente();
                gerentePanel.setVisible(true);
                System.out.println("Adicionar Gerente");
            }
        });
        
        JButton buttonListCliente = new JButton("3. Listar Clientes");
        buttonListCliente.setSize(80, 50);
        buttonListCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para listar clientes
                System.out.println("Listar Clientes");
            }
        });
        
        JButton buttonListGerente = new JButton("4. Listar Gerentes");
        buttonListGerente.setSize(80, 50);
        buttonListGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para listar gerentes
                System.out.println("Listar Gerentes");
            }
        });
        
        JButton buttonAttCliente = new JButton("5. Atualizar Cliente");
        buttonAttCliente.setSize(80, 50);
        buttonAttCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar cliente
                System.out.println("Atualizar Cliente");
            }
        });
        
        JButton buttonAttGerente = new JButton("6. Atualizar Gerente");
        buttonAttGerente.setSize(80, 50);
        buttonAttGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar gerente
                System.out.println("Atualizar Gerente");
            }
        });
        
        JButton buttonSair = new JButton("0. Sair");
        buttonSair.setSize(80, 50);
        buttonSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para sair do programa
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
        add(buttonSair);

    }
}
