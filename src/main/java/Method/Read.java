package Method;

import org.example.Task;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static conexionBBDD.CConnection.Conexion;


public class Read extends Task {
    public void Read(PreparedStatement ps, DefaultListModel mod, ResultSet r, Statement st, JTextField idText, JTextField titleText, JTextField descriptionText, JList textPanel) throws SQLException {

        try {
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
                    mod.addElement(r.getString(1) + "  " + r.getString(2) + "  " + r.getString(3));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
