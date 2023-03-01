package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static conexionBBDD.CConnection.Conexion;

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
    private JTextField textField3;
    private JPanel mainPanel;
    private JLabel label_status;
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

    readButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)  {
            try {
                Leer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


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
