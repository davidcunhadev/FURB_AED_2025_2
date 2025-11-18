package com.trabalhofinal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnalisadorHTMLUI layout = new AnalisadorHTMLUI();
            layout.setVisible(true);
        });
    }
}
