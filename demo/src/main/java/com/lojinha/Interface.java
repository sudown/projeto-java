package com.lojinha;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interface {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lojinha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 200));

        JButton buttonGerente = new JButton("GERENTE");
        buttonGerente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                InterfaceGerente gerente = new InterfaceGerente();
                gerente.setVisible(true);
                frame.dispose();
            }
        });
        JButton buttonCliente = new JButton("CLIENTE");
        buttonCliente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                InterfaceCliente cliente = new InterfaceCliente();
                cliente.setVisible(true);
                frame.dispose();
            }
        });

        frame.add(buttonGerente);
        frame.add(buttonCliente);

        frame.setVisible(true);
    }
}
