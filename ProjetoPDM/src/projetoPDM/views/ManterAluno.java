package projetoPDM.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetoPDM.controllers.ControllerAluno;
import projetoPDM.models.beans.Aluno;
import projetoPDM.principal.Principal;
import static projetoPDM.principal.Principal.Principal;

public class ManterAluno {

        public static void mAluno() throws SQLException, ClassNotFoundException {
        String numero = "0";
        while (numero.equals("0")) {
        String msg = "MENU ALUNO\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        numero = JOptionPane.showInputDialog(msg);
        if (numero == null || numero.equals("")){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                Principal();
                break;
        }else{
        switch (Integer.parseInt(numero)) {
            case 1:
                ManterAluno.inserir();
                mAluno();
                break;
            case 2:
                ManterAluno.alterar();
                mAluno();
                break;
            case 3:
                ManterAluno.buscar();
                mAluno();
                break;
            case 4:
                ManterAluno.excluir();
                mAluno();
                break;
            case 5:
                ManterAluno.listar();
                mAluno();
                break;
            case 6:
                Principal.Principal();
                mAluno();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
                }
            }
        }
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        
        if(nome == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterAluno.mAluno();
        }
        String ra = JOptionPane.showInputDialog("RA");
        String ano = JOptionPane.showInputDialog("ANO");
        String idade = JOptionPane.showInputDialog("IDADE");
        Aluno aluEnt = new Aluno(nome ,ra , ano, idade);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.inserir(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterAluno.mAluno();
        }
        int idalu = Integer.parseInt(num);
        String nome = JOptionPane.showInputDialog("NOME");
        String ra = JOptionPane.showInputDialog("RA");
        String ano = JOptionPane.showInputDialog("ANO");
        String idade = JOptionPane.showInputDialog("IDADE");
        Aluno aluEnt = new Aluno(idalu ,nome ,ra , ano, idade);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.alterar(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterAluno.mAluno();
        }
        int idalu = Integer.parseInt(num);
        Aluno aluEnt = new Aluno(idalu);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.buscar(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        String num = JOptionPane.showInputDialog("ID");
        if(num == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterAluno.mAluno();
        }
        int idalu = Integer.parseInt(num);
        Aluno aluEnt = new Aluno(idalu);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.excluir(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String ra = JOptionPane.showInputDialog("NOME");
        if(ra == null){
            JOptionPane.showMessageDialog(null,"Cancelado!");
            ManterAluno.mAluno();
        }
        Aluno aluEnt = new Aluno(ra);
        ControllerAluno contAlu = new ControllerAluno();
        List<Aluno> listaUsuario = contAlu.listar(aluEnt);
        for(Aluno alu : listaUsuario) {
            JOptionPane.showMessageDialog(null, alu.toString());
        }
    }
}