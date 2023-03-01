package org.example;

import javax.swing.*;

import java.sql.SQLException;

import static conexionBBDD.CConnection.Conexion;

public class MainFrame extends Task{
    public MainFrame(){


        setTitle("Welcome");
        setSize (450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
