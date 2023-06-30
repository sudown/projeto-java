package com.lojinha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lojinha.Estoque;
import com.lojinha.Bebida;

public class TelaEditarProduto extends JFrame {
    public TelaEditarProduto(Bebida bebida){
        super("Editar Produto");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 200, 20));

        final int idAtual = bebida.getId();
        
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

        final Bebida bebidaAtual =new Estoque().getBebidaById(idAtual);

        textFieldNome.setText(bebida.getNome());
        textFieldPreco.setText(Double.toString(bebida.getPreco()));
        textFieldQuant.setText(Integer.toString(bebida.getQuantidade()));
        textFieldTipo.setText(bebida.getTipo());
        textFieldMarca.setText(bebida.getMarca());
        textFieldDescricao.setText(bebida.getDescricao());
        textFieldValidade.setText(new SimpleDateFormat("dd/MM/yyyy").format(bebidaAtual.getDataValidade()));

        JButton buttonEditProduto = new JButton("Adicionar Produto");
        buttonEditProduto.setSize(80, 50);
        buttonEditProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter os dados do campo de texto
                String nome = textFieldNome.getText();
                double preco = Double.parseDouble(textFieldPreco.getText());
                int quantidade = Integer.parseInt(textFieldQuant.getText());
                String tipo = textFieldTipo.getText();
                String marca = textFieldMarca.getText();
                String descricao = textFieldDescricao.getText();
                 Date dataValidade = null;
                try {
                    dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldValidade.getText());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                Bebida bebida = new Bebida(nome, idAtual, preco, quantidade, tipo, marca, descricao, dataValidade);
                new Estoque().alterarBebida(idAtual, bebida);
                dispose();
            }

        });

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
