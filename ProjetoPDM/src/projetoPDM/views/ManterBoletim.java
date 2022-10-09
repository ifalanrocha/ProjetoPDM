package projetoPDM.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetoPDM.controllers.ControllerBoletim;
import projetoPDM.models.beans.Boletim;
import projetoPDM.principal.Principal;

public class ManterBoletim {
        public static void mBoletim() throws SQLException, ClassNotFoundException {
        int num = 1;
        String numero;
        while (num != 0) {
        String msg = " MENU BOLETIM\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        numero = JOptionPane.showInputDialog(msg);
        if (numero == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
            num = Integer.parseInt(numero);
        switch (num) {
            case 1:
                ManterBoletim.inserir();
                break;
            case 2:
                ManterBoletim.alterar();
                break;
            case 3:
                ManterBoletim.buscar();
                break;
            case 4:
                ManterBoletim.excluir();
                break;
            case 5:
                ManterBoletim.listar();
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
        String num = JOptionPane.showInputDialog("SEMESTRE");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterBoletim.mBoletim();
        }
        int semestre = Integer.parseInt(num);
        int nmat = Integer.parseInt(JOptionPane.showInputDialog("NOTA DE MATEMATICA"));
        int npor = Integer.parseInt(JOptionPane.showInputDialog("NOTA DE PORTUGUES"));
        int ngeo = Integer.parseInt(JOptionPane.showInputDialog("NOTA DE GEOGRAFIA"));
        Boletim bolEnt = new Boletim(semestre, nmat, npor, ngeo);
        ControllerBoletim contBol = new ControllerBoletim();
        Boletim bolSaida = contBol.inserir(bolEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterBoletim.mBoletim();
        }
        int idbol = Integer.parseInt(num);
        int semestre = Integer.parseInt(JOptionPane.showInputDialog("SEMESTRE"));
        int nmat = Integer.parseInt(JOptionPane.showInputDialog("NOTA DE MATEMATICA"));
        int npor = Integer.parseInt(JOptionPane.showInputDialog("NOTA DE PORTUGUES"));
        int ngeo = Integer.parseInt(JOptionPane.showInputDialog("NOTA DE GEOGRAFIA"));
        Boletim bolEnt = new Boletim(idbol,semestre, nmat, npor, ngeo);
        ControllerBoletim contBol = new ControllerBoletim();
        Boletim bolSaida = contBol.alterar(bolEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterBoletim.mBoletim();
        }
        int idbol = Integer.parseInt(num);
        Boletim bolEnt = new Boletim(idbol);
        ControllerBoletim contBol = new ControllerBoletim();
        Boletim bolSaida = contBol.buscar(bolEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterBoletim.mBoletim();
        }
        int idbol = Integer.parseInt(num);
        Boletim bolEnt = new Boletim(idbol);
        ControllerBoletim contBol = new ControllerBoletim();
        Boletim bolSaida = contBol.excluir(bolEnt);
        JOptionPane.showMessageDialog(null, bolSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterBoletim.mBoletim();
        }
        int idbol = Integer.parseInt(num);
        Boletim bolEnt = new Boletim(idbol);
        ControllerBoletim contBol = new ControllerBoletim();
        List<Boletim> listaBoletim = contBol.listar(bolEnt);
        for(Boletim bol : listaBoletim) {
            JOptionPane.showMessageDialog(null, bol.toString());
        }
    }
}
