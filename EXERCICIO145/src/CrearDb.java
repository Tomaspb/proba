
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
/*
 * PROGRAMA QUE CONSTRUE UNH ABASE DE DATOS A PARTIR DUN ARQUIVO XML
 */

public class CrearDb extends javax.swing.JFrame {

    private Connection connection = null;
    
      //establece la conexión con la base de datos
   private void establecer_conexion(){
        try{
            connection=DriverManager.getConnection
               ("jdbc:mysql://localhost:3307/almacen","root","1234");
        
            System.out.println("Conexión correcta");
        }
        catch(SQLException e){
            e.printStackTrace();
            return;
        }
    }
    
   //lee los datos del fichero pedidos
   private void leer_fichero(){
    int idPedido;
          
    try{
        SAXBuilder builder = new SAXBuilder();
        
        try{
              Document doc = builder.build("Origen.xml");
                           
              //elemento raiz
              Element eMibase=doc.getRootElement();
              List lmisTablas=eMibase.getChildren();
              
              try{
                 PreparedStatement PsCreaBase=null;
                 String sentencia;
                 sentencia="CREATE DATABASE "+eMibase.getAttributeValue("nome");
                 System.out.println(sentencia);
                 
                 PsCreaBase.execute(sentencia);
               
              }
              catch(SQLException e){
                  e.printStackTrace();
              }

              
              //lista de datos
              Iterator<Element> iMibase=lmisTablas.iterator();
                          
              //Todos los Pedidos
              while(iMibase.hasNext()){
                  
              }
                 
        }
        catch(IOException e){
            e.printStackTrace();
        }
   }
   catch(JDOMException e){
    e.printStackTrace();
   }
}
    
    public CrearDb() {
        initComponents();
        establecer_conexion();
        leer_fichero();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
            java.util.logging.Logger.getLogger(CrearDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CrearDb().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
