
package Controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.Connection;
import javax.swing.JOptionPane;
import Vista.*;
public class VLogin{

    public void verificarLogin(JTextField user, JPasswordField password) {
       
        try {
            ResultSet rs=null;
            PreparedStatement ps=null;
            CreaConexion objConexcion = new CreaConexion();
            String consulta="select * from Admistrador WHERE Admistrador.user = (?) and Admistrador.password = (?)";
            ps = CreaConexion.getConnection().prepareStatement(consulta);
            String contra = String.valueOf(password.getPassword());
            ps.setString(1, user.getText());
            ps.setString(2,contra );
            
            rs = ps.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "EL USUARIO ES CORRECTO");
                ModuloPrincipal objMenu = new ModuloPrincipal();
                objMenu.setVisible(true);
            }else
            {   JOptionPane.showMessageDialog(null, "EL USUARIO ES INCORRECTO VUELVA A INTERTARLO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error : "+e.toString());
        }

    /*@Override
    // void verificarNivelAcceso() {
        System.out.println("HOLA");
   }*/
   }
    
    
}
