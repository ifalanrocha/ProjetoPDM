package projetoPDM.views;

import projetoPDM.controllers.ControllerUsuario;
import projetoPDM.models.beans.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterUsuario {
    
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - INSERIR \n 2 - ALTERAR \n 3 - BUSCAR \n 4 - EXCLUIR \n 5 - LISTAR" ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("OPÇÃO INVALIDA");
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
