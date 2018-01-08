/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Vista.VentanaLogin;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
//import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author DelKo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // TODO code application logic here
            /*     UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
            try {
            UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
            } catch (Exception e) {
            e.printStackTrace();
            }*/
            /*     try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            } catch (Exception e) {
            System.out.println("Error de look and field");
            }*/
            try {
                UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                // UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e);
            }
            new ScriptTablas().crearTablas();
            new VentanaLogin().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

}
