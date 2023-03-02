package Method;

import org.example.Task;

import javax.swing.*;

import java.sql.PreparedStatement;

import static conexionBBDD.CConnection.Conexion;

public class Delete extends Task {
    public void Delete(PreparedStatement ps, JTextField idText, JTextField titleText, JTextField descriptionText){



        try {
            ps = Conexion().prepareStatement("Delete from task where Id = ? ");
            ps.setString(1, idText.getText().trim());
            ps.executeUpdate();

            titleText.setText("");
            descriptionText.setText("");
            idText.setText("");

            JOptionPane.showMessageDialog(null, "Registro Eliminado");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de Registro" + e.toString());
        }
    }
}
