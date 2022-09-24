package projetoPDM.views;

import projetoPDM.controllers.ControllerUsuarioPessoa;
import projetoPDM.models.beans.UsuarioPessoa;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterUsuarioPessoa {
    
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
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("IDUSUARIO"));
        int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("IDPESSOA"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioPessoa usupesEnt = new UsuarioPessoa(idUsuario, idPessoa, obs);
        ControllerUsuarioPessoa contUsuPes = new ControllerUsuarioPessoa();
        UsuarioPessoa usupesSaida = contUsuPes.inserir(usupesEnt);
        JOptionPane.showMessageDialog(null, usupesSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("IDUSUARIO"));
        int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("IDPESSOA"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioPessoa usupesEnt = new UsuarioPessoa(id,idUsuario, idPessoa, obs);
        ControllerUsuarioPessoa contUsuPes = new ControllerUsuarioPessoa();
        UsuarioPessoa usupesSaida = contUsuPes.alterar(usupesEnt);
        JOptionPane.showMessageDialog(null, usupesSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioPessoa usupesEnt = new UsuarioPessoa(id);
        ControllerUsuarioPessoa contUsuPes = new ControllerUsuarioPessoa();
        UsuarioPessoa usupesSaida = contUsuPes.buscar(usupesEnt);
        JOptionPane.showMessageDialog(null, usupesSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioPessoa usupesEnt = new UsuarioPessoa(id);
        ControllerUsuarioPessoa contUsuPes = new ControllerUsuarioPessoa();
        UsuarioPessoa usupesSaida = contUsuPes.excluir(usupesEnt);
        JOptionPane.showMessageDialog(null, usupesSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioPessoa usupesEnt = new UsuarioPessoa(obs);
        ControllerUsuarioPessoa contUsuPes = new ControllerUsuarioPessoa();
        List<UsuarioPessoa> listaUsuarioPessoa = contUsuPes.listar(usupesEnt);
        JOptionPane.showMessageDialog(null, listaUsuarioPessoa.get(1).toString());
    }
}
