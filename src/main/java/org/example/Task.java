package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static conexionBBDD.CConnection.Conexion;

public class Task extends JFrame{
    PreparedStatement ps;
    Statement st;
    ResultSet r;
    DefaultListModel mod = new DefaultListModel();
    private JButton connectButton;
    private JTextField Titulo;
    private JTextField Descripcion;
    private JButton añadirButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTextField Id;
    private JPanel mainPanel;
    private JList textPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void Leer() throws SQLException {
        textPanel.setModel(mod);
        st = Conexion().createStatement();
        r = st.executeQuery("SELECT Id, Titulo, Descripcion FROM Task");
        mod.removeAllElements();
        while (r.next()){
            mod.addElement(r.getString(1) + "" + r.getString(2) + "" + r.getString(3));
        }

    }

    public Task() {
        this.mainPanel=mainPanel;


        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize (450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    connectButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Leer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    });
}
}
