package Negocio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Especie;

/**
 *
 * @author DelKo
 */
public class GestionEspecie {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("HerbarioPU");

    public void cargarTablaEspecies(JTable tablaEspecies) {
        try {
            new GestionTablas().limparTabla(tablaEspecies, (DefaultTableModel) tablaEspecies.getModel());
            DefaultTableModel dtmEspecie = (DefaultTableModel) tablaEspecies.getModel();
            EntityManager em = emf.createEntityManager();
            Query consulta = em.createNamedQuery("Especie.findByEspEstado");
            consulta.setParameter("espEstado", 1);
            List<Especie> listaEspeciesActivas = consulta.getResultList();
            String datos[] = new String[dtmEspecie.getColumnCount()];
            for (int i = 0; i < listaEspeciesActivas.size(); i++) {
                Especie especie = listaEspeciesActivas.get(i);
                datos[0] = String.valueOf(especie.getEspId());
                datos[1] = especie.getEspIdFam().getFamNombre();
                datos[2] = especie.getEspIdGen().getGenNombre();
                datos[3] = especie.getEspNombre();
                if(especie.getEspNomVul().equals("")){
                    datos[4] = "-";
                }else{
                    datos[4] = especie.getEspNomVul();
                }
                if(String.valueOf(especie.getEspNumColecc()).equals("")){
                    datos[5] = "-";
                }else{
                    datos[5] = String.valueOf(especie.getEspNumColecc());
                }
                dtmEspecie.addRow(datos);
                if (especie.getEspDuplicado() == 1) {
                    dtmEspecie.setValueAt(true, i, 6); // DUPLICADO BOOLEAN
                } else {
                    dtmEspecie.setValueAt(false, i, 6);
                }
            }
        } catch (NullPointerException e) {
            System.err.println("error: " + e);
        }
    }

}
