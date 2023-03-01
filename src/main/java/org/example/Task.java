package org.example;
import java.sql.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static conexionBBDD.CConnection.Conexion;

public class Task extends JFrame{
    private JButton connectButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton añadirButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTextPane textPane1;
    private JTextField textField3;
    private JPanel mainPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Task() {
        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize (450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    connectButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             Conexion();

        }
    });
}
}
