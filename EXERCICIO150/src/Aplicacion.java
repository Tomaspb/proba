
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/*PROGRMA QUE XESTIONA USUARIOS E URLS*/

public class Aplicacion extends javax.swing.JFrame {
  
    public static Connection conexion=null;
    static ArrayList<Usuario> ALUsers = new ArrayList<Usuario>();  
    static ArrayList<Enlaces> ALEnlaces = new ArrayList<Enlaces>();
 
   
      //llenar arrayList con los usuarios de la tabla
    private void llenar_array(){
      
       
       try{
            Statement SconsUsuarios;
            SconsUsuarios=Aplicacion.conexion.createStatement();
            SconsUsuarios.execute("SELECT * FROM usuarios");
            
            ResultSet RsUsuarios;
            
            RsUsuarios=SconsUsuarios.getResultSet();
            
            while(RsUsuarios.next()){
                Usuario user = new Usuario();
                user.setLogin(RsUsuarios.getString("login"));
                user.setClave(RsUsuarios.getString("clave"));
                user.setId(RsUsuarios.getInt("id"));
                
                ALUsers.add(user);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private void llenar_array_enlace(){
        PreparedStatement psEnlaces;
        
        try{
          psEnlaces=Aplicacion.conexion.prepareStatement("SELECT * FROM enlaces");
          ResultSet RsEnlaces;
          
          RsEnlaces=psEnlaces.executeQuery();
          
          while(RsEnlaces.next()){
              Enlaces url= new Enlaces();
             
              url.setId(RsEnlaces.getInt("id"));
              url.setIdUsuario(RsEnlaces.getInt("idUsuario"));
              url.setTitulo(RsEnlaces.getString("titulo"));
              url.setUrl(RsEnlaces.getString("url"));
              
              Aplicacion.ALEnlaces.add(url);
          }
          
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
   
    public Aplicacion() {
        initComponents();
        this.jMnuUsuario.setEnabled(false);
        this.jBtGuardar.setVisible(false);
        
        
        establecer_conexion();
        llenar_array();
        llenar_array_enlace();
       
    }
      
   //establece la conexión con la base de datos
   private void establecer_conexion(){
        try{
            
            conexion=DriverManager.getConnection
               ("jdbc:mysql://localhost:3307/aplicacion","root","1234");
        
            System.out.println("Conexión correcta");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGQueMuestro = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtAEnlaces = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtClave = new javax.swing.JTextField();
        jBtEntrar = new javax.swing.JButton();
        jBtNuevo = new javax.swing.JButton();
        jBtGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTxtEtiqueta = new javax.swing.JTextField();
        jBtFiltraEtiqueta = new javax.swing.JButton();
        jRdBtPrivado = new javax.swing.JRadioButton();
        jRBtPublico = new javax.swing.JRadioButton();
        jRdBtPropioUsuario = new javax.swing.JRadioButton();
        jTxtUsuarioActual = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMnuUsuario = new javax.swing.JMenu();
        jMnuINuevo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTxtAEnlaces.setColumns(20);
        jTxtAEnlaces.setRows(5);
        jScrollPane2.setViewportView(jTxtAEnlaces);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("LOGIN");

        jLabel2.setText("CLAVE");

        jBtEntrar.setText("Entrar");
        jBtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEntrarActionPerformed(evt);
            }
        });

        jBtNuevo.setText("Nuevo");
        jBtNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNuevoActionPerformed(evt);
            }
        });

        jBtGuardar.setText("Guardar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jTxtClave, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jBtEntrar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jBtGuardar)))
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEntrar)
                    .addComponent(jBtNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtGuardar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jBtFiltraEtiqueta.setText("Filtra etiquetas");
        jBtFiltraEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFiltraEtiquetaActionPerformed(evt);
            }
        });

        bGQueMuestro.add(jRdBtPrivado);
        jRdBtPrivado.setText("Privado");

        bGQueMuestro.add(jRBtPublico);
        jRBtPublico.setText("Publico");

        bGQueMuestro.add(jRdBtPropioUsuario);
        jRdBtPropioUsuario.setText("Propio del usuario");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRdBtPrivado)
                        .addGap(45, 45, 45)
                        .addComponent(jRBtPublico)
                        .addGap(41, 41, 41)
                        .addComponent(jRdBtPropioUsuario))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTxtEtiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtFiltraEtiqueta)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtFiltraEtiqueta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdBtPrivado)
                    .addComponent(jRBtPublico)
                    .addComponent(jRdBtPropioUsuario))
                .addContainerGap())
        );

        jMnuUsuario.setText("Menu usuario");

        jMnuINuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMnuINuevo.setText("Nuevo Enlace");
        jMnuUsuario.add(jMnuINuevo);

        jMenuBar1.add(jMnuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jTxtUsuarioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTxtUsuarioActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNuevoActionPerformed

    private void jBtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEntrarActionPerformed
        
        String meuLogin;
        String contrasina;
        
        this.jTxtAEnlaces.setText("");
        
        Usuario user = new Usuario();
        meuLogin=this.jTxtLogin.getText();
        contrasina=this.jTxtClave.getText();
        
        user=Usuario.esCorrecto(meuLogin,contrasina);
        
        if(user==null){
            System.out.println("ESE USUARIO NO EXISTE");
        }
        else{
             PreparedStatement PsEnlaces;
            
             try{
                PsEnlaces=conexion.prepareStatement
                   ("SELECT * FROM enlaces WHERE idUsuario="+user.getId());  
               
                ResultSet RsEnlaces;
                RsEnlaces=PsEnlaces.executeQuery();
                while(RsEnlaces.next()){
                   if(this.jTxtAEnlaces.getText().equals("")){
                      this.jTxtAEnlaces.setText(RsEnlaces.getString("url"));
                   }
                   else{
                      this.jTxtAEnlaces.setText
                         (this.jTxtAEnlaces.getText()+
                          "\n"+RsEnlaces.getString("url"));
                   }
                }
               
                    this.jTxtUsuarioActual.setText(user.getLogin());
             }
             catch(SQLException e){
                e.printStackTrace();
             }
            
        }
        
    }//GEN-LAST:event_jBtEntrarActionPerformed

    //mostrar los enlaces que hay asociados a esa etiqueta
private void jBtFiltraEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFiltraEtiquetaActionPerformed
    String listaEtiquetas;
    listaEtiquetas=this.jTxtEtiqueta.getText();
    Enlaces e= new Enlaces();
    
    ArrayList<Enlaces> alEtiquetaEnlace=new ArrayList<Enlaces>();
  
    this.jTxtAEnlaces.setText(" ");
    
    if( (this.jRBtPublico.isSelected()==false) &&
        (this.jRdBtPrivado.isSelected()==false) &&
         (this.jRdBtPropioUsuario.isSelected()==false) ){
        System.out.println("debes de seleccionar el que quieres mostrar");
    }
    else{
        if(this.jRBtPublico.isSelected()==true){
          alEtiquetaEnlace=e.etiquetados(Aplicacion.ALEnlaces,0,listaEtiquetas);
        }
        
        if(this.jRdBtPrivado.isSelected()==true){
          alEtiquetaEnlace=e.etiquetados(Aplicacion.ALEnlaces,1,listaEtiquetas);
        }
        
        if(this.jRdBtPropioUsuario.isSelected()==true){
          alEtiquetaEnlace=e.etiquetados(Aplicacion.ALEnlaces,2,listaEtiquetas);
        }
        int i;
                  
        if(alEtiquetaEnlace.size()==0){
            this.jTxtAEnlaces.setText(" ");
        }
        
        for(i=0;i<alEtiquetaEnlace.size();i++){
            if(this.jTxtAEnlaces.getText().equals(" ")){
                this.jTxtAEnlaces.setText(alEtiquetaEnlace.get(i).getUrl());
            }
            else{
                this.jTxtAEnlaces.setText(this.jTxtAEnlaces.getText()+"\n"+alEtiquetaEnlace.get(i).getUrl());
            }
        }
    }
    
}//GEN-LAST:event_jBtFiltraEtiquetaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Aplicacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGQueMuestro;
    private javax.swing.JButton jBtEntrar;
    private javax.swing.JButton jBtFiltraEtiqueta;
    private javax.swing.JButton jBtGuardar;
    private javax.swing.JButton jBtNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMnuINuevo;
    private javax.swing.JMenu jMnuUsuario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRBtPublico;
    private javax.swing.JRadioButton jRdBtPrivado;
    private javax.swing.JRadioButton jRdBtPropioUsuario;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTxtAEnlaces;
    private javax.swing.JTextField jTxtClave;
    private javax.swing.JTextField jTxtEtiqueta;
    private javax.swing.JTextField jTxtLogin;
    private javax.swing.JTextField jTxtUsuarioActual;
    // End of variables declaration//GEN-END:variables
}


class Usuario{
    String login;
    String clave;
    int id;
       
    
    void setLogin(String meuLogin){
        this.login=meuLogin;
    }
    
    String getLogin(){
        return this.login;
    }
    
    void setClave(String meuClave){
        this.clave=meuClave;
    }
    
    String getClave(){
        return this.clave;
    }
    
    int getId(){
        return this.id;
    }
    
    void setId(int meuId){
        this.id=meuId;
    }
    
    static Usuario esCorrecto(String meuLogin, String meuClave){
        Usuario user = new Usuario();
        
        int i;
        for(i=0;i<Aplicacion.ALUsers.size();i++){
            if( (Aplicacion.ALUsers.get(i).getLogin().equals(meuLogin)) &&
                (Aplicacion.ALUsers.get(i).getClave().equals(meuClave)) ){
                user=Aplicacion.ALUsers.get(i);
            }
        }     
        return user;
    }
    
    void gardar(){
        /*Usuario user = new Usuario();
        
        int i;
        for(i=0;i<Aplicacion.ALUsers.size();i++){
            
        }*/
        
        
    }
}

class Enlaces{
    int id;
    String url;
    String titulo;
    int idUsuario;
    int tipoUsuario; //si es publico, privado o propio del propio usuario
    
    void setId(int meuId){
        this.id=meuId;
    }
    
    int getId(){
        return this.id;
    }
    
    void setUrl(String meuUrl){
        this.url=meuUrl;
    }
    
    String getUrl(){
        return this.url;
    }
    
    void setTitulo(String meuTitulo){
        this.titulo=meuTitulo;
    }
    
    String getTitulo(){
       return this.titulo; 
    }
    
    void setIdUsuario(int meuIdUsuario){
        this.idUsuario=meuIdUsuario;
    }
    
    int getIdUsuario(){
        return this.idUsuario;
    }
    
    void setTipoUsuario(int meuTipoUsuario){
        this.tipoUsuario=meuTipoUsuario;
    }
    
    int getTipoUsuario(){
        return this.tipoUsuario;
    }
    
    ///falta eiquetados
    ArrayList<Enlaces> etiquetados(ArrayList enlaces,int tipoEnlace,String etiquetas){
        ArrayList<Enlaces> et = new ArrayList<Enlaces>(); 
               
        String consulta1;
        String consulta2;
        String sonVarios="etiqueta= \"";
        
       
        if(etiquetas.contains(",")){
            sonVarios=sonVarios+etiquetas.replace(",","\" or etiqueta=\"");
        }
        else{
            sonVarios=sonVarios+etiquetas;
        }
        
        consulta1="Select * from enlaces where id in (";
        consulta2="Select idEnlace from etiquetas where "+sonVarios+"\")";
       
        System.out.println(consulta1+consulta2);
        
        try{
            PreparedStatement psConsenlaces;
            psConsenlaces=Aplicacion.conexion.prepareStatement(consulta1+consulta2);
            ResultSet rsEnlaces;
            
            rsEnlaces=psConsenlaces.executeQuery();
            
            while(rsEnlaces.next()){
                Enlaces url= new Enlaces();
                
                url.setId(rsEnlaces.getInt("id"));
                url.setIdUsuario(rsEnlaces.getInt("idUsuario"));
                url.setTitulo(rsEnlaces.getString("titulo"));
                url.setUrl(rsEnlaces.getString("url"));
                url.setTipoUsuario(rsEnlaces.getInt("tipousuario"));
                
                if(tipoEnlace==url.getTipoUsuario()){
                  et.add(url);  
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return et;   
}


class etiquetas{
    int idEnlace;
    String etiqueta;
    
    int getIdEnlace(){
        return this.idEnlace;
    }
    
    void setIdEnlace(int meuIdEnlace){
        this.idEnlace=meuIdEnlace;
    }
    
    String getEtiqueta(){
        return this.etiqueta;
    }
    
    void setEtiqueta(String meuEtiqueta){
        this.etiqueta=meuEtiqueta;
    }
    
}