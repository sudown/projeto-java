package com.lojinha;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;

import com.lojinha.ClienteDB;
import com.lojinha.Cliente;

public class TelaCadCliente extends JFrame {

    public TelaCadCliente(){
        super("Interface Cliente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 200, 20));

        final ClienteDB clienteDB = new ClienteDB();
        clienteDB.carregarDoBanco();

        JLabel labelId = new JLabel("Digite seu id:");
        final JTextField textFieldId = new JTextField(20);
        
        JLabel labelNome = new JLabel("Digite seu nome:");
        final JTextField textFieldNome = new JTextField(40);

        JLabel labelCpf = new JLabel("Digite seu cpf:");
        final JTextField textFieldCpf = new JTextField(11);

        JLabel labelEmail = new JLabel("Digite seu email:");
        final JTextField textFieldEmail = new JTextField(40);

        JLabel labelIdade = new JLabel("Digite sua idade:");
        final JTextField textFieldIdade = new JTextField(3);

        JLabel labelSenha = new JLabel("Digite sua senha:");
        final JPasswordField textFieldSenha = new JPasswordField(20);

        JLabel labelConfirmarSenha = new JLabel("Confirme sua senha:");
        final JPasswordField textFieldConfirmarSenha = new JPasswordField(20);

        JButton buttonAddCliente = new JButton("Adicionar Cliente");
        buttonAddCliente.setSize(80, 50);
        buttonAddCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter os dados do campo de texto
                int id = Integer.parseInt(textFieldId.getText());
                String nome = textFieldNome.getText();
                String cpf = textFieldCpf.getText();
                String email = textFieldEmail.getText();
                int idade = Integer.parseInt(textFieldIdade.getText());
                String senha = new String(textFieldSenha.getPassword());

                // Criar um objeto cliente
                Cliente cliente = new Cliente(id, nome, cpf, email, idade, senha);

                // Adicionar o cliente 
                clienteDB.adicionarCliente(cliente);

                // Limpar os campos
                textFieldId.setText("");
                textFieldNome.setText("");
                textFieldCpf.setText("");
                textFieldEmail.setText("");
                textFieldIdade.setText("");
                textFieldSenha.setText("");
                textFieldConfirmarSenha.setText("");

            }
        });

        add(labelId);
        add(textFieldId);
        add(labelNome);
        add(textFieldNome);
        add(labelCpf);
        add(textFieldCpf);
        add(labelEmail);
        add(textFieldEmail);
        add(labelIdade);
        add(textFieldIdade);
        add(labelSenha);
        add(textFieldSenha);
        add(labelConfirmarSenha);
        add(textFieldConfirmarSenha);
        add(buttonAddCliente);
        
        setVisible(true);
    }
    
}
