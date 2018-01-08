package Negocio;

import java.sql.*;
import javax.swing.JOptionPane;

public class ScriptTablas {

    Connection conexion = null;
    Statement st = null;
    ResultSet rs = null;

    public void crearTablas() throws SQLException {

        try {
            conexion = Conexion.getConexion();
            st = conexion.createStatement();

            // LA FORMA DE ESCRIBIR ES SQL SERVER
            st.executeUpdate("CREATE TABLE IF NOT EXISTS `familia` ( "
                    + " `fam_id` int(11) NOT NULL AUTO_INCREMENT,"
                    + " `fam_nombre` varchar(45) NOT NULL UNIQUE," // UNIQUE PARA Q NO SE PUEDA DUPLICAR EL REGISTRO             
                    + " `art_estado` int(5),"
                    + " PRIMARY KEY (`fam_id`)"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS `genero` ( "
                    + " `gen_id` int(11) NOT NULL AUTO_INCREMENT,"
                    + " `gen_nombre` varchar(45) NOT NULL,"
                    + " `id_fam` int(11) NOT NULL,"
                    + " `gen_estado` int(5),"
                    + " PRIMARY KEY (`gen_id`),"
                    + " KEY `cf_genero` (`id_fam`), "
                    + " CONSTRAINT `cf_genero` FOREIGN KEY (`id_fam`) REFERENCES `familia` (`fam_id`) ON DELETE CASCADE ON UPDATE CASCADE "
                    + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS `especie` ( "
                    + " `esp_id` int(11) NOT NULL AUTO_INCREMENT, "
                    + " `esp_nombre` varchar(45) NOT NULL, "
                    + " `esp_nom_vul` varchar(45) , "
                    + " `esp_recolector` varchar(45) , "
                    + " `esp_acompanante` varchar(45) , "
                    + " `esp_fecha_recol` varchar(50), "
                    + " `esp_num_colecc` varchar(30) , "
                    + " `esp_pais` varchar(45) , "
                    + " `esp_prov` varchar(45) , "
                    + " `esp_dpto` varchar(45) , "
                    + " `esp_localidad` varchar(45) , "
                    + " `esp_observaciones` varchar(245) , "
                    + " `esp_fec_ingreso` varchar(45) , "
                    + " `esp_deter_por` varchar(45) , "
                    + " `esp_imagen` longblob , "
                    + " `esp_duplicado` int(5) , "
                    + " `esp_detalle_dup` varchar(245) , "
                    + " `esp_id_fam` int(11) , "
                    + " `esp_id_gen` int(11), "
                    + " `esp_estado` int(11) , "
                    + " PRIMARY KEY (`esp_id`), "
                    + " KEY `cf_fam` (`esp_id_fam`), "
                    + " CONSTRAINT `cf_fam` FOREIGN KEY (`esp_id_fam`) REFERENCES `familia` (`fam_id`) ON DELETE CASCADE ON UPDATE CASCADE, "
                    + " KEY `cf_gen` (`esp_id_gen`), "
                    + " CONSTRAINT `cf_gen` FOREIGN KEY (`esp_id_gen`) REFERENCES `genero` (`gen_id`) ON DELETE CASCADE ON UPDATE CASCADE "
                    + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ");

            /*    st.executeUpdate("CREATE TABLE IF NOT EXISTS `art_ven` ( "
                    + " `art_ven_id` int(11) NOT NULL AUTO_INCREMENT, "
                    + " `ven_id` int(11) NOT NULL, "
                    + " `art_id` int(11) NOT NULL, "
                    + " `cant` float(10) NOT NULL, "
                    + " `precio` float(10) NOT NULL, "
                    + " `art_ven_estado` int(5),"
                    + " PRIMARY KEY (`art_ven_id`), "
                    + " KEY `cf_art` (`art_id`), "
                    + " CONSTRAINT `cf_art` FOREIGN KEY (`art_id`) REFERENCES `articulos` (`art_id`) ON DELETE CASCADE ON UPDATE CASCADE, "
                    + " KEY `cf_ven` (`ven_id`), "
                    + " CONSTRAINT `cf_ven` FOREIGN KEY (`ven_id`) REFERENCES `ventas` (`ven_id`) ON DELETE CASCADE ON UPDATE CASCADE "
                    + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ");*/
            st.executeUpdate("CREATE TABLE IF NOT EXISTS `usuario` ( "
                    + " `usu_id` int(11) NOT NULL AUTO_INCREMENT,"
                    + " `usu_nombre` varchar(255) NOT NULL UNIQUE,"
                    + " `usu_contrasenia` varchar(255) NOT NULL,"
                    + " `usu_tipo` int(11) NOT NULL,"
                    + " `usu_estado` int(5),"
                    + " PRIMARY KEY (`usu_id`)"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } finally {
            conexion.close();
            st.close();
        }
    }
}
