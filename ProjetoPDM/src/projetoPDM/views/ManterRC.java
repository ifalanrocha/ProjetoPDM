package projetoPDM.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetoPDM.controllers.ControllerRC;
import projetoPDM.models.beans.RC;
import projetoPDM.principal.Principal;
import static projetoPDM.principal.Principal.Principal;

public class ManterRC {
    
        public static void mRC() throws SQLException, ClassNotFoundException {
        String numero = "0";
        while (numero.equals("0")) {
        String msg = " MENU REGISTRO COMPLETO\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        numero = JOptionPane.showInputDialog(msg);
        if (numero == null || numero.equals("")){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                Principal();
                break;
        }else{            
        switch (Integer.parseInt(numero)) {
            case 1:
                ManterRC.inserir();
                mRC();
                break;
            case 2:
                ManterRC.alterar();
                mRC();
                break;
            case 3:
                ManterRC.buscar();
                mRC();
                break;
            case 4:
                ManterRC.excluir();
                mRC();
                break;
            case 5:
                ManterRC.listar();
                mRC();
                break;
            case 6:
                Principal.Principal();
                mRC();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
                }
            }
        }
    }
        public static void inserir() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID USUARIO");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterRC.mRC();
        }
        int idusu = Integer.parseInt(num);
        int idalu = Integer.parseInt(JOptionPane.showInputDialog("ID ALUNO"));
        int idbol = Integer.parseInt(JOptionPane.showInputDialog("ID BOLETIM"));
        RC rcEnt = new RC(idusu, idalu, idbol);
        ControllerRC contAlu = new ControllerRC();
        RC bolSaida = contAlu.inserir(rcEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterRC.mRC();
        }
        int idrc = Integer.parseInt(num);
        int idusu = Integer.parseInt(JOptionPane.showInputDialog("ID USUARIO"));
        int idalu = Integer.parseInt(JOptionPane.showInputDialog("ID ALUNO"));
        int idbol = Integer.parseInt(JOptionPane.showInputDialog("ID BOLETIM"));
        RC rcEnt = new RC(idrc,idusu, idalu, idbol);
        ControllerRC contAlu = new ControllerRC();
        RC bolSaida = contAlu.alterar(rcEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID REGISTRO COMPLETO");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterRC.mRC();
        }
        int idrc = Integer.parseInt(num);
        RC rcEnt = new RC(idrc);
        ControllerRC contBol = new ControllerRC();
        RC bolSaida = contBol.buscar(rcEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID REGISTRO COMPLETO");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterRC.mRC();
        }
        int idrc = Integer.parseInt(num);
        RC rcEnt = new RC(idrc);
        ControllerRC contBol = new ControllerRC();
        RC bolSaida = contBol.excluir(rcEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID REGISTRO COMPLETO");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterRC.mRC();
        }
        int idrc = Integer.parseInt(num);
        RC rcEnt = new RC(idrc);
        ControllerRC contBol = new ControllerRC();
        List<RC> listaRC = contBol.listar(rcEnt);
        for(RC bol : listaRC) {
            JOptionPane.showMessageDialog(null, bol.toString());
        }
    }
}