package FrmNuevaLogin;


import com.mycompany.productos.dao.UsuarioDao;
import com.mycompany.productos.model.Usuario;
import com.mycompany.productos.util.Conexion;
import javax.swing.JOptionPane;

public class FrmLogin extends javax.swing.JFrame {

    private UsuarioDao dao;

    public FrmLogin() {

        initComponents();

        btnIngresar.addActionListener(
                this::btnIngresarActionPerformed
        );

        try {

            dao = new UsuarioDao(
                    Conexion.obtenerConexion()
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }

    private void btnIngresarActionPerformed(
            java.awt.event.ActionEvent evt) {

        try {

            String usuario =
                    txtUsuario.getText().trim();

            String password =
                    txtPassword.getText().trim();

            Usuario u =
                    dao.login(usuario, password);

            if (u != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Bienvenido " + u.getNombre()
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Usuario o contraseña incorrectos"
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        btnIngresar.setText("Ingresar");

        javax.swing.GroupLayout layout =
                new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIngresar)
                    .addGroup(layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(20, 20, 20)
                            .addComponent(txtUsuario,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                200,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(20, 20, 20)
                            .addComponent(txtPassword))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnIngresar)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() ->
                new FrmLogin().setVisible(true));
    }

    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
}