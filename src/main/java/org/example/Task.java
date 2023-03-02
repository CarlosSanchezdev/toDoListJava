package org.example;

import Method.Create;
import Method.Delete;
import Method.Read;
import Method.Update;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel label_status;
    private JList textPanel;




    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getIdText() {
        return idText;
    }






    public Task() {

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                Read read = new Read();
                try {
                    read.Read(ps, mod, r, st, idText, titleText, descriptionText, textPanel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        anadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create create = new Create();
                create.Create(ps, titleText, descriptionText, label_status);
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Update update = new Update();
              update.Update(ps, idText, titleText, descriptionText);
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
    }


}
