package projetoPDM.principal;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetoPDM.views.ManterAluno;
import projetoPDM.views.ManterBoletim;
import projetoPDM.views.ManterRC;
import projetoPDM.views.ManterUsuario;



public class Principal {

    public static void main(String[] args) throws SQLException, ClassNotFoundException { 
        if(ManterUsuario.validar() == true ){
        Principal();
        }
        JOptionPane.showMessageDialog(null,"Login ou senha invalido!");
    }
    public static void Principal() throws SQLException, ClassNotFoundException {
        //do while tentar mudar o menu
        String numero = "0";
        while (numero.equals("0")) {
        String msg = "MENU PRINCIPAL\n\nINSIRA UMA OPÇÃO:\n0 - SAIR \n1 - USUARIO \n2 - ALUNO \n3 - BOLETIM \n4 - REGISTRO COMPLETO";
        numero = JOptionPane.showInputDialog(msg);
        if (numero == null || numero.equals("")/*chegar no defaut quando for vazio , jeff falou colocar menos 1 e ver como vai pra default*/  ){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (Integer.parseInt(numero)) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"DESEJA SAIR?");
                if (sair > 0) Principal();
                System.exit(0);
                break;
            case 1:
                ManterUsuario.mUsuario();
                break;
            case 2:
                ManterAluno.mAluno();
                break;
            case 3:
                ManterBoletim.mBoletim();
                break;
            case 4:
                ManterRC.mRC();
                break;
                
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
                }

            }
        }
    }
}

    

