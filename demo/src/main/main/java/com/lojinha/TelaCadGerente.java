package com.lojinha;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;

import com.lojinha.GerenteDB;
import com.lojinha.Gerente;

public class TelaCadGerente extends JFrame {
    public TelaCadGerente(){
        super("Interface Gerente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 200, 20));

        final GerenteDB gerenteDB = new GerenteDB();
        gerenteDB.carregarDoBanco();

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

        JLabel labelCod = new JLabel("Digite seu código:");
        final JTextField textFieldCod = new JTextField(3);

        JLabel labelSenha = new JLabel("Digite sua senha:");
        final JPasswordField textFieldSenha = new JPasswordField(20);

        JLabel labelConfirmarSenha = new JLabel("Confirme sua senha:");
        final JPasswordField textFieldConfirmarSenha = new JPasswordField(20);

        JButton buttonAddGerente = new JButton("Adicionar Gerente");
        buttonAddGerente.setSize(80, 50);
        buttonAddGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter os dados do campo de texto
                int id = Integer.parseInt(textFieldId.getText());
                String nome = textFieldNome.getText();
                String cpf = textFieldCpf.getText();
                String email = textFieldEmail.getText();
                int idade = Integer.parseInt(textFieldIdade.getText());
                String cod = textFieldCod.getText();
                String senha = new String(textFieldSenha.getPassword());

                // Criar um objeto gerente
                Gerente gerente = new Gerente(id, nome, cpf, email, idade, cod, senha);

                // Adicionar o gerente 
                gerenteDB.adicionarGerente(gerente);

                // Limpar os campos de texto
                textFieldId.setText("");
                textFieldNome.setText("");
                textFieldCpf.setText("");
                textFieldEmail.setText("");
                textFieldIdade.setText("");
                textFieldCod.setText("");
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
        add(labelCod);
        add(textFieldCod);
        add(labelSenha);
        add(textFieldSenha);
        add(labelConfirmarSenha);
        add(textFieldConfirmarSenha);
        add(buttonAddGerente);
        
        setVisible(true);
        
    }
}
    

