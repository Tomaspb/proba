
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/*
 * CREAR UNA BASE DE DATOS A PARTIR DE UN FICHERO XML
 */


public class CrearBd extends javax.swing.JFrame {

   private Connection connection = null;
    
    private void Crear_Bd(){
        try{
            SAXBuilder builder = new SAXBuilder();
            String creaTablas;
            String sentenciaCrea="";
            
            try{
               org.jdom.Document doc= builder.build("Origen.xml"); 
               
               Element eBase=doc.getRootElement();
               
               try{
                                  
                   Statement SCrearbd;
                   SCrearbd=connection.createStatement();
                   
                   String nome;
                   nome=eBase.getAttributeValue("nome");
                                     
                   SCrearbd.execute("CREATE DATABASE IF NOT EXISTS "+nome);
                   SCrearbd.execute("USE "+nome);
                   
                   List lTablas=eBase.getChildren();
                   Iterator<Element> iTablas=lTablas.iterator(); 
                 
                   
                   while(iTablas.hasNext()){
                       Element eTabla=iTablas.next();
                       
                                            
                       creaTablas="CREATE TABLE IF NOT EXISTS ";
                       creaTablas=creaTablas+eTabla.getAttributeValue("nome")+"(";
                       
                       List lCampos=eTabla.getChildren();
                       Iterator<Element> iCampos=lCampos.iterator();
                       
                       while(iCampos.hasNext()){
                           Element eCampo=iCampos.next();
                           
                           if(eCampo.getName().equals("col")){
                               creaTablas=creaTablas+" "+eCampo.getText()+" "+
                               eCampo.getAttributeValue("tipo")+" "+
                               eCampo.getAttributeValue("extra")+",";
                           }
                           
                       }
                       
                       sentenciaCrea=creaTablas.substring(0,creaTablas.length()-1);
                       sentenciaCrea=sentenciaCrea+")";
                       System.out.println(sentenciaCrea);
                       
                       PreparedStatement PSCreaTabla;
                       PSCreaTabla=connection.prepareStatement(sentenciaCrea);
                       PSCreaTabla.executeUpdate();
                     
                       insertar_datos(lCampos);
                   }
               }
               catch(SQLException e){
                 e.printStackTrace();
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
    
    private void establecer_conexion(){
        try{
            connection=DriverManager.getConnection
               ("jdbc:mysql://localhost:3307","root","1234");
        
            System.out.println("Conexión correcta");
        }
        catch(SQLException e){
            e.printStackTrace();
            return;
        }
    }
    
    private boolean estaId(int idBusca){
        boolean esta=false;
        
        ResultSet RsProductos;
        
        PreparedStatement PsProductos;
        
        try{
            PsProductos=connection.prepareStatement("SELECT * FROM Productos");
            RsProductos=PsProductos.executeQuery();
            
            while(RsProductos.next()){
                if(RsProductos.getInt("id")==idBusca){
                    esta=true;
                }
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
       
        return esta;
    }
    

    private void insertar_datos(List lTaboa){
        
        Iterator<Element> iTaboa=lTaboa.iterator();
        
        while(iTaboa.hasNext()){
            Element eCampos=iTaboa.next();
            
            if(eCampos.getName().equals("Productos")){
                PreparedStatement psInserir;
                String sentenciaInsert;
                String taboa;
                
                taboa=eCampos.getName();
                String datos[] = new String[3];
                
                datos=eCampos.getText().split(",");
                int meuId;
                meuId=Integer.parseInt(datos[0]);
                
                if(estaId(meuId)==false){
                    
                    sentenciaInsert="INSERT INTO "+taboa+
                        "(id,nome,prezo) VALUES ("+datos[0]+",'"+
                                                   datos[1]+"',"+
                                                   datos[2]+")";
                
                    try{
                        psInserir=connection.prepareStatement(sentenciaInsert);
                        psInserir.executeUpdate();
                        psInserir.close();
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("ESE PRODUCTO XA EXISTE NA BASE DE DATOS");
                }
                    
                
            }
           
            
        }
        
        
    }    
    
    public CrearBd() {
        initComponents();
        establecer_conexion();
        
        Crear_Bd();
        
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
            java.util.logging.Logger.getLogger(CrearBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearBd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
