package com.lojinha;

import com.google.gson.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import java.io.*;
import java.util.*;

import com.lojinha.Cliente;
import com.lojinha.ClienteDB;


public class TelaListarClientes extends JFrame {
    private JTable table;
    

    public TelaListarClientes() {
        setTitle("Listagem de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Carregar os dados dos clientes
        ClienteDB clienteDB = new ClienteDB();
        clienteDB.carregarDoBanco();
        ArrayList<Cliente> clientes = clienteDB.getClientes();

        // Criar uma tabela vazia com 4 colunas (ID, Nome,CPF e Email)
        String[] columnNames = {"ID", "Nome","CPF", "Email"};
        Object[][] data = new Object[clientes.size()][4];

        // Preencher a matriz de dados com os clientes
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            data[i][0] = cliente.getId();
            data[i][1] = cliente.getNome();
            data[i][2] = cliente.getCpf();
            data[i][3] = cliente.getEmail();
        }

        // Criar o modelo da tabela com os dados
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        setContentPane(contentPane);


        // // Preencher a tabela com os dados dos clientes
        // DefaultTableModel model = (DefaultTableModel) table.getModel();
        // for (Cliente cliente : clientes) {
        //     model.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail()});
        // }
    }
}
