package com.lojinha;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.lojinha.ClienteDB;
import com.lojinha.Cliente;

public class TelaEscolhaCliente extends JFrame {
    public TelaEscolhaCliente(){
        super("Escolha Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new FlowLayout(FlowLayout.CENTER, 200, 50));

        final ClienteDB clienteDB = new ClienteDB();
        clienteDB.carregarDoBanco();
        
        JLabel labelId = new JLabel("Digite o id:");
        final JTextField textFieldId = new JTextField(20);

        JButton excluir = new JButton("Excluir");
        excluir.setSize(80, 50);
        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para excluir cliente
                int id = Integer.parseInt(textFieldId.getText());
                clienteDB.removerClienteById(id);
                System.out.println("Excluir Cliente");
                JLabel labelExcluido = new JLabel("Cliente excluido com sucesso");
                add(labelExcluido);

                textFieldId.setText("");
            }
        });

        JButton editar = new JButton("Editar");
        editar.setSize(80, 50);
        editar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar cliente
                int id = Integer.parseInt(textFieldId.getText());
                Cliente cliente = clienteDB.getClienteById(id);
                TelaEditarCliente editar = new TelaEditarCliente(cliente);
                editar.setVisible(true);
                System.out.println("Atualizar Cliente");
            }
        });

        add(labelId);
        add(textFieldId);
        add(excluir);
        add(editar);

        setVisible(true);
    }    
}
