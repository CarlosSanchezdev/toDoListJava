package org.example;

import Method.Create;
import Method.Delete;
import Method.Read;
import Method.Update;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.sql.*;


public class Task extends JFrame{
    PreparedStatement ps;
    Statement st;
    ResultSet r;
    DefaultListModel mod = new DefaultListModel();


    private JButton readButton;
    private JTextField titleText;
    private JTextField descriptionText;
    private JButton anadirButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTextField idText;
    private JPanel mainPanel;
    private JList textPanel;
    private JButton aceptarButton;


    public JPanel getMainPanel() {

        return mainPanel;

    }

    public void Inicializar(){
        Read read = new Read();
        try {
            read.Read(ps, mod, r, st, idText, titleText, descriptionText, textPanel);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public JTextField getIdText() {
        return idText;
    }


    public Task() {








        anadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create create = new Create();
                create.Create(ps, titleText, descriptionText);
                Read read = new Read();
                try {
                    read.Read(ps, mod, r, st, idText, titleText, descriptionText, textPanel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Update update = new Update();
              update.Update(ps, idText, titleText, descriptionText);
              idText.setText("");
              Read read = new Read();
                try {
                    read.Read(ps, mod, r, st, idText, titleText, descriptionText, textPanel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Read read = new Read();
                Delete delete = new Delete();
                delete.Delete(ps, idText, titleText, descriptionText);
                try {
                    read.Read(ps, mod, r, st, idText, titleText, descriptionText, textPanel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        textPanel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String mensaje =""+textPanel.getSelectedValue();
                System.out.println(mensaje);

                String truncated = String.format("%."+ 2 +"s", mensaje);
                System.out.println(truncated);

                idText.setText(truncated);
                Read read = new Read();
                try {
                    read.Read(ps, mod, r, st, idText, titleText, descriptionText, textPanel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



    }



}
