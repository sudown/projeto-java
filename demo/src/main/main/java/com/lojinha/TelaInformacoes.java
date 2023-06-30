package com.lojinha;

import java.awt.*;

import javax.swing.*;

import com.lojinha.Venda;
import com.lojinha.VendasDB;


public class TelaInformacoes extends JFrame {
    public TelaInformacoes(){
        super("Informações");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 200, 20));

        //Carregar os dados das vendas
        VendasDB vendasDB = new VendasDB();
        vendasDB.carregarDoBanco();

        int vendasMes = vendasDB.vendasPorMes(2023, 06);
        String bebidaMaisVendida = vendasDB.bebidaMaisVendida();
        String bebidaMenosVendida = vendasDB.bebidaMenosVendida();
        String melhorCliente = vendasDB.melhorCLiente();
        String melhorDia = vendasDB.melhorDia();

        JLabel labelTotal = new JLabel("Total de Vendas do Mês:");
        JLabel labelTotalValor = new JLabel(String.valueOf(vendasMes));

        JLabel labelMais = new JLabel("Produto Mais Vendido:");
        JLabel labelMaisNome = new JLabel(bebidaMaisVendida);
        
        JLabel labelMenos = new JLabel("Produto Menos Vendido:");
        JLabel labelMenosNome = new JLabel(bebidaMenosVendida);

        JLabel labelMelhor = new JLabel("Melhor Cliente:");
        JLabel labelMelhorNome = new JLabel(melhorCliente);

        JLabel labelDia = new JLabel("Dia com mais vendas:");
        JLabel labelDiaNome = new JLabel(melhorDia);


        add(labelTotal);
        add(labelTotalValor);
        add(labelMais);
        add(labelMaisNome);
        add(labelMenos);
        add(labelMenosNome);
        add(labelMelhor);
        add(labelMelhorNome);
        add(labelDia);
        add(labelDiaNome);

        setVisible(true);
    }
}
