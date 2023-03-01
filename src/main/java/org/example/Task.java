package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static conexionBBDD.CConnection.Conexion;

public class Task extends JFrame{



    private JButton connectButton;
    private JTextField titleText;
    private JTextField descriptionText;
    private JButton anadirButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTextPane textPane1;
    private JTextField textField3;
    private JPanel mainPanel;
    private JLabel label_status;

    public JPanel getMainPanel() {
        return mainPanel;
    }


public void anadir(){
    try {

        PreparedStatement ps = Conexion().prepareStatement("insert into task values (?, ?, ?)");
        ps.setString(1, "0");
        ps.setString(2, titleText.getText().trim());
        ps.setString(3, descriptionText.getText().trim());
        ps.executeUpdate();

        titleText.setText("");
        descriptionText.setText("");
        label_status.setText("Registro con exito");
    }
    catch(Exception i){
        System.out.println("Error al añadir");
    }

}

    public Task() {
        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize (450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    connectButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)  {



        }
    });


        anadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anadir();
            }
        });
    }
}
