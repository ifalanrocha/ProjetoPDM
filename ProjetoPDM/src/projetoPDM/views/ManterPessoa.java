package projetoPDM.views;

import java.sql.SQLException;
import projetoPDM.controllers.ControllerPessoa;
import projetoPDM.models.beans.Pessoa;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterPessoa {
    
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
        String nome = JOptionPane.showInputDialog("NOME");
        String rg = JOptionPane.showInputDialog("RG");
        String cpf = JOptionPane.showInputDialog("CPF");
        String email = JOptionPane.showInputDialog("EMAIL");
        Pessoa pes = new Pessoa(nome,rg,cpf,email);
        ControllerPessoa contpes = new ControllerPessoa();
        pes = contpes.inserir(pes);
        JOptionPane.showMessageDialog(null,pes.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String rg = JOptionPane.showInputDialog("RG");
        String cpf = JOptionPane.showInputDialog("CPF");
        String email = JOptionPane.showInputDialog("EMAIL");
        Pessoa pes = new Pessoa(id,nome,rg,cpf,email);
        ControllerPessoa contpes = new ControllerPessoa();
        pes = contpes.alterar(pes);
        JOptionPane.showMessageDialog(null,pes.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pes = new Pessoa(id);
        ControllerPessoa contpes = new ControllerPessoa();
        pes = contpes.buscar(pes);
        JOptionPane.showMessageDialog(null,pes.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pes = new Pessoa(id);
        ControllerPessoa contpes = new ControllerPessoa();
        pes = contpes.excluir(pes);
        JOptionPane.showMessageDialog(null,pes.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Pessoa pes = new Pessoa(nome);
        ControllerPessoa contpes = new ControllerPessoa();
        List<Pessoa> listaPes = contpes.listar(pes);
        JOptionPane.showMessageDialog(null,listaPes.get(1).toString());
    } 
}
