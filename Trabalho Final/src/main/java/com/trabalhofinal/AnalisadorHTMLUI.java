package com.trabalhofinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class AnalisadorHTMLUI extends JFrame {

    private JTextField txtArquivo;
    private JButton btnAnalisar;
    private JTextArea txtResultado;
    private JTable tabelaTags;
    private DefaultTableModel modeloTabela;

    public AnalisadorHTMLUI() {
        super("Analisador de HTML");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelSuperior = new JPanel(new BorderLayout(5, 5));
        JLabel lblArquivo = new JLabel("Arquivo:");
        txtArquivo = new JTextField();
        btnAnalisar = new JButton("Analisar");
        painelSuperior.add(lblArquivo, BorderLayout.WEST);
        painelSuperior.add(txtArquivo, BorderLayout.CENTER);
        painelSuperior.add(btnAnalisar, BorderLayout.EAST);
        add(painelSuperior, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));

        txtResultado = new JTextArea(5, 50);
        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);
        txtResultado.setText("Informe um arquivo para análise.");
        JScrollPane scrollResultado = new JScrollPane(txtResultado);
        scrollResultado.setBorder(BorderFactory.createTitledBorder("Resultado da Análise"));
        painelCentral.add(scrollResultado);

        String[] colunas = {"Tag", "Número de Ocorrências"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaTags = new JTable(modeloTabela);
        JScrollPane scrollTabela = new JScrollPane(tabelaTags);
        scrollTabela.setBorder(BorderFactory.createTitledBorder("Tags encontradas (ordenadas alfabeticamente)"));
        painelCentral.add(scrollTabela);

        add(painelCentral, BorderLayout.CENTER);

        btnAnalisar.addActionListener(e -> processarArquivo());
    }

    private void processarArquivo() {
        String caminho = txtArquivo.getText().trim();
        boolean deuErro = false;

        if (caminho.isEmpty()) {
            txtResultado.setText("Informe o caminho completo do arquivo HTML.");
            modeloTabela.setRowCount(0);
            return;
        }
    
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            VerificadorDeTag verificador = new VerificadorDeTag();
    
            try {
                verificador.verificarArquivo(reader);
                txtResultado.setText("O arquivo está bem formatado.");
            } catch (Error e) {
                deuErro = true;
                txtResultado.setText(e.getMessage());
            }
    
            modeloTabela.setRowCount(0);
    
            ContadorTags contador = verificador.getContadorTags();
            contador.ordenar();

            if (!deuErro) {
                TagHTML[] lista = contador.getLista();
        
                for (TagHTML tag : lista) {
                    if (tag != null) {
                        modeloTabela.addRow(new Object[]{tag.getTag(), tag.getQtd()});
                    }
                }
            }
    
        } catch (IOException e) {
            txtResultado.setText("Erro ao ler o arquivo: " + e.getMessage());
            modeloTabela.setRowCount(0);
        }
    }        
}
