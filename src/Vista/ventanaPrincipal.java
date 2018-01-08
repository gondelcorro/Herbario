package Vista;

import Negocio.GestionEspecie;
import Negocio.GestionTablas;
import Negocio.GestionUsuarios;
import controladores.EspecieJpaController;
import controladores.FamiliaJpaController;
import controladores.GeneroJpaController;
import controladores.exceptions.NonexistentEntityException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.JXImageView;
import controladores.EstadoJpaController;
import controladores.PaisJpaController;
import controladores.UsuarioJpaController;
import java.io.ByteArrayInputStream;
import javax.persistence.NoResultException;

public class ventanaPrincipal extends javax.swing.JFrame {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("HerbarioPU");
    private String rutaImg = null;
    String usuario;
    int tipoUsuario;

    public ventanaPrincipal(String usuario, int tipoUsuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        jTextFieldBuscarEspecie.requestFocus();
        this.setExtendedState(MAXIMIZED_BOTH);
        inicializarTablas();
        this.usuario = usuario;
        this.tipoUsuario = tipoUsuario;
    }

    private void inicializarTablas() {

        GestionTablas gestionTabla = new GestionTablas();
        gestionTabla.darFormatoTabla(jTableEspecies);
        //PRIMERO LOS TITULOS Y LUEGO EL ANCHO DE CADA COLUMNA
        String titulos1[] = {"ID", "FAMILIA", "GÉNERO", "ESPECIE", "NOM. VULGAR", "NUM. COLECCIÓN", "DUPLICADO"};
        gestionTabla.editarCabeceraTabla(jTableEspecies, (DefaultTableModel) jTableEspecies.getModel(), titulos1);
        int[] ancho1 = {30, 60, 60, 60, 80, 80, 30};
        gestionTabla.fijarAnchoColumnasTabla(jTableEspecies, ancho1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogNuevoRegistro = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jXDatePickerFecIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldDeterminadoPor = new javax.swing.JTextField();
        jCheckBoxDuplicado = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInfoDuplicado = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jXDatePickerFecRecoleccion = new org.jdesktop.swingx.JXDatePicker();
        jTextFieldRecolector = new javax.swing.JTextField();
        jTextFieldAcompañante = new javax.swing.JTextField();
        jTextFieldNumColeccion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxPais = new javax.swing.JComboBox<>();
        jComboBoxProvincia = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldDepartaento = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldLocalidad = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldObveservaciones = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxFamilias = new javax.swing.JComboBox<>();
        jComboBoxGeneros = new javax.swing.JComboBox<>();
        jTextFieldEspecie = new javax.swing.JTextField();
        jTextFieldNomVul = new javax.swing.JTextField();
        jButtonEditarFamilia = new javax.swing.JButton();
        jButtonEditarGenero = new javax.swing.JButton();
        jButtonRegistrarEspecie = new javax.swing.JButton();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXImageView2 = new org.jdesktop.swingx.JXImageView();
        jButtonCargarImagen = new javax.swing.JButton();
        jDialogEditarFamilia = new javax.swing.JDialog();
        jTextFieldEditarFlia = new javax.swing.JTextField();
        jButtonNuevaFlia = new javax.swing.JButton();
        jButtonModificarFlia = new javax.swing.JButton();
        jButtonEliminarFlia = new javax.swing.JButton();
        jDialogEditarGenero = new javax.swing.JDialog();
        jTextFieldEditarGenero = new javax.swing.JTextField();
        jButtonNuevoGenero = new javax.swing.JButton();
        jButtonModificarGenero = new javax.swing.JButton();
        jButtonEliminarGenero = new javax.swing.JButton();
        jDialogBuscarRegistro = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldBuscarEspecie = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEspecies = new javax.swing.JTable();
        jButtonDetalle = new javax.swing.JButton();
        jButtonEtiqueta = new javax.swing.JButton();
        jDialogEditarRegistro = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jXDatePickerFecIngreso1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldDeterminadoPor1 = new javax.swing.JTextField();
        jCheckBoxDuplicado1 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaInfoDuplicado1 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jXDatePickerFecRecoleccion1 = new org.jdesktop.swingx.JXDatePicker();
        jTextFieldRecolector1 = new javax.swing.JTextField();
        jTextFieldAcompañante1 = new javax.swing.JTextField();
        jTextFieldNumColeccion1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldDepartaento1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldLocalidad1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextFieldObveservaciones1 = new javax.swing.JTextField();
        jButtonEditarPaises = new javax.swing.JButton();
        jButtonEditarEstados = new javax.swing.JButton();
        jTextFieldPais1 = new javax.swing.JTextField();
        jTextFieldProvincia1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextFieldEspecie1 = new javax.swing.JTextField();
        jTextFieldNomVul1 = new javax.swing.JTextField();
        jButtonEditarFamilia1 = new javax.swing.JButton();
        jButtonEditarGenero1 = new javax.swing.JButton();
        jTextFieldFamilia1 = new javax.swing.JTextField();
        jTextFieldGenero1 = new javax.swing.JTextField();
        jButtonEditarEspecie = new javax.swing.JButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXImageView3 = new org.jdesktop.swingx.JXImageView();
        jButtonCargarImagen1 = new javax.swing.JButton();
        jButtonEliminarRegistro = new javax.swing.JButton();
        jDialogSelecfamilia = new javax.swing.JDialog();
        jComboBoxSelecFamilia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jDialogSelecGenero = new javax.swing.JDialog();
        jComboBoxSelecGenero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jDialogGenerarEtiqueta = new javax.swing.JDialog();
        jTextFieldEspecieEtiqueta = new javax.swing.JTextField();
        jButtonGenerarEtiqueta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jDialogSelecPais = new javax.swing.JDialog();
        jComboBoxSelecPais = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDialogSelecEstado = new javax.swing.JDialog();
        jComboBoxSelecEstado = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jDialogUsuario = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jComboBoxTipoUsuario = new javax.swing.JComboBox();
        jButtonRegistrarUsuario = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPasswordFieldContraseña = new javax.swing.JPasswordField();
        jButtonEliminarUsuario = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButtonNuevoReg = new javax.swing.JButton();
        jButtonGenerarEtiq = new javax.swing.JButton();
        jButtonBuscarReg = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jDialogNuevoRegistro.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogNuevoRegistro.setTitle("Nuevo Registro");
        jDialogNuevoRegistro.setModal(true);
        jDialogNuevoRegistro.setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos internos Herbario"));

        jXDatePickerFecIngreso.setPreferredSize(new java.awt.Dimension(80, 24));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Fecha ingreso:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Deteriminado por:");

        jTextFieldDeterminadoPor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBoxDuplicado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxDuplicado.setText("Duplicado");
        jCheckBoxDuplicado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDuplicadoActionPerformed(evt);
            }
        });

        jTextAreaInfoDuplicado.setColumns(20);
        jTextAreaInfoDuplicado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextAreaInfoDuplicado.setLineWrap(true);
        jTextAreaInfoDuplicado.setRows(5);
        jTextAreaInfoDuplicado.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaInfoDuplicado);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jCheckBoxDuplicado)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXDatePickerFecIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDeterminadoPor, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jXDatePickerFecIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextFieldDeterminadoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxDuplicado)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Especimen"));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Recolector/es:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Acompañantes:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Fecha de recolección:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Número de colección:");

        jXDatePickerFecRecoleccion.setPreferredSize(new java.awt.Dimension(80, 24));

        jTextFieldRecolector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldAcompañante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNumColeccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNumColeccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumColeccionKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("País:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Provincia:");

        jComboBoxPais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPaisActionPerformed(evt);
            }
        });

        jComboBoxProvincia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Departamento:");

        jTextFieldDepartaento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Localidad:");

        jTextFieldLocalidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Observaciones:");

        jTextFieldObveservaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("dd/mm/aaaa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldObveservaciones)
                    .addComponent(jTextFieldDepartaento, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxProvincia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxPais, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldRecolector, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAcompañante, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNumColeccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldLocalidad)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jXDatePickerFecRecoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldRecolector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldAcompañante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jXDatePickerFecRecoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldNumColeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextFieldDepartaento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jTextFieldObveservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Botánicos"));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("*Familia:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("*Género:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("*Especie:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Nombre vulgar:");

        jComboBoxFamilias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxFamilias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE --" }));
        jComboBoxFamilias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFamiliasActionPerformed(evt);
            }
        });

        jComboBoxGeneros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxGeneros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE --" }));
        jComboBoxGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGenerosActionPerformed(evt);
            }
        });

        jTextFieldEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNomVul.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonEditarFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        jButtonEditarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarFamiliaActionPerformed(evt);
            }
        });

        jButtonEditarGenero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        jButtonEditarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxFamilias, 0, 256, Short.MAX_VALUE)
                            .addComponent(jComboBoxGeneros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditarGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEditarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldEspecie)
                    .addComponent(jTextFieldNomVul, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditarFamilia)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jComboBoxFamilias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditarGenero)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jComboBoxGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldNomVul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButtonRegistrarEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRegistrarEspecie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/accept_1.png"))); // NOI18N
        jButtonRegistrarEspecie.setText("Registrar");
        jButtonRegistrarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarEspecieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImageView2Layout = new javax.swing.GroupLayout(jXImageView2);
        jXImageView2.setLayout(jXImageView2Layout);
        jXImageView2Layout.setHorizontalGroup(
            jXImageView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        jXImageView2Layout.setVerticalGroup(
            jXImageView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jXImageView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jXImageView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jButtonCargarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/image_add.png"))); // NOI18N
        jButtonCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogNuevoRegistroLayout = new javax.swing.GroupLayout(jDialogNuevoRegistro.getContentPane());
        jDialogNuevoRegistro.getContentPane().setLayout(jDialogNuevoRegistroLayout);
        jDialogNuevoRegistroLayout.setHorizontalGroup(
            jDialogNuevoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNuevoRegistroLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jDialogNuevoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jDialogNuevoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogNuevoRegistroLayout.createSequentialGroup()
                        .addGroup(jDialogNuevoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialogNuevoRegistroLayout.createSequentialGroup()
                                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButtonCargarImagen))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogNuevoRegistroLayout.createSequentialGroup()
                        .addComponent(jButtonRegistrarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197))))
        );
        jDialogNuevoRegistroLayout.setVerticalGroup(
            jDialogNuevoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNuevoRegistroLayout.createSequentialGroup()
                .addGroup(jDialogNuevoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogNuevoRegistroLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jDialogNuevoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDialogNuevoRegistroLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButtonCargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jDialogNuevoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogNuevoRegistroLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRegistrarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jDialogEditarFamilia.setTitle("Editar Familia");
        jDialogEditarFamilia.setModal(true);

        jTextFieldEditarFlia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonNuevaFlia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonNuevaFlia.setText("Nuevo");
        jButtonNuevaFlia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaFliaActionPerformed(evt);
            }
        });

        jButtonModificarFlia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonModificarFlia.setText("Modficar");
        jButtonModificarFlia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarFliaActionPerformed(evt);
            }
        });

        jButtonEliminarFlia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEliminarFlia.setText("Eliminar");
        jButtonEliminarFlia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarFliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogEditarFamiliaLayout = new javax.swing.GroupLayout(jDialogEditarFamilia.getContentPane());
        jDialogEditarFamilia.getContentPane().setLayout(jDialogEditarFamiliaLayout);
        jDialogEditarFamiliaLayout.setHorizontalGroup(
            jDialogEditarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarFamiliaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jDialogEditarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEditarFlia, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogEditarFamiliaLayout.createSequentialGroup()
                        .addComponent(jButtonNuevaFlia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonModificarFlia)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonEliminarFlia)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jDialogEditarFamiliaLayout.setVerticalGroup(
            jDialogEditarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarFamiliaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jTextFieldEditarFlia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jDialogEditarFamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevaFlia)
                    .addComponent(jButtonModificarFlia)
                    .addComponent(jButtonEliminarFlia))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jDialogEditarGenero.setTitle("Editar Género");
        jDialogEditarGenero.setModal(true);

        jTextFieldEditarGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonNuevoGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonNuevoGenero.setText("Nuevo");
        jButtonNuevoGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoGeneroActionPerformed(evt);
            }
        });

        jButtonModificarGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonModificarGenero.setText("Modficar");
        jButtonModificarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarGeneroActionPerformed(evt);
            }
        });

        jButtonEliminarGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEliminarGenero.setText("Eliminar");
        jButtonEliminarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogEditarGeneroLayout = new javax.swing.GroupLayout(jDialogEditarGenero.getContentPane());
        jDialogEditarGenero.getContentPane().setLayout(jDialogEditarGeneroLayout);
        jDialogEditarGeneroLayout.setHorizontalGroup(
            jDialogEditarGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarGeneroLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jDialogEditarGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEditarGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogEditarGeneroLayout.createSequentialGroup()
                        .addComponent(jButtonNuevoGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonModificarGenero)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonEliminarGenero)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jDialogEditarGeneroLayout.setVerticalGroup(
            jDialogEditarGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarGeneroLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jTextFieldEditarGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jDialogEditarGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevoGenero)
                    .addComponent(jButtonModificarGenero)
                    .addComponent(jButtonEliminarGenero))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jDialogBuscarRegistro.setTitle("Buscar Registro");
        jDialogBuscarRegistro.setModal(true);
        jDialogBuscarRegistro.setResizable(false);
        jDialogBuscarRegistro.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogBuscarRegistroWindowClosing(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Búsqueda rápida:");

        jTextFieldBuscarEspecie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarEspecieKeyReleased(evt);
            }
        });

        jTableEspecies.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableEspecies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6", "Título 7"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEspecies.setRowHeight(24);
        jScrollPane2.setViewportView(jTableEspecies);

        jButtonDetalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDetalle.setText("Detalle");
        jButtonDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetalleActionPerformed(evt);
            }
        });

        jButtonEtiqueta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEtiqueta.setText("Etiqueta");
        jButtonEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEtiquetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldBuscarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldBuscarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jDialogBuscarRegistroLayout = new javax.swing.GroupLayout(jDialogBuscarRegistro.getContentPane());
        jDialogBuscarRegistro.getContentPane().setLayout(jDialogBuscarRegistroLayout);
        jDialogBuscarRegistroLayout.setHorizontalGroup(
            jDialogBuscarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogBuscarRegistroLayout.setVerticalGroup(
            jDialogBuscarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialogEditarRegistro.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogEditarRegistro.setTitle("Editar Registro");
        jDialogEditarRegistro.setModal(true);
        jDialogEditarRegistro.setResizable(false);
        jDialogEditarRegistro.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogEditarRegistroWindowClosing(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos internos Herbario"));

        jXDatePickerFecIngreso1.setPreferredSize(new java.awt.Dimension(80, 24));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Fecha ingreso:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Deteriminado por:");

        jTextFieldDeterminadoPor1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBoxDuplicado1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxDuplicado1.setText("Duplicado");
        jCheckBoxDuplicado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDuplicado1ActionPerformed(evt);
            }
        });

        jTextAreaInfoDuplicado1.setColumns(20);
        jTextAreaInfoDuplicado1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextAreaInfoDuplicado1.setLineWrap(true);
        jTextAreaInfoDuplicado1.setRows(5);
        jTextAreaInfoDuplicado1.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextAreaInfoDuplicado1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jCheckBoxDuplicado1)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXDatePickerFecIngreso1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDeterminadoPor1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jXDatePickerFecIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTextFieldDeterminadoPor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxDuplicado1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Especimen"));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Recolector/es:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Acompañantes:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Fecha de recolección:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Número de colección:");

        jXDatePickerFecRecoleccion1.setPreferredSize(new java.awt.Dimension(80, 24));

        jTextFieldRecolector1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldAcompañante1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNumColeccion1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNumColeccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumColeccion1KeyTyped(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("País:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Provincia:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Departamento:");

        jTextFieldDepartaento1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Localidad:");

        jTextFieldLocalidad1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Observaciones:");

        jTextFieldObveservaciones1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonEditarPaises.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        jButtonEditarPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPaisesActionPerformed(evt);
            }
        });

        jButtonEditarEstados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        jButtonEditarEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarEstadosActionPerformed(evt);
            }
        });

        jTextFieldPais1.setEditable(false);
        jTextFieldPais1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldProvincia1.setEditable(false);
        jTextFieldProvincia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldProvincia1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(jTextFieldPais1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditarPaises, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButtonEditarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jTextFieldObveservaciones1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldDepartaento1)
                    .addComponent(jTextFieldRecolector1)
                    .addComponent(jXDatePickerFecRecoleccion1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jTextFieldAcompañante1)
                    .addComponent(jTextFieldNumColeccion1)
                    .addComponent(jTextFieldLocalidad1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jTextFieldRecolector1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextFieldAcompañante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jXDatePickerFecRecoleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jTextFieldNumColeccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPais1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)))
                    .addComponent(jButtonEditarPaises))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditarEstados)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldProvincia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTextFieldDepartaento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jTextFieldLocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jTextFieldObveservaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Botánicos"));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Familia:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Género:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Especie:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Nombre vulgar:");

        jTextFieldEspecie1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNomVul1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonEditarFamilia1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        jButtonEditarFamilia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarFamilia1ActionPerformed(evt);
            }
        });

        jButtonEditarGenero1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        jButtonEditarGenero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarGenero1ActionPerformed(evt);
            }
        });

        jTextFieldFamilia1.setEditable(false);
        jTextFieldFamilia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldGenero1.setEditable(false);
        jTextFieldGenero1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFamilia1)
                            .addComponent(jTextFieldGenero1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditarGenero1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEditarFamilia1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNomVul1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(jTextFieldEspecie1))))
                .addGap(34, 34, 34))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextFieldFamilia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldGenero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditarFamilia1)
                            .addComponent(jLabel38))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButtonEditarGenero1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextFieldEspecie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jTextFieldNomVul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButtonEditarEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEditarEspecie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        jButtonEditarEspecie.setText("Editar");
        jButtonEditarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarEspecieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXImageView3Layout = new javax.swing.GroupLayout(jXImageView3);
        jXImageView3.setLayout(jXImageView3Layout);
        jXImageView3Layout.setHorizontalGroup(
            jXImageView3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        jXImageView3Layout.setVerticalGroup(
            jXImageView3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jXImageView3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jXImageView3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jButtonCargarImagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/image_add.png"))); // NOI18N
        jButtonCargarImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarImagen1ActionPerformed(evt);
            }
        });

        jButtonEliminarRegistro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEliminarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        jButtonEliminarRegistro.setText("Eliminar");
        jButtonEliminarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogEditarRegistroLayout = new javax.swing.GroupLayout(jDialogEditarRegistro.getContentPane());
        jDialogEditarRegistro.getContentPane().setLayout(jDialogEditarRegistroLayout);
        jDialogEditarRegistroLayout.setHorizontalGroup(
            jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarRegistroLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarRegistroLayout.createSequentialGroup()
                        .addGroup(jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialogEditarRegistroLayout.createSequentialGroup()
                                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButtonCargarImagen1))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogEditarRegistroLayout.createSequentialGroup()
                        .addComponent(jButtonEditarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonEliminarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))))
        );
        jDialogEditarRegistroLayout.setVerticalGroup(
            jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarRegistroLayout.createSequentialGroup()
                .addGroup(jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogEditarRegistroLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDialogEditarRegistroLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButtonCargarImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogEditarRegistroLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jDialogEditarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEditarEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jButtonEliminarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jDialogSelecfamilia.setTitle("Familias");
        jDialogSelecfamilia.setModal(true);

        jComboBoxSelecFamilia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxSelecFamilia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE --" }));
        jComboBoxSelecFamilia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSelecFamiliaItemStateChanged(evt);
            }
        });
        jComboBoxSelecFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecFamiliaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Seleccione una familia:");

        javax.swing.GroupLayout jDialogSelecfamiliaLayout = new javax.swing.GroupLayout(jDialogSelecfamilia.getContentPane());
        jDialogSelecfamilia.getContentPane().setLayout(jDialogSelecfamiliaLayout);
        jDialogSelecfamiliaLayout.setHorizontalGroup(
            jDialogSelecfamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSelecfamiliaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jDialogSelecfamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxSelecFamilia, 0, 307, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jDialogSelecfamiliaLayout.setVerticalGroup(
            jDialogSelecfamiliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSelecfamiliaLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSelecFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jDialogSelecGenero.setTitle("Géneros");
        jDialogSelecGenero.setModal(true);

        jComboBoxSelecGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxSelecGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE --" }));
        jComboBoxSelecGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSelecGeneroItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Seleccione un género:");

        javax.swing.GroupLayout jDialogSelecGeneroLayout = new javax.swing.GroupLayout(jDialogSelecGenero.getContentPane());
        jDialogSelecGenero.getContentPane().setLayout(jDialogSelecGeneroLayout);
        jDialogSelecGeneroLayout.setHorizontalGroup(
            jDialogSelecGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSelecGeneroLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jDialogSelecGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxSelecGenero, 0, 307, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jDialogSelecGeneroLayout.setVerticalGroup(
            jDialogSelecGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSelecGeneroLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSelecGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jDialogGenerarEtiqueta.setTitle("Generar etiqueta");
        jDialogGenerarEtiqueta.setModal(true);

        jTextFieldEspecieEtiqueta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldEspecieEtiqueta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEspecieEtiquetaKeyReleased(evt);
            }
        });

        jButtonGenerarEtiqueta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonGenerarEtiqueta.setText("Generar");
        jButtonGenerarEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarEtiquetaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Ingrese el ID de una especie:");

        javax.swing.GroupLayout jDialogGenerarEtiquetaLayout = new javax.swing.GroupLayout(jDialogGenerarEtiqueta.getContentPane());
        jDialogGenerarEtiqueta.getContentPane().setLayout(jDialogGenerarEtiquetaLayout);
        jDialogGenerarEtiquetaLayout.setHorizontalGroup(
            jDialogGenerarEtiquetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogGenerarEtiquetaLayout.createSequentialGroup()
                .addGroup(jDialogGenerarEtiquetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogGenerarEtiquetaLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jDialogGenerarEtiquetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldEspecieEtiqueta)))
                    .addGroup(jDialogGenerarEtiquetaLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButtonGenerarEtiqueta)))
                .addGap(34, 34, 34))
        );
        jDialogGenerarEtiquetaLayout.setVerticalGroup(
            jDialogGenerarEtiquetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogGenerarEtiquetaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEspecieEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGenerarEtiqueta)
                .addContainerGap())
        );

        jDialogSelecPais.setTitle("Paises");
        jDialogSelecPais.setModal(true);

        jComboBoxSelecPais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxSelecPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE --" }));
        jComboBoxSelecPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSelecPaisItemStateChanged(evt);
            }
        });
        jComboBoxSelecPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecPaisActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Seleccione un país:");

        javax.swing.GroupLayout jDialogSelecPaisLayout = new javax.swing.GroupLayout(jDialogSelecPais.getContentPane());
        jDialogSelecPais.getContentPane().setLayout(jDialogSelecPaisLayout);
        jDialogSelecPaisLayout.setHorizontalGroup(
            jDialogSelecPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSelecPaisLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jDialogSelecPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxSelecPais, 0, 307, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jDialogSelecPaisLayout.setVerticalGroup(
            jDialogSelecPaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSelecPaisLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSelecPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jDialogSelecEstado.setTitle("Estados");
        jDialogSelecEstado.setModal(true);

        jComboBoxSelecEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxSelecEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE --" }));
        jComboBoxSelecEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSelecEstadoItemStateChanged(evt);
            }
        });
        jComboBoxSelecEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecEstadoActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Seleccione una provincia o estado:");

        javax.swing.GroupLayout jDialogSelecEstadoLayout = new javax.swing.GroupLayout(jDialogSelecEstado.getContentPane());
        jDialogSelecEstado.getContentPane().setLayout(jDialogSelecEstadoLayout);
        jDialogSelecEstadoLayout.setHorizontalGroup(
            jDialogSelecEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSelecEstadoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jDialogSelecEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxSelecEstado, 0, 307, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jDialogSelecEstadoLayout.setVerticalGroup(
            jDialogSelecEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSelecEstadoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSelecEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jPanel13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel13FocusGained(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nº", "USUARIO", "TIPO"
            }
        ));
        jScrollPane5.setViewportView(jTableUsuarios);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("USUARIO:");

        jTextFieldUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("CONTRASEÑA:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("TIPO DE USUARIO:");

        jComboBoxTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- SELECCIONE --", "Administrador", "Personal" }));

        jButtonRegistrarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRegistrarUsuario.setText("Registrar");
        jButtonRegistrarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistrarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarUsuarioActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setText("Cancelar");
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPasswordFieldContraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButtonRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel44)
                        .addComponent(jLabel43)
                        .addComponent(jLabel45)
                        .addComponent(jTextFieldUsuario)
                        .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jButtonRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jButtonEliminarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEliminarUsuario.setText("Eliminar");
        jButtonEliminarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButtonEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );

        javax.swing.GroupLayout jDialogUsuarioLayout = new javax.swing.GroupLayout(jDialogUsuario.getContentPane());
        jDialogUsuario.getContentPane().setLayout(jDialogUsuarioLayout);
        jDialogUsuarioLayout.setHorizontalGroup(
            jDialogUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogUsuarioLayout.setVerticalGroup(
            jDialogUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Control del Herbario Jardín Botánico");
        setMinimumSize(new java.awt.Dimension(1360, 768));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(0, 153, 0));

        jLabel10.setBackground(new java.awt.Color(0, 102, 51));
        jLabel10.setFont(new java.awt.Font("Mangal", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Panel de Gestión");
        jLabel10.setOpaque(true);

        jButtonNuevoReg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonNuevoReg.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNuevoReg.setText("Nuevo registro");
        jButtonNuevoReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoRegActionPerformed(evt);
            }
        });

        jButtonGenerarEtiq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonGenerarEtiq.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGenerarEtiq.setText("Generar etiqueta");
        jButtonGenerarEtiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarEtiqActionPerformed(evt);
            }
        });

        jButtonBuscarReg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBuscarReg.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscarReg.setText("Buscar registro");
        jButtonBuscarReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarRegActionPerformed(evt);
            }
        });

        jButtonUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios.setText("Usuarios");
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
            .addComponent(jButtonNuevoReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonGenerarEtiq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonBuscarReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonNuevoReg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarReg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGenerarEtiq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
        );

        jLabel16.setBackground(new java.awt.Color(0, 153, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setOpaque(true);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo-fcf-unse - copia (2).png"))); // NOI18N

        jLabel18.setBackground(new java.awt.Color(0, 153, 0));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Control del Herbario Jardín Botánico @ Todos los derechos reservados");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 153, 51));
        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("    Herbario Jardín Botánico");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel2.setOpaque(true);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Cerrar sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem3.setText("Acerca de");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        new VentanaLogin().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonNuevoRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoRegActionPerformed
        limpiarCampos();
        cargarListaFamilias();
        cargarListaPaises();
        abrirDialogo(jDialogNuevoRegistro);
    }//GEN-LAST:event_jButtonNuevoRegActionPerformed

    private void jButtonGenerarEtiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarEtiqActionPerformed
        jTextFieldEspecieEtiqueta.setText("");
        jDialogGenerarEtiqueta.setSize(400, 200);
        jDialogGenerarEtiqueta.setLocationRelativeTo(null);
        jDialogGenerarEtiqueta.setVisible(true);
    }//GEN-LAST:event_jButtonGenerarEtiqActionPerformed

    private void jButtonBuscarRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarRegActionPerformed
        jTextFieldBuscarEspecie.setText("");
        busquedaRapida(jTextFieldBuscarEspecie, jTableEspecies);
        new GestionEspecie().cargarTablaEspecies(jTableEspecies);
        abrirDialogo(jDialogBuscarRegistro);
    }//GEN-LAST:event_jButtonBuscarRegActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        new GestionUsuarios().cargarTablaUsuarios(jTableUsuarios);
        jDialogUsuario.setSize(800, 600);
        jDialogUsuario.setLocationRelativeTo(null);
        jDialogUsuario.setVisible(true);
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jCheckBoxDuplicadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDuplicadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxDuplicadoActionPerformed

    private void jButtonCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarImagenActionPerformed
        JFileChooser file = new JFileChooser("C:\\");
        file.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "png", "jpg", "jpeg"));
        int r = file.showDialog(this, "Abrir");
        if (r == JFileChooser.APPROVE_OPTION) {
            File miArchivo = file.getSelectedFile();
            rutaImg = miArchivo.getAbsolutePath();
            setImageinImagePanel(miArchivo, jXImageView2);
        }
    }//GEN-LAST:event_jButtonCargarImagenActionPerformed

    private void jButtonEditarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarFamiliaActionPerformed
        if (jComboBoxFamilias.getSelectedIndex() == 0) {
            jDialogEditarFamilia.setTitle("Nueva Familia");
            jButtonModificarFlia.setEnabled(false);
            jButtonEliminarFlia.setEnabled(false);
            jButtonNuevaFlia.setEnabled(true);
            jTextFieldEditarFlia.setText("");
            jDialogEditarFamilia.setSize(400, 200);
            jDialogEditarFamilia.setLocationRelativeTo(null);
            jDialogEditarFamilia.setVisible(true);
        } else {
            jDialogEditarFamilia.setTitle("Editar Familia");
            jButtonModificarFlia.setEnabled(true);
            jButtonEliminarFlia.setEnabled(true);
            jButtonNuevaFlia.setEnabled(false);
            jTextFieldEditarFlia.setText(jComboBoxFamilias.getSelectedItem().toString());
            jDialogEditarFamilia.setSize(400, 200);
            jDialogEditarFamilia.setLocationRelativeTo(null);
            jDialogEditarFamilia.setVisible(true);
        }
    }//GEN-LAST:event_jButtonEditarFamiliaActionPerformed

    private void jButtonEditarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarGeneroActionPerformed
        if (jComboBoxFamilias.getSelectedIndex() != 0) {

            if (jComboBoxGeneros.getSelectedIndex() == 0) {
                jDialogEditarGenero.setTitle("Nuevo Género");
                jButtonModificarGenero.setEnabled(false);
                jButtonEliminarGenero.setEnabled(false);
                jButtonNuevoGenero.setEnabled(true);
                jTextFieldEditarGenero.setText("");
                jDialogEditarGenero.setSize(400, 200);
                jDialogEditarGenero.setLocationRelativeTo(null);
                jDialogEditarGenero.setVisible(true);
            } else {
                jDialogEditarGenero.setTitle("Editar Género");
                jButtonModificarGenero.setEnabled(true);
                jButtonEliminarGenero.setEnabled(true);
                jButtonNuevoGenero.setEnabled(false);
                jTextFieldEditarGenero.setText(jComboBoxGeneros.getSelectedItem().toString());
                jDialogEditarGenero.setSize(400, 200);
                jDialogEditarGenero.setLocationRelativeTo(null);
                jDialogEditarGenero.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FAMILIA", "ATENCIÓN", 1);
        }
    }//GEN-LAST:event_jButtonEditarGeneroActionPerformed

    private void jComboBoxGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGenerosActionPerformed

    }//GEN-LAST:event_jComboBoxGenerosActionPerformed

    private void jComboBoxFamiliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFamiliasActionPerformed
        if (jComboBoxFamilias.getSelectedIndex() > 0) {
            cargarListaGeneros(jComboBoxFamilias.getSelectedItem().toString());
        } else {
            jComboBoxGeneros.removeAllItems();
            jComboBoxGeneros.addItem("-- SELECCIONE --");
            jComboBoxGeneros.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jComboBoxFamiliasActionPerformed

    private void jButtonRegistrarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarEspecieActionPerformed
        Boolean ok = validarCampos();
        Boolean regExitoso = false;
        if (ok) {
            try {
                regExitoso = registrarEspecie();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (regExitoso) {
                int opcion = JOptionPane.showConfirmDialog(null, "DESEA IMPRIMIR LA ETIQUETA?", "CONFIRMACION", 1);
                if (opcion == 0) {
                    jDialogNuevoRegistro.dispose();
                    EntityManager em = emf.createEntityManager();
                    //SELECCIONA EL ULTIMO REGISTRO DE ESPECIE Q ES EL AGREGADO RECIEN
                    Query consulta = em.createQuery("SELECT max(e.espId) FROM Especie e");
                    int idUltimaEsp = Integer.parseInt(String.valueOf(consulta.getSingleResult()));
                    EspecieJpaController espControlador = new EspecieJpaController(emf);
                    Especie especie = espControlador.findEspecie(idUltimaEsp);
                    generarEtiqueta(especie.getEspId());
                }
            }
        }
    }//GEN-LAST:event_jButtonRegistrarEspecieActionPerformed

    private void jTextFieldBuscarEspecieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarEspecieKeyReleased
        busquedaRapida(jTextFieldBuscarEspecie, jTableEspecies);
    }//GEN-LAST:event_jTextFieldBuscarEspecieKeyReleased

    private void jTextFieldNumColeccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumColeccionKeyTyped
        permitirSoloNum(evt);
    }//GEN-LAST:event_jTextFieldNumColeccionKeyTyped

    private void jButtonNuevaFliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaFliaActionPerformed
        FamiliaJpaController famControlador = new FamiliaJpaController(emf);
        Familia familia = new Familia();
        familia.setFamNombre(jTextFieldEditarFlia.getText());
        familia.setArtEstado(1);
        famControlador.create(familia);
        jDialogEditarFamilia.dispose();
        cargarListaFamilias();
    }//GEN-LAST:event_jButtonNuevaFliaActionPerformed

    private void jButtonNuevoGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoGeneroActionPerformed
        GeneroJpaController genControlador = new GeneroJpaController(emf);
        Genero genero = new Genero();
        genero.setGenNombre(jTextFieldEditarGenero.getText());
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Familia.findByFamNombre");
        consulta.setParameter("famNombre", jComboBoxFamilias.getSelectedItem().toString());
        Familia familia = (Familia) consulta.getSingleResult();
        genero.setIdFam(familia);
        genero.setGenEstado(1);
        genControlador.create(genero);
        jDialogEditarGenero.dispose();
        cargarListaFamilias();
        jComboBoxGeneros.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonNuevoGeneroActionPerformed

    private void jButtonModificarFliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarFliaActionPerformed
        FamiliaJpaController famControlador = new FamiliaJpaController(emf);
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Familia.findByFamNombre");
        consulta.setParameter("famNombre", jComboBoxFamilias.getSelectedItem().toString());
        Familia familia = (Familia) consulta.getSingleResult();
        familia.setFamNombre(jTextFieldEditarFlia.getText());
        familia.setArtEstado(1);
        try {
            famControlador.edit(familia);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDialogEditarFamilia.dispose();
        cargarListaFamilias();
    }//GEN-LAST:event_jButtonModificarFliaActionPerformed

    private void jButtonModificarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarGeneroActionPerformed
        GeneroJpaController genControlador = new GeneroJpaController(emf);
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Genero.findByGenNombre");
        consulta.setParameter("genNombre", jComboBoxGeneros.getSelectedItem().toString());
        Genero genero = (Genero) consulta.getSingleResult();
        consulta = em.createNamedQuery("Familia.findByFamNombre");
        consulta.setParameter("famNombre", jComboBoxFamilias.getSelectedItem().toString());
        Familia familia = (Familia) consulta.getSingleResult();
        genero.setGenNombre(jTextFieldEditarGenero.getText());
        genero.setIdFam(familia);
        genero.setGenEstado(1);
        try {
            genControlador.edit(genero);
        } catch (Exception ex) {
            Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDialogEditarGenero.dispose();
        cargarListaFamilias();
        jComboBoxGeneros.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonModificarGeneroActionPerformed

    private void jCheckBoxDuplicado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDuplicado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxDuplicado1ActionPerformed

    private void jTextFieldNumColeccion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumColeccion1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumColeccion1KeyTyped

    private void jButtonEditarFamilia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarFamilia1ActionPerformed
        jComboBoxSelecFamilia.removeAllItems();
        jComboBoxSelecFamilia.addItem("-- SELECCIONE --");
        FamiliaJpaController famControlador = new FamiliaJpaController(emf);
        List<Familia> listaFamilias = famControlador.findFamiliaEntities();
        for (int i = 0; i < listaFamilias.size(); i++) {
            Familia fam = listaFamilias.get(i);
            jComboBoxSelecFamilia.addItem(fam.getFamNombre());
        }
        jDialogSelecfamilia.setSize(400, 180);
        jDialogSelecfamilia.setLocationRelativeTo(null);
        jDialogSelecfamilia.setVisible(true);
    }//GEN-LAST:event_jButtonEditarFamilia1ActionPerformed

    private void jButtonEditarGenero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarGenero1ActionPerformed
        jComboBoxSelecGenero.removeAllItems();
        jComboBoxSelecGenero.addItem("-- SELECCIONE --");
        GeneroJpaController genControlador = new GeneroJpaController(emf);
        List<Genero> listaGeneros = genControlador.findGeneroEntities();
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Familia.findByFamNombre");
        consulta.setParameter("famNombre", jTextFieldFamilia1.getText());
        Familia flia = null;
        try {
            flia = (Familia) consulta.getSingleResult();
            for (int i = 0; i < listaGeneros.size(); i++) {
                if (listaGeneros.get(i).getIdFam().getFamId() == flia.getFamId()) {
                    Genero gen = listaGeneros.get(i);
                    jComboBoxSelecGenero.addItem(gen.getGenNombre());
                }
            }
        } catch (NonUniqueResultException e) {
            System.out.println("LA CONSULTA DEVOLVIO MAS DE UN RESULTADO");
        } catch (NullPointerException e) {
            System.out.println("LA CONSULTA NO DEVOLVIO NINGUN RESULTADO");
        }
        jDialogSelecGenero.setSize(400, 180);
        jDialogSelecGenero.setLocationRelativeTo(null);
        jDialogSelecGenero.setVisible(true);
    }//GEN-LAST:event_jButtonEditarGenero1ActionPerformed

    private void jButtonEditarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarEspecieActionPerformed

        int filaVista = jTableEspecies.getSelectedRow();
        int filaSeleccionada = jTableEspecies.convertRowIndexToModel(filaVista);
        if (filaSeleccionada != -1) {
            int idEsp = Integer.parseInt(String.valueOf(jTableEspecies.getModel().getValueAt(filaSeleccionada, 0)));
            EntityManager em = emf.createEntityManager();
            Query consulta = em.createNamedQuery("Especie.findByEspId");
            consulta.setParameter("espId", idEsp);
            Especie especie = (Especie) consulta.getSingleResult();
            EspecieJpaController especieJpaController = new EspecieJpaController(emf);
            try {
                recuperarDatosEspecie(especie);
                especieJpaController.edit(especie);
                JOptionPane.showMessageDialog(null, "Edicion exitosa");
                limpiarCampos();
                jDialogEditarRegistro.dispose();
                jTextFieldBuscarEspecie.setText("");
                busquedaRapida(jTextFieldBuscarEspecie, jTableEspecies);
                new GestionEspecie().cargarTablaEspecies(jTableEspecies);
                jTableEspecies.clearSelection();
                jTextFieldBuscarEspecie.requestFocus();
                abrirDialogo(jDialogBuscarRegistro);
            } catch (Exception ex) {
                Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonEditarEspecieActionPerformed

    private void jButtonCargarImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarImagen1ActionPerformed
        JFileChooser file = new JFileChooser("C:\\");
        file.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "png", "jpg", "jpeg"));
        int r = file.showDialog(this, "Abrir");
        if (r == JFileChooser.APPROVE_OPTION) {
            File miArchivo = file.getSelectedFile();
            rutaImg = miArchivo.getAbsolutePath();
            setImageinImagePanel(miArchivo, jXImageView3);
        }
    }//GEN-LAST:event_jButtonCargarImagen1ActionPerformed

    private void jButtonDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetalleActionPerformed
        try {
            int filaVista = jTableEspecies.getSelectedRow();
            int filaSeleccionada = jTableEspecies.convertRowIndexToModel(filaVista);
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "ATENCION", 1);
            } else {
                int idEsp = Integer.parseInt(String.valueOf(jTableEspecies.getModel().getValueAt(filaSeleccionada, 0)));
                EntityManager em = emf.createEntityManager();
                Query consulta = em.createNamedQuery("Especie.findByEspId");
                consulta.setParameter("espId", idEsp);
                try {
                    Especie especie = (Especie) consulta.getSingleResult();
                    recuperarImagen(especie);
                    setearCamposEspecie(especie);
                    jDialogBuscarRegistro.dispose();
                    abrirDialogo(jDialogEditarRegistro);
                } catch (Exception e) {
                    // ESTA EXCEPCION SALTA CUANDO SE REGISTRO UNA ESPECIE SIN IMAGEN
                    Especie especie = (Especie) consulta.getSingleResult();
                    setearCamposEspecie(especie);
                    jDialogBuscarRegistro.dispose();
                    abrirDialogo(jDialogEditarRegistro);
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "ATENCION", 1);
        }
    }//GEN-LAST:event_jButtonDetalleActionPerformed

    private void jComboBoxSelecFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecFamiliaActionPerformed
        //  
    }//GEN-LAST:event_jComboBoxSelecFamiliaActionPerformed

    private void jComboBoxSelecFamiliaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSelecFamiliaItemStateChanged
        if (jComboBoxSelecFamilia.getSelectedIndex() != 0) {
            try {
                jTextFieldFamilia1.setText(jComboBoxSelecFamilia.getSelectedItem().toString());
            } catch (NullPointerException e) {
                System.out.println("ERROR: " + e);
            }
        }
    }//GEN-LAST:event_jComboBoxSelecFamiliaItemStateChanged

    private void jComboBoxPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPaisActionPerformed
        if (jComboBoxPais.getSelectedIndex() > 0) {
            cargarListaEstados(jComboBoxPais.getSelectedItem().toString());
        } else {
            jComboBoxProvincia.removeAllItems();
            jComboBoxProvincia.addItem("-- SELECCIONE --");
            jComboBoxProvincia.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jComboBoxPaisActionPerformed

    private void jButtonEliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarRegistroActionPerformed
        int filaVista = jTableEspecies.getSelectedRow();
        int filaSeleccionada = jTableEspecies.convertRowIndexToModel(filaVista);
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "ATENCION", 1);
        } else {
            try {
                EntityManager em = emf.createEntityManager();
                Query consulta = em.createNamedQuery("Especie.findByEspId");
                int idEsp = Integer.parseInt(String.valueOf(jTableEspecies.getModel().getValueAt(filaSeleccionada, 0)));
                consulta.setParameter("espId", idEsp);
                Especie especie = (Especie) consulta.getSingleResult();
                EspecieJpaController espControlador = new EspecieJpaController(emf);
                espControlador.destroy(especie.getEspId());
                JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                jDialogEditarRegistro.dispose();
                new GestionEspecie().cargarTablaEspecies(jTableEspecies);
                abrirDialogo(jDialogBuscarRegistro);
                jTextFieldBuscarEspecie.requestFocus();
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex);
            }
        }
    }//GEN-LAST:event_jButtonEliminarRegistroActionPerformed

    private void jButtonGenerarEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarEtiquetaActionPerformed

        if (jTextFieldEspecieEtiqueta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el ID de una especie");
            jTextFieldEspecieEtiqueta.requestFocus();
        } else {
            int idEsp = Integer.parseInt(jTextFieldEspecieEtiqueta.getText());
            try {
                EspecieJpaController espController = new EspecieJpaController(emf);
                int espId = espController.findEspecie(idEsp).getEspId();
                jDialogGenerarEtiqueta.dispose();
                generarEtiqueta(espId);

            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "La especie con el ID " + idEsp + " no está registrada");
            }
        }
    }//GEN-LAST:event_jButtonGenerarEtiquetaActionPerformed

    private void jButtonEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEtiquetaActionPerformed
        try {
            int filaVista = jTableEspecies.getSelectedRow();
            int filaSeleccionada = jTableEspecies.convertRowIndexToModel(filaVista);
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "ATENCION", 1);
            } else {
                int idEsp = Integer.parseInt(String.valueOf(jTableEspecies.getModel().getValueAt(filaSeleccionada, 0)));
                jDialogBuscarRegistro.dispose();
                generarEtiqueta(idEsp);
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "ATENCION", 1);
        }
    }//GEN-LAST:event_jButtonEtiquetaActionPerformed

    private void jDialogEditarRegistroWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogEditarRegistroWindowClosing
        jTextFieldBuscarEspecie.setText("");
        busquedaRapida(jTextFieldBuscarEspecie, jTableEspecies);
        jDialogEditarRegistro.dispose();
        jTableEspecies.clearSelection();
        abrirDialogo(jDialogBuscarRegistro);
    }//GEN-LAST:event_jDialogEditarRegistroWindowClosing

    private void jButtonEditarPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPaisesActionPerformed
        jComboBoxSelecPais.removeAllItems();
        jComboBoxSelecPais.addItem("-- SELECCIONE --");
        PaisJpaController paisJpaController = new PaisJpaController(emf);
        List<Pais> listaPaieses = paisJpaController.findPaisEntities();
        for (int i = 0; i < listaPaieses.size(); i++) {
            Pais pais = listaPaieses.get(i);
            jComboBoxSelecPais.addItem(pais.getPaisnombre());
        }
        jDialogSelecPais.setSize(400, 180);
        jDialogSelecPais.setLocationRelativeTo(null);
        jDialogSelecPais.setVisible(true);
    }//GEN-LAST:event_jButtonEditarPaisesActionPerformed

    private void jButtonEditarEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarEstadosActionPerformed
        jComboBoxSelecEstado.removeAllItems();
        jComboBoxSelecEstado.addItem("-- SELECCIONE --");
        EstadoJpaController estadoControlador = new EstadoJpaController(emf);
        List<Estado> listaEstados = estadoControlador.findEstadoEntities();
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Pais.findByPaisnombre");
        consulta.setParameter("paisnombre", jTextFieldPais1.getText());
        Pais pais = null;
        try {
            pais = (Pais) consulta.getSingleResult();
            for (int i = 0; i < listaEstados.size(); i++) {
                if (listaEstados.get(i).getUbicacionpaisid() == pais.getId()) {
                    Estado estado = listaEstados.get(i);
                    jComboBoxSelecEstado.addItem(estado.getEstadonombre());
                }
            }
        } catch (NonUniqueResultException e) {
            System.out.println("LA CONSULTA DEVOLVIO MAS DE UN RESULTADO");
        } catch (NullPointerException e) {
            System.out.println("LA CONSULTA NO DEVOLVIO NINGUN RESULTADO");
        }
        jDialogSelecEstado.setSize(400, 180);
        jDialogSelecEstado.setLocationRelativeTo(null);
        jDialogSelecEstado.setVisible(true);
    }//GEN-LAST:event_jButtonEditarEstadosActionPerformed

    private void jComboBoxSelecPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSelecPaisItemStateChanged
        if (jComboBoxSelecPais.getSelectedIndex() != 0) {
            try {
                jTextFieldPais1.setText(jComboBoxSelecPais.getSelectedItem().toString());
            } catch (NullPointerException e) {
            }
        }
    }//GEN-LAST:event_jComboBoxSelecPaisItemStateChanged

    private void jComboBoxSelecPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSelecPaisActionPerformed

    private void jComboBoxSelecEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSelecEstadoItemStateChanged
        if (jComboBoxSelecEstado.getSelectedIndex() != 0) {
            try {
                jTextFieldProvincia1.setText(jComboBoxSelecEstado.getSelectedItem().toString());
            } catch (NullPointerException e) {
                System.out.println("ERROR: " + e);
            }
        }
    }//GEN-LAST:event_jComboBoxSelecEstadoItemStateChanged

    private void jComboBoxSelecEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSelecEstadoActionPerformed

    private void jComboBoxSelecGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSelecGeneroItemStateChanged
        if (jComboBoxSelecGenero.getSelectedIndex() != 0) {
            try {
                jTextFieldGenero1.setText(jComboBoxSelecGenero.getSelectedItem().toString());
            } catch (NullPointerException e) {
                System.out.println("ERROR: " + e);
            }
        }
    }//GEN-LAST:event_jComboBoxSelecGeneroItemStateChanged

    private void jButtonRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarUsuarioActionPerformed
        String contrasenia = JOptionPane.showInputDialog(null, "INGRESE SU CONTRASEÑA");
        try {
            EntityManager em = emf.createEntityManager();
            Query consulta = em.createNamedQuery("Usuario.findByUsuNombre");
            consulta.setParameter("usuNombre", usuario);
            Usuario usu = (Usuario) consulta.getSingleResult(); // OBTENGO EL USU LOGEADO
            if (contrasenia.equals(usu.getUsuContrasenia())) { // SI LAS CONTRASEÑAS SON IGUALES
                Usuario usuario = new Usuario();
                usuario.setUsuNombre(jTextFieldUsuario.getText());
                usuario.setUsuContrasenia(jPasswordFieldContraseña.getText()); // PARA QUE GUARDE EL TEXTO Q PONE EL USUARIO Y NO EL CIFRADO
                usuario.setUsuTipo(jComboBoxTipoUsuario.getSelectedIndex());
                UsuarioJpaController usuarioControlador = new UsuarioJpaController(emf);
                usuarioControlador.create(usuario);
                new GestionUsuarios().cargarTablaUsuarios(jTableUsuarios);
            } else {
                JOptionPane.showMessageDialog(null, "CONTRESEÑA INCORRECTA", "ATENCION", 1);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }//GEN-LAST:event_jButtonRegistrarUsuarioActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jTextFieldUsuario.setText("");
        jPasswordFieldContraseña.setText("");
        jComboBoxTipoUsuario.setSelectedIndex(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButtonEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarUsuarioActionPerformed
        int filaVista = jTableUsuarios.getSelectedRow();
        int filaSeleccionada = jTableUsuarios.convertRowIndexToModel(filaVista);
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN USUARIO", "ATENCION", 1);
        } else {
            String contrasenia = JOptionPane.showInputDialog(null, "INGRESE SU CONTRASEÑA");
            UsuarioJpaController usuControlador = new UsuarioJpaController(emf);
            try {
                EntityManager em = emf.createEntityManager();
                Query consulta = em.createNamedQuery("Usuario.findByUsuNombre");
                consulta.setParameter("usuNombre", usuario);
                Usuario usu = (Usuario) consulta.getSingleResult(); // OBTENGO EL USU LOGEADO
                if (contrasenia.equals(usu.getUsuContrasenia())) { // SI LAS CONTRASEÑAS SON IGUALES
                    int idUsuario = Integer.parseInt(String.valueOf(jTableUsuarios.getModel().getValueAt(filaSeleccionada, 0))); // TOMO EL ID DEL USUARIO QUE QUIERO ELIMIMNAR
                    consulta = em.createNamedQuery("Usuario.findByUsuId");
                    consulta.setParameter("usuId", idUsuario);
                    Usuario usu1 = (Usuario) consulta.getSingleResult();
                    if (usu.getUsuNombre().equals(usu1.getUsuNombre())) { // SI LOS USUARIOS SON IGUALES
                        JOptionPane.showMessageDialog(null, "EL USUARIO QUE INTENTA ELIMINAR ESTA LOGEADO. CIERRE SESION E INTENTE INGRESAR CON OTRO USUARIO ADMINISTRADOR", "ATENCION", 1);
                    } else {
                        usuControlador.destroy(idUsuario);
                        new GestionUsuarios().cargarTablaUsuarios(jTableUsuarios);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CONTRESEÑA INCORRECTA", "ATENCION", 1);
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
            }
        }
    }//GEN-LAST:event_jButtonEliminarUsuarioActionPerformed

    private void jPanel13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel13FocusGained
        new GestionUsuarios().cargarTablaUsuarios(jTableUsuarios);
    }//GEN-LAST:event_jPanel13FocusGained

    private void jDialogBuscarRegistroWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogBuscarRegistroWindowClosing
        jTextFieldBuscarEspecie.setText("");
        busquedaRapida(jTextFieldBuscarEspecie, jTableEspecies);
    }//GEN-LAST:event_jDialogBuscarRegistroWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButtonEliminarFliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarFliaActionPerformed
        try {
            EntityManager em = emf.createEntityManager();
            Query consulta = em.createNamedQuery("Familia.findByFamNombre");
            consulta.setParameter("famNombre", jTextFieldEditarFlia.getText());
            Familia familia = (Familia) consulta.getSingleResult();
            FamiliaJpaController fjc = new FamiliaJpaController(emf);
            fjc.destroy(familia.getFamId());
            jComboBoxFamilias.setSelectedIndex(0);
            cargarListaFamilias();
            jDialogEditarFamilia.dispose();
        } /* } catch (IllegalOrphanException ex) {
            JOptionPane.showMessageDialog(null, "LA FAMILIA NO SE PUEDE ELIMINAR PORQUE TIENE GENEROS ASOCIADOS");
        } */ catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "LA FAMILIA QUE INTENTA ELIMINAR NO EXISTE");
        }
    }//GEN-LAST:event_jButtonEliminarFliaActionPerformed

    private void jButtonEliminarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarGeneroActionPerformed
        try {
            EntityManager em = emf.createEntityManager();
            Query consulta = em.createNamedQuery("Genero.findByGenNombre");
            consulta.setParameter("genNombre", jTextFieldEditarGenero.getText());
            Genero genero = (Genero) consulta.getSingleResult();
            GeneroJpaController gjc = new GeneroJpaController(emf);
            gjc.destroy(genero.getGenId());
            jComboBoxGeneros.setSelectedIndex(0);
            cargarListaGeneros(jComboBoxFamilias.getSelectedItem().toString());
            jDialogEditarGenero.dispose();
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "EL GENERO QUE INTENTA ELIMINAR NO EXISTE");
        }
    }//GEN-LAST:event_jButtonEliminarGeneroActionPerformed

    private void jTextFieldEspecieEtiquetaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEspecieEtiquetaKeyReleased
        permitirSoloNum(evt);
    }//GEN-LAST:event_jTextFieldEspecieEtiquetaKeyReleased

    private boolean validarCampos() {
        Boolean ok = false;
        if (jComboBoxFamilias.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una familia");
        } else if (jComboBoxGeneros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un género");
        } else if (jTextFieldEspecie.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una especie");
        } else {
            ok = true;
        }
        return ok;
    }

    private void generarEtiqueta(int idEsp) {
        try {
            ConexionBD conexion = new ConexionBD();
            JasperReport reporte = JasperCompileManager.compileReport("src/reportes/etiqueta.jrxml");
            Map parametros = new HashMap();
            parametros.put("paramEspecie", idEsp);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, conexion.getConexion());
            JasperViewer visor = new JasperViewer(print, false); // EL FALSE ES PARA QUE NO CIERRE LA APLICACION AL SALIR
            visor.setTitle("src/reportes/etiqueta.jrxml".toUpperCase());
            visor.setZoomRatio((float) 1);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL REPORTE: " + ex);
        }
    }

    private void setearCamposEspecie(Especie especie) {

        jTextFieldFamilia1.setText(especie.getEspIdFam().getFamNombre());
        jTextFieldGenero1.setText(especie.getEspIdGen().getGenNombre());
        jTextFieldEspecie1.setText(especie.getEspNombre());
        jTextFieldNomVul1.setText(especie.getEspNomVul());
        jTextFieldRecolector1.setText(especie.getEspRecolector());
        jTextFieldAcompañante1.setText(especie.getEspAcompanante());
        jXDatePickerFecRecoleccion1.getEditor().setText(especie.getEspFechaRecol());
        jTextFieldNumColeccion1.setText(especie.getEspNumColecc());
        jTextFieldPais1.setText(especie.getEspPais());
        jTextFieldProvincia1.setText(especie.getEspProv());
        jTextFieldDepartaento1.setText(especie.getEspDpto());
        jTextFieldLocalidad1.setText(especie.getEspLocalidad());
        jTextFieldObveservaciones1.setText(especie.getEspObservaciones());
        jXDatePickerFecIngreso1.getEditor().setText(especie.getEspFecIngreso());
        jTextFieldDeterminadoPor1.setText(especie.getEspDeterPor());
        if (especie.getEspDuplicado() == 1) {
            jCheckBoxDuplicado1.setSelected(true);
        } else {
            jCheckBoxDuplicado1.setSelected(false);
        }
        jTextAreaInfoDuplicado1.setText(especie.getEspDetalleDup());
    }

    private void recuperarDatosEspecie(Especie miEspecie) throws FileNotFoundException {

        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Familia.findByFamNombre");
        consulta.setParameter("famNombre", jTextFieldFamilia1.getText());
        miEspecie.setEspIdFam((Familia) consulta.getSingleResult());
        consulta = em.createNamedQuery("Genero.findByGenNombre");
        consulta.setParameter("genNombre", jTextFieldGenero1.getText());
        miEspecie.setEspIdGen((Genero) consulta.getSingleResult());
        miEspecie.setEspNombre(jTextFieldEspecie1.getText());
        miEspecie.setEspNomVul(jTextFieldNomVul1.getText());
        miEspecie.setEspRecolector(jTextFieldRecolector1.getText());
        miEspecie.setEspAcompanante(jTextFieldAcompañante1.getText());
        miEspecie.setEspFechaRecol(jXDatePickerFecRecoleccion1.getEditor().getText());
        miEspecie.setEspNumColecc(jTextFieldNumColeccion1.getText());
        miEspecie.setEspPais(jTextFieldPais1.getText());
        miEspecie.setEspProv(jTextFieldProvincia1.getText());
        miEspecie.setEspDpto(jTextFieldDepartaento1.getText());
        miEspecie.setEspLocalidad(jTextFieldLocalidad1.getText());
        miEspecie.setEspObservaciones(jTextFieldObveservaciones1.getText());
        miEspecie.setEspFecIngreso(jXDatePickerFecIngreso1.getEditor().getText());
        miEspecie.setEspDeterPor(jTextFieldDeterminadoPor1.getText());
        boolean duplicado = jCheckBoxDuplicado1.isSelected();
        int hayDuplicado = 0;
        if (duplicado) {
            hayDuplicado = 1;
        } else {
            hayDuplicado = 0;
        }
        miEspecie.setEspDuplicado(hayDuplicado);
        miEspecie.setEspDetalleDup(jTextAreaInfoDuplicado1.getText());
        // PARA GUARDAR UNA IMAGEN, EL CAMPO EN LA BD ES LONGBLOB (HASTA 16 MB)
        if (rutaImg != null) {
            File file = new File(rutaImg);
            FileInputStream fis;
            fis = new FileInputStream(file);
            byte[] b = new byte[(int) file.length()];
            try {
                fis.read(b);
                fis.close();
                miEspecie.setEspImagen(b);
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
            }
        }
        miEspecie.setEspEstado(1);
    }

    private void abrirDialogo(JDialog dialogo) {
        dialogo.setSize(1120, 700);
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);
    }

    public void setImageinImagePanel(File archivo, JXImageView imageView) {

        Image imagen = null;
        imagen = getImagen(archivo); // RECIBE UN ARCHIVO Y LO CONVIERTE EN IMAGEN
        int ancho = imageView.getWidth();
        int alto = imageView.getHeight();
        imagen = redimensionarImagen(imagen, ancho, alto);
        imageView.setImage(imagen);
    }

    public Image getImagen(File archivo) {
        Image imagen;
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = (ImageIO.read(archivo));
        } catch (IOException ex) {
            Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagen = bufferedImage;
        return imagen;
    }

    public Image redimensionarImagen(Image imagen, int ancho, int alto) {
        return imagen.getScaledInstance(ancho, alto, Image.SCALE_AREA_AVERAGING);
    }

    private void cargarListaFamilias() {
        jComboBoxFamilias.removeAllItems();
        jComboBoxFamilias.addItem("-- SELECCIONE --");
        jComboBoxGeneros.setSelectedIndex(0);
        FamiliaJpaController famControlador = new FamiliaJpaController(emf);
        List<Familia> listaFamilias = famControlador.findFamiliaEntities();

        for (int i = 0; i < listaFamilias.size(); i++) {
            Familia fam = listaFamilias.get(i);
            jComboBoxFamilias.addItem(fam.getFamNombre());
        }
    }

    private void cargarListaPaises() {
        jComboBoxPais.removeAllItems();
        jComboBoxPais.addItem("-- SELECCIONE --");
        jComboBoxProvincia.setSelectedIndex(0);
        PaisJpaController paisControlador = new PaisJpaController(emf);
        List<Pais> listaPaises = paisControlador.findPaisEntities();

        for (int i = 0; i < listaPaises.size(); i++) {
            Pais pais = listaPaises.get(i);
            jComboBoxPais.addItem(pais.getPaisnombre());
        }
    }

    private void cargarListaEstados(String nomPais) {
        jComboBoxProvincia.removeAllItems();
        jComboBoxProvincia.addItem("-- SELECCIONE --");
        EstadoJpaController estadoControlador = new EstadoJpaController(emf);
        List<Estado> listaEstados = estadoControlador.findEstadoEntities();
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Pais.findByPaisnombre");
        consulta.setParameter("paisnombre", nomPais);
        Pais pais = null;
        try {
            pais = (Pais) consulta.getSingleResult();
            for (int i = 0; i < listaEstados.size(); i++) {
                if (listaEstados.get(i).getUbicacionpaisid() == pais.getId()) {
                    Estado estado = listaEstados.get(i);
                    jComboBoxProvincia.addItem(estado.getEstadonombre());
                }
            }
        } catch (NonUniqueResultException e) {
            System.out.println("LA CONSULTA DEVOLVIO MAS DE UN RESULTADO");
        } catch (NullPointerException e) {
            System.out.println("LA CONSULTA NO DEVOLVIO NINGUN RESULTADO");
        }
    }

    private void cargarListaGeneros(String nomFlia) {
        jComboBoxGeneros.removeAllItems();
        jComboBoxGeneros.addItem("-- SELECCIONE --");
        GeneroJpaController genControlador = new GeneroJpaController(emf);
        List<Genero> listaGeneros = genControlador.findGeneroEntities();
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Familia.findByFamNombre");
        consulta.setParameter("famNombre", nomFlia);
        Familia flia = null;
        try {
            flia = (Familia) consulta.getSingleResult();
            for (int i = 0; i < listaGeneros.size(); i++) {
                if (listaGeneros.get(i).getIdFam().getFamId() == flia.getFamId()) {
                    Genero gen = listaGeneros.get(i);
                    jComboBoxGeneros.addItem(gen.getGenNombre());
                }
            }
        } catch (NonUniqueResultException e) {
            System.out.println("LA CONSULTA DEVOLVIO MAS DE UN RESULTADO");
        } catch (NullPointerException e) {
            System.out.println("LA CONSULTA NO DEVOLVIO NINGUN RESULTADO");
        }
    }

    private Boolean registrarEspecie() throws FileNotFoundException {
        Boolean registroExitoso = false;
        Especie miEspecie = new Especie();
        EspecieJpaController espControlador = new EspecieJpaController(emf);
        EntityManager em = emf.createEntityManager();
        try {

            Query consulta = em.createNamedQuery("Familia.findByFamNombre");
            consulta.setParameter("famNombre", jComboBoxFamilias.getSelectedItem().toString());
            miEspecie.setEspIdFam((Familia) consulta.getSingleResult());
            consulta = em.createNamedQuery("Genero.findByGenNombre");
            consulta.setParameter("genNombre", jComboBoxGeneros.getSelectedItem().toString());
            miEspecie.setEspIdGen((Genero) consulta.getSingleResult());
            miEspecie.setEspNombre(jTextFieldEspecie.getText());
            miEspecie.setEspNomVul(jTextFieldNomVul.getText());
            miEspecie.setEspRecolector(jTextFieldRecolector.getText());
            miEspecie.setEspAcompanante(jTextFieldAcompañante.getText());
            miEspecie.setEspFechaRecol(jXDatePickerFecRecoleccion.getEditor().getText());
            miEspecie.setEspNumColecc(jTextFieldNumColeccion.getText());
            miEspecie.setEspPais(jComboBoxPais.getSelectedItem().toString());
            miEspecie.setEspProv(jComboBoxProvincia.getSelectedItem().toString());
            miEspecie.setEspDpto(jTextFieldDepartaento.getText());
            miEspecie.setEspLocalidad(jTextFieldLocalidad.getText());
            miEspecie.setEspObservaciones(jTextFieldObveservaciones.getText());
            miEspecie.setEspFecIngreso(jXDatePickerFecIngreso.getEditor().getText());
            miEspecie.setEspDeterPor(jTextFieldDeterminadoPor.getText());
            boolean duplicado = jCheckBoxDuplicado.isSelected();
            int hayDuplicado = 0;
            if (duplicado) {
                hayDuplicado = 1;
            } else {
                hayDuplicado = 0;
            }
            miEspecie.setEspDuplicado(hayDuplicado);
            miEspecie.setEspDetalleDup(jTextAreaInfoDuplicado.getText());
            // PARA GUARDAR UNA IMAGEN, EL CAMPO EN LA BD ES LONGBLOB (HASTA 16 MB)
            if (rutaImg != null) {
                File file = new File(rutaImg);
                FileInputStream fis;
                fis = new FileInputStream(file);
                byte[] b = new byte[(int) file.length()];
                try {
                    fis.read(b);
                    fis.close();
                    miEspecie.setEspImagen(b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            miEspecie.setEspEstado(1);
            espControlador.create(miEspecie);
            registroExitoso = true;
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            limpiarCampos();
        } catch (NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "El ID de la Familia o Género está duplicado. Revise los registros en su BD.");
        }
        return registroExitoso;
    }

    private void limpiarCampos() {
        jComboBoxFamilias.setSelectedIndex(0);
        jComboBoxGeneros.setSelectedIndex(0);
        jTextFieldEspecie.setText("");
        jTextFieldNomVul.setText("");
        jTextFieldRecolector.setText("");
        jTextFieldAcompañante.setText("");
        jXDatePickerFecRecoleccion.getEditor().setText("");
        jTextFieldNumColeccion.setText("");
        jComboBoxPais.setSelectedIndex(0);
        jComboBoxProvincia.setSelectedIndex(0);
        jTextFieldDepartaento.setText("");
        jTextFieldLocalidad.setText("");
        jTextFieldObveservaciones.setText("");
        jXDatePickerFecIngreso.getEditor().setText("");
        jTextFieldDeterminadoPor.setText("");
        jCheckBoxDuplicado.setSelected(false);
        jTextAreaInfoDuplicado.setText("");
        Image imagenVacia = null;
        jXImageView2.setImage(imagenVacia);
    }

    private void busquedaRapida(JTextField campoTexto, JTable tabla) {

        String text = campoTexto.getText();
        if (text.equals("")) {
            tabla.setRowSorter(null);
            //sorter.setModel(tabla.getModel());
        } else {
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla.getModel());
            //sorter.setModel(tabla.getModel());
            sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + text + ".*"));
            tabla.setRowSorter(sorter);
        }
    }

    private void permitirSoloNum(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) /*corresponde a BACK_SPACE*/ {
            evt.consume();  // ignorar el evento de teclado
        }
    }

    private void permitirSoloNumYPunto(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }

    private void recuperarImagen(Especie especie) {
        byte[] data = especie.getEspImagen();
        Image img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(data));
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        img = redimensionarImagen(img, 360, 232);
        jXImageView3.setImage(img);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButtonBuscarReg;
    private javax.swing.JButton jButtonCargarImagen;
    private javax.swing.JButton jButtonCargarImagen1;
    private javax.swing.JButton jButtonDetalle;
    private javax.swing.JButton jButtonEditarEspecie;
    private javax.swing.JButton jButtonEditarEstados;
    private javax.swing.JButton jButtonEditarFamilia;
    private javax.swing.JButton jButtonEditarFamilia1;
    private javax.swing.JButton jButtonEditarGenero;
    private javax.swing.JButton jButtonEditarGenero1;
    private javax.swing.JButton jButtonEditarPaises;
    private javax.swing.JButton jButtonEliminarFlia;
    private javax.swing.JButton jButtonEliminarGenero;
    private javax.swing.JButton jButtonEliminarRegistro;
    private javax.swing.JButton jButtonEliminarUsuario;
    private javax.swing.JButton jButtonEtiqueta;
    private javax.swing.JButton jButtonGenerarEtiq;
    private javax.swing.JButton jButtonGenerarEtiqueta;
    private javax.swing.JButton jButtonModificarFlia;
    private javax.swing.JButton jButtonModificarGenero;
    private javax.swing.JButton jButtonNuevaFlia;
    private javax.swing.JButton jButtonNuevoGenero;
    private javax.swing.JButton jButtonNuevoReg;
    private javax.swing.JButton jButtonRegistrarEspecie;
    private javax.swing.JButton jButtonRegistrarUsuario;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JCheckBox jCheckBoxDuplicado;
    private javax.swing.JCheckBox jCheckBoxDuplicado1;
    private javax.swing.JComboBox<String> jComboBoxFamilias;
    private javax.swing.JComboBox<String> jComboBoxGeneros;
    private javax.swing.JComboBox<String> jComboBoxPais;
    private javax.swing.JComboBox<String> jComboBoxProvincia;
    private javax.swing.JComboBox<String> jComboBoxSelecEstado;
    private javax.swing.JComboBox<String> jComboBoxSelecFamilia;
    private javax.swing.JComboBox<String> jComboBoxSelecGenero;
    private javax.swing.JComboBox<String> jComboBoxSelecPais;
    private javax.swing.JComboBox jComboBoxTipoUsuario;
    private javax.swing.JDialog jDialogBuscarRegistro;
    private javax.swing.JDialog jDialogEditarFamilia;
    private javax.swing.JDialog jDialogEditarGenero;
    private javax.swing.JDialog jDialogEditarRegistro;
    private javax.swing.JDialog jDialogGenerarEtiqueta;
    private javax.swing.JDialog jDialogNuevoRegistro;
    private javax.swing.JDialog jDialogSelecEstado;
    private javax.swing.JDialog jDialogSelecGenero;
    private javax.swing.JDialog jDialogSelecPais;
    private javax.swing.JDialog jDialogSelecfamilia;
    private javax.swing.JDialog jDialogUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordFieldContraseña;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableEspecies;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextArea jTextAreaInfoDuplicado;
    private javax.swing.JTextArea jTextAreaInfoDuplicado1;
    private javax.swing.JTextField jTextFieldAcompañante;
    private javax.swing.JTextField jTextFieldAcompañante1;
    private javax.swing.JTextField jTextFieldBuscarEspecie;
    private javax.swing.JTextField jTextFieldDepartaento;
    private javax.swing.JTextField jTextFieldDepartaento1;
    private javax.swing.JTextField jTextFieldDeterminadoPor;
    private javax.swing.JTextField jTextFieldDeterminadoPor1;
    private javax.swing.JTextField jTextFieldEditarFlia;
    private javax.swing.JTextField jTextFieldEditarGenero;
    private javax.swing.JTextField jTextFieldEspecie;
    private javax.swing.JTextField jTextFieldEspecie1;
    private javax.swing.JTextField jTextFieldEspecieEtiqueta;
    private javax.swing.JTextField jTextFieldFamilia1;
    private javax.swing.JTextField jTextFieldGenero1;
    private javax.swing.JTextField jTextFieldLocalidad;
    private javax.swing.JTextField jTextFieldLocalidad1;
    private javax.swing.JTextField jTextFieldNomVul;
    private javax.swing.JTextField jTextFieldNomVul1;
    private javax.swing.JTextField jTextFieldNumColeccion;
    private javax.swing.JTextField jTextFieldNumColeccion1;
    private javax.swing.JTextField jTextFieldObveservaciones;
    private javax.swing.JTextField jTextFieldObveservaciones1;
    private javax.swing.JTextField jTextFieldPais1;
    private javax.swing.JTextField jTextFieldProvincia1;
    private javax.swing.JTextField jTextFieldRecolector;
    private javax.swing.JTextField jTextFieldRecolector1;
    private javax.swing.JTextField jTextFieldUsuario;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerFecIngreso;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerFecIngreso1;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerFecRecoleccion;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerFecRecoleccion1;
    private org.jdesktop.swingx.JXImageView jXImageView2;
    private org.jdesktop.swingx.JXImageView jXImageView3;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    // End of variables declaration//GEN-END:variables

}
