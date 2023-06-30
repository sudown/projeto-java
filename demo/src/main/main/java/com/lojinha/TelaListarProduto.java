package com.lojinha;

import com.google.gson.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import java.io.*;
import java.util.*;

import com.lojinha.Bebida;
import com.lojinha.Estoque;

public class TelaListarProduto extends JFrame {
    private JTable table;

    public TelaListarProduto(){
        setTitle("Listagem de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Carregar os dados dos produtos
        Estoque estoque = new Estoque();
        estoque.carregarEstoqueDoArquivo();
        ArrayList<Bebida> bebidas = estoque.getBebidas();

        // Criar uma tabela vazia com 8 colunas (ID, Nome, Preço, Quantidade, Tipo, Marca, Descrição, Validade)
        String[] columnNames = {"ID", "Nome", "Preço", "Quantidade", "Tipo", "Marca", "Descrição", "Validade"};
        Object[][] data = new Object[bebidas.size()][8];

        // Preencher a matriz de dados com os produtos
        for (int i = 0; i < bebidas.size(); i++) {
            Bebida bebida = bebidas.get(i);
            data[i][0] = bebida.getId();
            data[i][1] = bebida.getNome();
            data[i][2] = bebida.getPreco();
            data[i][3] = bebida.getQuantidade();
            data[i][4] = bebida.getTipo();
            data[i][5] = bebida.getMarca();
            data[i][6] = bebida.getDescricao();
            data[i][7] = bebida.getDataValidade();
        }

        // Criar o modelo da tabela com os dados   
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);

        setContentPane(contentPane);
    }
    
}
