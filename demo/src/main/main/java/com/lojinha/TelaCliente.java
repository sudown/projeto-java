package com.lojinha;

import java.awt.*;

import javax.swing.*;

public class TelaCliente extends JFrame {
    public TelaCliente(){
        super("Venda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));

        JLabel labelId = new JLabel("Digite o id:");
        JTextField textFieldId = new JTextField(20);

        JLabel labelIdCliente = new JLabel("Digite o Id do cliente:");
        JTextField textFieldIdCliente = new JTextField(40);

        JLabel labelIdProduto = new JLabel("Digite o Id do produto:");
        JTextField textFieldIdProduto = new JTextField(10);

        JLabel labelQuant = new JLabel("Digite a quantidade:");
        JTextField textFieldQuant = new JTextField(3);

        JLabel labelValor = new JLabel("Calcular o total:");
        JTextField textFieldValor = new JTextField(10);

        JLabel labelData = new JLabel("Digite a data:");
        JTextField textFieldData = new JTextField(8);

        JButton buttonAddProduto = new JButton("Adicionar Produto");
        buttonAddProduto.setSize(80, 50);

        JButton buttonFinalizar = new JButton("Finalizar");
        buttonFinalizar.setSize(80, 50);

        add(labelId);
        add(textFieldId);
        add(labelIdCliente);
        add(textFieldIdCliente);
        add(labelIdProduto);
        add(textFieldIdProduto);
        add(labelQuant);
        add(textFieldQuant);
        add(labelValor);
        add(textFieldValor);
        add(labelData);
        add(textFieldData);
        add(buttonAddProduto);
        add(buttonFinalizar);

        setVisible(true);
    }
}
