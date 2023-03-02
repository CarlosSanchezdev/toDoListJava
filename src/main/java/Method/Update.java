package Method;

import javax.swing.*;

import java.sql.PreparedStatement;

import static conexionBBDD.CConnection.Conexion;

public class Update {
    public void Update(PreparedStatement ps, JTextField idText, JTextField titleText, JTextField descriptionText)  {

        try{
            int id = Integer.parseInt(idText.getText());
            String newTitle = titleText.getText().trim();
            String newDescription = descriptionText.getText().trim();

            String query = "update task set titulo = ? , descripcion = ? where id = ?";
             ps = Conexion().prepareStatement(query);


            ps.setString(1, titleText.getText());
            ps.setString(2, descriptionText.getText());
            ps.setInt(3,id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizacion con exito");


        }
        catch(Exception i)
        {
            System.out.println(i);
        }
    }
}
