package Method;

import javax.swing.*;


import java.sql.PreparedStatement;

import static conexionBBDD.CConnection.Conexion;

public class Create {

    public void Create(PreparedStatement ps, JTextField titleText, JTextField descriptionText, JLabel label_status){
        try {
            ps = Conexion().prepareStatement("insert into task values (?, ?, ?)");
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
}
