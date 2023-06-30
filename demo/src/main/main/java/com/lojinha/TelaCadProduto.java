package com.lojinha;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;

import com.lojinha.Estoque;
import com.lojinha.Bebida;

public class TelaCadProduto extends JFrame {
    public TelaCadProduto(){
        super("Cadastro Produto");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 200, 20));

        final Estoque estoque = new Estoque();
        estoque.carregarEstoqueDoArquivo();

        JLabel labelId = new JLabel("Digite seu id:");
        final JTextField textFieldId = new JTextField(20);
        
        JLabel labelNome = new JLabel("Digite seu nome:");
        final JTextField textFieldNome = new JTextField(40);

        JLabel labePreco = new JLabel("Digite o preço:");
        final JTextField textFieldPreco = new JTextField(10);

        JLabel labelQuant = new JLabel("Digite a quantidade:");
        final JTextField textFieldQuant = new JTextField(3);

        JLabel labelTipo = new JLabel("Digite o Tipo:");
        final JTextField textFieldTipo = new JTextField(20);

        JLabel LabelMarca = new JLabel("Digite a Marca:");
        final JTextField textFieldMarca = new JTextField(20);

        JLabel LabelDescricao = new JLabel("Digite a Descrição:");
        final JTextField textFieldDescricao = new JTextField(30);

        JLabel LabelValidade = new JLabel("Digite a Validade:");
        final JTextField textFieldValidade = new JTextField(8);

        JButton buttonAddProduto = new JButton("Adicionar Produto");
        buttonAddProduto.setSize(80, 50);
        buttonAddProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter os dados do campo de texto
                int id = Integer.parseInt(textFieldId.getText());
                String nome = textFieldNome.getText();
                double preco = Double.parseDouble(textFieldPreco.getText());
                int quant = Integer.parseInt(textFieldQuant.getText());
                String tipo = textFieldTipo.getText();
                String marca = textFieldMarca.getText();
                String descricao = textFieldDescricao.getText();
                String validade = textFieldValidade.getText();

                // Criar um objeto cliente
                Bebida bebida = new Bebida(nome, id, preco, quant, tipo, marca, descricao, validade);

                // Adicionar o cliente 
                estoque.adicionarBebida(bebida);
                

                // Limpar os campos de texto
                textFieldId.setText("");
                textFieldNome.setText("");
                textFieldPreco.setText("");
                textFieldQuant.setText("");
                textFieldTipo.setText("");
                textFieldMarca.setText("");
                textFieldDescricao.setText("");
                textFieldValidade.setText("");
            }
        });

        add(labelId);
        add(textFieldId);
        add(labelNome);
        add(textFieldNome);
        add(labePreco);
        add(textFieldPreco);
        add(labelQuant);
        add(textFieldQuant);
        add(labelTipo);
        add(textFieldTipo);
        add(LabelMarca);
        add(textFieldMarca);
        add(LabelDescricao);
        add(textFieldDescricao);
        add(LabelValidade);
        add(textFieldValidade);
        add(buttonAddProduto);

        setVisible(true);
    }
}
