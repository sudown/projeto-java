package com.lojinha;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.lojinha.Estoque;
import com.lojinha.Bebida;

public class TelaEscolhaProduto extends JFrame {
    public TelaEscolhaProduto(){
        super("Escolha Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new FlowLayout(FlowLayout.CENTER, 200, 50));

        final Estoque estoque = new Estoque();
        estoque.carregarEstoqueDoArquivo();
        
        JLabel labelId = new JLabel("Digite o id:");
        final JTextField textFieldId = new JTextField(20);

        JButton excluir = new JButton("Excluir");
        excluir.setSize(80, 50);
        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para excluir cliente
                int id = Integer.parseInt(textFieldId.getText());
                estoque.removerBebidaById(id);
                System.out.println("Excluir Produto");
                JLabel labelExcluido = new JLabel("Produto excluido com sucesso");
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
                Bebida bebida = estoque.getBebidaById(id);
                TelaEditarProduto editar = new TelaEditarProduto(bebida);
                editar.setVisible(true);
                System.out.println("Atualizar Produto");
            }
        });

        add(labelId);
        add(textFieldId);
        add(excluir);
        add(editar);

        setVisible(true);
    }
}
