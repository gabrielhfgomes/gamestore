package gamesstore;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;



/**
 *
 * @author rafae
 */
public class carrega extends javax.swing.JFrame {

    /**
     * Creates new form Carregamento
     */
   private JProgressBar Barra_de_Carregamento = new JProgressBar();
    private JButton Iniciar = new JButton("Inicializar");
   
    // Fonte a ser utilizada no JLabel
    private Font Fonte = new Font("Lucida Console", Font.PLAIN, 18);
    private JLabel Status = new JLabel();
   
    public carrega(){
        super("Tela de carregamento...");
           
        // Layout do JFrame
            setLayout(new FlowLayout());
       
        // Propriedades da janela
        this.setSize(300,120);
        // Localização do programa na tela
        this.setLocation(100,100);
        this.setResizable(false);
        this.setVisible(true);
     
      // Quando true é exibido o percentual no carregamento
      Barra_de_Carregamento.setStringPainted(true);    
      this.add(Barra_de_Carregamento);
     
     
      this.add(Iniciar);
      Status.setFont(Fonte);
      this.add(Status);
   
   
    // Eventos que acontecerão ao click no botão Iniciar
    Iniciar.addActionListener(new ActionListener(){
       
        public void actionPerformed(ActionEvent event) {
           
            Rectangle progresso = Barra_de_Carregamento.getBounds();  
            progresso.x = 0;  
            progresso.y = 0;  
           
            Barra_de_Carregamento.setValue(0);  
            // Barra de carregamento tem valor mínimo igual a zero
            Barra_de_Carregamento.setMinimum(0);  
            // Barra de carregamento tem valor máximo igual a cem
            Barra_de_Carregamento.setMaximum(100);
         
           
          // Modifica o cursor para indicar carregamento
          setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));         
         
             for(int i=0 ; i <= 100 ; i++){
                // 0,1 segundos equivale a 1% da barra de carregamento
                try {Thread.sleep(100);} catch (InterruptedException Ig) {}
                // Atualizando o valor da barra de carregamento
                Barra_de_Carregamento.setValue(i);
                Barra_de_Carregamento.paintImmediately(progresso); 
             }
         
          // Devolve o cursor a forma inicial
          setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
          // Mensagem é exibida ao fim do primeiro carregamento
          Status.setText("Carregamento Concluido.");
            JFrmMenu p = new JFrmMenu();
            p.setVisible(true);
            
            
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(carrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new carrega().setVisible(true);
            }
        });
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
