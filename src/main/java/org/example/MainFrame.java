package org.example;

import Method.Read;

import javax.swing.*;
import java.sql.SQLException;


public class MainFrame extends Task {
    public MainFrame() {

        JPanel mainPanel = getMainPanel();

        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize(1000, 200);
        setVisible(true);
        Inicializar();
    }
}