//package org.example;
//
//import javax.swing.*;
//import javax.swing.plaf.nimbus.State;
//import javax.xml.transform.Result;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class Leer extends Task {
//    Connection con;
//    PreparedStatement ps;
//    Statement st;
//    ResultSet r;
//    DefaultListModel mod = new DefaultListModel();
//    public void leer(){
//        textPanel.setModel(mod);
//        st = con.createStatement();
//        r = st.executeQuery("SELECT Id, Titulo, Descripcion FROM Task");
//        mod.removeAllElements();
//        while (r.next()){
//            mod.addElement(r.getString(1) + "" + r.getString(2) + "" + r.getString(3));
//        }
//
//    }
//}
