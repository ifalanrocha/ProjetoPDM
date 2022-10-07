package projetoPDM.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetoPDM.controllers.ControllerRC;
import projetoPDM.models.beans.RC;
import projetoPDM.principal.Principal;

public class ManterRC {
            public static void mRC() throws SQLException, ClassNotFoundException {
        int num = 1;
        String numero;
        while (num != 0) {
        String msg = " MENU REGISTRO COMPLETO\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        numero = JOptionPane.showInputDialog(msg);
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
            num = Integer.parseInt(numero);
        switch (num) {
            case 1:
                ManterRC.inserir();
                break;
            case 2:
                ManterRC.alterar();
                break;
            case 3:
                ManterRC.buscar();
                break;
            case 4:
                ManterRC.excluir();
                break;
            case 5:
                ManterRC.listar();
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
        int idusu = Integer.parseInt(JOptionPane.showInputDialog("ID USUARIO"));
        int idalu = Integer.parseInt(JOptionPane.showInputDialog("ID ALUNO"));
        int idbol = Integer.parseInt(JOptionPane.showInputDialog("ID BOLETIM"));
        RC rcEnt = new RC(idusu, idalu, idbol);
        ControllerRC contAlu = new ControllerRC();
        RC bolSaida = contAlu.inserir(rcEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int idrc = Integer.parseInt(JOptionPane.showInputDialog("ID REGISTRO COMPLETO"));
        int idusu = Integer.parseInt(JOptionPane.showInputDialog("ID USUARIO"));
        int idalu = Integer.parseInt(JOptionPane.showInputDialog("ID ALUNO"));
        int idbol = Integer.parseInt(JOptionPane.showInputDialog("ID BOLETIM"));
        RC rcEnt = new RC(idrc,idusu, idalu, idbol);
        ControllerRC contAlu = new ControllerRC();
        RC bolSaida = contAlu.alterar(rcEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int idrc = Integer.parseInt(JOptionPane.showInputDialog("ID REGISTRO COMPLETO"));
        RC rcEnt = new RC(idrc);
        ControllerRC contBol = new ControllerRC();
        RC bolSaida = contBol.buscar(rcEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int idrc = Integer.parseInt(JOptionPane.showInputDialog("ID REGISTRO COMPLETO"));
        RC rcEnt = new RC(idrc);
        ControllerRC contBol = new ControllerRC();
        RC bolSaida = contBol.excluir(rcEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        int idrc = Integer.parseInt(JOptionPane.showInputDialog("ID REGISTRO COMPLETO"));
        RC rcEnt = new RC(idrc);
        ControllerRC contBol = new ControllerRC();
        List<RC> listaRC = contBol.listar(rcEnt);
        for(RC bol : listaRC) {
            JOptionPane.showMessageDialog(null, bol.toString());
        }
    }
}