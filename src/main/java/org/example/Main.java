package org.example;

import java.sql.Connection;

import static conexionBBDD.CConnection.Conexion;

public class Main {
    public static void main(String[] args) {

        Connection conex=null;

    /*Almacenamos lo que nos devuelve el método Conexion()
    en la variable conex*/
        conex = Conexion();

        // Si la variable objeto conex es diferente de nulo
        if(conex != null){
            // Informamos que la conexión es correcta
            System.out.println("Conectado correctamente");
        }else{ // Sino informamos que no nos podemos conectar.
            System.out.println("No has podido conectarte");
        };
    }
}