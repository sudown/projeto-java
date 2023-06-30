package com.lojinha;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.lojinha.ClienteDB;
import com.lojinha.Cliente;



public class TelaEditarCliente extends JFrame {
    TelaEditarCliente(Cliente cliente){
        super("Editar Cliente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 200, 20));
        
        int idAtual = cliente.getId();

        final ClienteDB clienteDB = new ClienteDB();
        clienteDB.carregarDoBanco();

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

        final Cliente clienteAtual = clienteDB.getClienteById(idAtual);


        textFieldNome.setText(cliente.getNome());
        textFieldCpf.setText(cliente.getCpf());
        textFieldEmail.setText(cliente.getEmail());
        textFieldIdade.setText(Integer.toString(cliente.getIdade()));
        textFieldSenha.setText(cliente.getSenha());
        textFieldConfirmarSenha.setText(cliente.getSenha());

        JButton buttonEditCliente = new JButton("Editar Cliente");
        buttonEditCliente.setSize(80, 50);
        buttonEditCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter os dados do campo de texto
                String nome = textFieldNome.getText();
                String cpf = textFieldCpf.getText();
                String email = textFieldEmail.getText();
                int idade = Integer.parseInt(textFieldIdade.getText());
                String senha = new String(textFieldSenha.getPassword());

                // Alterar dados do cliente
                clienteAtual.setNome(nome);
                clienteAtual.setCpf(cpf);
                clienteAtual.setEmail(email);
                clienteAtual.setIdade(idade);
                clienteAtual.setSenha(senha);

                // Salvar alterações
                clienteDB.alterarCliente(clienteAtual);

                System.out.println("Editar Cliente");
            }
        });

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
        add(buttonEditCliente);
        
        setVisible(true);
    }
}
