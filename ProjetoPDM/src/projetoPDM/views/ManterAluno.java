package projetoPDM.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetoPDM.controllers.ControllerAluno;
import projetoPDM.models.beans.Aluno;
import projetoPDM.principal.Principal;

public class ManterAluno {

            public static void mAluno() throws SQLException, ClassNotFoundException {
        int num = 1;
        String numero;
        while (num != 0) {
        String msg = " MENU ALUNO\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        numero = JOptionPane.showInputDialog(msg);
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
            num = Integer.parseInt(numero);
        switch (num) {
            case 1:
                ManterAluno.inserir();
                break;
            case 2:
                ManterAluno.alterar();
                break;
            case 3:
                ManterAluno.buscar();
                break;
            case 4:
                ManterAluno.excluir();
                break;
            case 5:
                ManterAluno.listar();
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
        String nome = JOptionPane.showInputDialog("NOME");
        String ra = JOptionPane.showInputDialog("RA");
        String ano = JOptionPane.showInputDialog("ANO");
        String idade = JOptionPane.showInputDialog("IDADE");
        Aluno aluEnt = new Aluno(nome ,ra , ano, idade);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.inserir(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int idalu = Integer.parseInt(JOptionPane.showInputDialog("ID"));
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
        int idalu = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Aluno aluEnt = new Aluno(idalu);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.buscar(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int idalu = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Aluno aluEnt = new Aluno(idalu);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.excluir(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String ra = JOptionPane.showInputDialog("NOME");
        Aluno aluEnt = new Aluno(ra);
        ControllerAluno contAlu = new ControllerAluno();
        List<Aluno> listaUsuario = contAlu.listar(aluEnt);
        for(Aluno alu : listaUsuario) {
            JOptionPane.showMessageDialog(null, alu.toString());
        }
    }
}
