package com.lojinha;

import com.google.gson.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import java.io.*;
import java.util.*;

import com.lojinha.Gerente;
import com.lojinha.GerenteDB;

public class TelaListarGerentes extends JFrame {
    private JTable table;

    public TelaListarGerentes(){
        setTitle("Listagem de Gerentes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Carregar os dados dos gerentes
        GerenteDB gerenteDB = new GerenteDB();
        gerenteDB.carregarDoBanco();
        ArrayList<Gerente> gerentes = gerenteDB.getGerentes();

        // Criar uma tabela vazia com 4 colunas (ID, Nome, Email)
        String[] columnNames = {"ID", "Nome","CPF", "Email"};
        Object[][] data = new Object[gerentes.size()][4];

        // Preencher a matriz de dados com os gerentes
        for (int i = 0; i < gerentes.size(); i++) {
            Gerente gerente = gerentes.get(i);
            data[i][0] = gerente.getId();
            data[i][1] = gerente.getNome();
            data[i][2] = gerente.getCpf();
            data[i][3] = gerente.getEmail();
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
