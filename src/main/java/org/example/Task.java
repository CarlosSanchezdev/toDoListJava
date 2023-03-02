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
    private JTextField idText;
    private JPanel mainPanel;
    private JLabel label_status;
    private JList textPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void Delete(){


        try {
            ps = Conexion().prepareStatement("Delete from task where Id = ? ");
            ps.setString(1, idText.getText().trim());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Eliminado");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de Registro" + e.toString());
        }
    }

    public void Leer() throws SQLException {

    if(!idText.getText().isEmpty()){

        ps = Conexion().prepareStatement("select * from task where id = ? ");

        ps.setString(1, idText.getText().trim());
        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            titleText.setText(rs.getString("titulo"));
            descriptionText.setText(rs.getString("descripcion"));
        }else{

            JOptionPane.showMessageDialog(null, "Tarea no encontrada");
        }

    }

    if(idText.getText().isEmpty()){


        textPanel.setModel(mod);
        st = Conexion().createStatement();
        r = st.executeQuery("SELECT Id, Titulo, Descripcion FROM Task");
        mod.removeAllElements();
        while (r.next()) {
            mod.addElement(r.getString(1) + "" + r.getString(2) + "" + r.getString(3));
        }
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
        JOptionPane.showMessageDialog(null, "Registro con exito");
    }
    catch(Exception i){
        JOptionPane.showMessageDialog(null, "Error al añadir");

    }

}

public void update()  {

    try{
    int id = Integer.parseInt(idText.getText());
    String newTitle = titleText.getText().trim();
    String newDescription = descriptionText.getText().trim();

    String query = "update task set titulo = ? , descripcion = ? where id = ?";
    PreparedStatement ps = Conexion().prepareStatement(query);


    ps.setString(1, titleText.getText());
    ps.setString(2, descriptionText.getText());
        ps.setInt(3,id);
     ps.executeUpdate();
       System.out.println("Actualizacion con exito");

    }
    catch(Exception i)
    {
    System.out.println(i);
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
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              update();            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete();
            }
        });
    }


}
