package conexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CConnection {

        private static final String driver="com.mysql.cj.jdbc.Driver";
        private static final String bbdd="jdbc:mysql://localhost:3306/CRUD";
        private static final String usuario ="root";
        private static final String clave="1234";

        public static Connection Conexion(){

                Connection conex = null;

                try {

                        Class.forName(driver);

                        conex = DriverManager.getConnection(bbdd, usuario, clave);

                        System.out.println("Conectado correctamente.");
                        // Si hay errores informamos al usuario.
                } catch (Exception e) {
                        System.out.println("Error al conectar con la base de datos.\n"
                                + e.getMessage().toString());
                }
                // Devolvemos la conexión.
                return conex;
        }

}
