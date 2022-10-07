package projetoPDM.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetoPDM.controllers.ControllerUsuario;
import projetoPDM.models.beans.Usuario;
import projetoPDM.principal.Principal;

public class ManterUsuario {
   
        public static void mUsuario() throws SQLException, ClassNotFoundException {
        int num = 1;
        String numero;
        while (num != 0) {
        String msg = " MENU USUARIO\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        numero = JOptionPane.showInputDialog(msg);
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
            num = Integer.parseInt(numero);
        switch (num) {
            case 1:
                ManterUsuario.inserir();
                break;
            case 2:
                ManterUsuario.alterar();
                break;
            case 3:
                ManterUsuario.buscar();
                break;
            case 4:
                ManterUsuario.excluir();
                break;
            case 5:
                ManterUsuario.listar();
                break;
            case 6:
                Principal.Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}
    
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Usuario usuEnt = new Usuario(login,senha,status, tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Usuario usuEnt = new Usuario(id,login,senha,status, tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usuEnt = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.buscar(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usuEnt = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = contUsu.excluir(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        Usuario usuEnt = new Usuario(login);
        ControllerUsuario contUsu = new ControllerUsuario();
        List<Usuario> listaUsuario = contUsu.listar(usuEnt);
        for(Usuario usu : listaUsuario) {
            JOptionPane.showMessageDialog(null, usu.toString());
        }
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        Usuario usuEnt = new Usuario(login,senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        retorno = contUsu.validar(usuEnt);
        return retorno;
    }
}
