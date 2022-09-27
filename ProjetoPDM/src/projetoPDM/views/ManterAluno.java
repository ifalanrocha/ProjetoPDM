package projetoPDM.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetoPDM.models.beans.Aluno;

class ManterAluno {

    public static void inserir() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Aluno aluEnt = new Aluno(login,senha,status, tipo);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.inserir(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Aluno aluEnt = new Aluno(id,login,senha,status, tipo);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.alterar(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Aluno aluEnt = new Aluno(id);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.buscar(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Aluno aluEnt = new Aluno(id);
        ControllerAluno contAlu = new ControllerAluno();
        Aluno aluSaida = contAlu.excluir(aluEnt);
        JOptionPane.showMessageDialog(null, aluSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        Aluno aluEnt = new Aluno(login);
        ControllerAluno contAlu = new ControllerUsuario();
        List<Aluno> listaUsuario = contAlu.listar(aluEnt);
        for(Aluno alu : listaUsuario) {
            JOptionPane.showMessageDialog(null, alu.toString());
        }
    }

    public static boolean validar() throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        Aluno aluEnt = new Aluno(login,senha);
        ControllerAluno contAlu = new ControllerAluno();
        retorno = contAlu.validar(aluEnt);
        return retorno;
    }
}
