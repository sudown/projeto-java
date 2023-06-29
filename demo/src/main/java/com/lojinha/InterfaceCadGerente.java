package com.lojinha;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InterfaceCadGerente extends JFrame {
    public InterfaceCadGerente(){
        super("Interface Gerente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 200, 20));

        JLabel labelId = new JLabel("Digite seu id:");
        JTextField textFieldId = new JTextField(20);
        
        JLabel labelNome = new JLabel("Digite seu nome:");
        JTextField textFieldNome = new JTextField(40);

        JLabel labelCpf = new JLabel("Digite seu cpf:");
        JTextField textFieldCpf = new JTextField(11);

        JLabel labelEmail = new JLabel("Digite seu email:");
        JTextField textFieldEmail = new JTextField(40);

        JLabel labelIdade = new JLabel("Digite sua idade:");
        JTextField textFieldIdade = new JTextField(3);

        JLabel labelSenha = new JLabel("Digite sua senha:");
        JPasswordField textFieldSenha = new JPasswordField(20);

        JLabel labelConfirmarSenha = new JLabel("Confirme sua senha:");
        JPasswordField textFieldConfirmarSenha = new JPasswordField(20);

        JButton buttonAddGerente = new JButton("Adicionar Gerente");
        buttonAddGerente.setSize(80, 50);
        buttonAddGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar gerente
                System.out.println("Adicionar Gerente");
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
        add(buttonAddGerente);
        
        setVisible(true);
        
    }
}
