package com.lojinha;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.lojinha.GerenteDB;
import com.lojinha.Gerente;

public class TelaEscolhaGerente extends JFrame {
    public TelaEscolhaGerente(){
        super("Escolha Gerente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new FlowLayout(FlowLayout.CENTER, 200, 50));

        final GerenteDB gerenteDB = new GerenteDB();
        gerenteDB.carregarDoBanco();
        
        JLabel labelId = new JLabel("Digite o id:");
        final JTextField textFieldId = new JTextField(20);

        JButton excluir = new JButton("Excluir");
        excluir.setSize(80, 50);
        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para excluir cliente
                int id = Integer.parseInt(textFieldId.getText());
                gerenteDB.removerGerenteById(id);
                System.out.println("Excluir Gerente");
                JLabel labelExcluido = new JLabel("Gerente excluido com sucesso");
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
                Gerente gerente = gerenteDB.getGerenteById(id);
                TelaEditarGerente editar = new TelaEditarGerente(gerente);
                editar.setVisible(true);
                System.out.println("Atualizar Gerente");
            }
        });

        add(labelId);
        add(textFieldId);
        add(excluir);
        add(editar);

        setVisible(true);
    }
}
