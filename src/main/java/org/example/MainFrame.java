package org.example;

import javax.swing.*;



public class MainFrame extends Task{



    public MainFrame(){

        JPanel mainPanel = getMainPanel();


        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize (1000, 400);
        setVisible(true);

        Inicializar();


    }


}
