package projetoPDM.views;

import java.sql.SQLException;
import projetoPDM.controllers.ControllerLogradouro;
import projetoPDM.models.beans.Logradouro;
import javax.swing.JOptionPane;

public class ManterLogradouro {
    
 public static void inserir() throws SQLException, ClassNotFoundException {
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("ID LOGRADOURO"));
        int idUsupes = Integer.parseInt(JOptionPane.showInputDialog("ID USUPESSOA"));
        int numero = Integer.parseInt(JOptionPane.showInputDialog("NUMERO"));
        String rua = JOptionPane.showInputDialog("RUA");
        String cep = JOptionPane.showInputDialog("CEP");
        String uf = JOptionPane.showInputDialog("UF");
        
        Logradouro logEnt = new Logradouro (idLog, idUsupes, rua, numero, cep, uf);
        ControllerLogradouro contLog = new ControllerLogradouro();
        
        
        
        Logradouro logSaida = contLog.inserir(logEnt);
        
        
        
        
        JOptionPane.showMessageDialog(null, "LOGRADOURO CRIADO COM SUCESSO!\n" + logSaida.toString()+ "\n\nOK PARA VOLTAR AO MENU PRINCIPAL");

    }
 public static void alterar() throws SQLException, ClassNotFoundException {
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("ID LOGRADOURO"));
        int idUsupes = Integer.parseInt(JOptionPane.showInputDialog("ID USUPESSOA"));
        int numero = Integer.parseInt(JOptionPane.showInputDialog("NUMERO"));
        String rua = JOptionPane.showInputDialog("RUA");
        String cep = JOptionPane.showInputDialog("CEP");
        String uf = JOptionPane.showInputDialog("UF");
        
        Logradouro logEnt = new Logradouro (idLog, idUsupes, rua, numero, cep, uf);
        ControllerLogradouro contLog = new ControllerLogradouro();
        
        
        
        Logradouro logSaida = contLog.inserir(logEnt);
        
        
        
        
        JOptionPane.showMessageDialog(null, "LOGRADOURO ALTERADO COM SUCESSO!\n" + logSaida.toString()+ "\n\nOK PARA VOLTAR AO MENU PRINCIPAL");
 }
 public static void buscar() throws SQLException, ClassNotFoundException {
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("ID LOGRADOURO"));
        int idUsupes = Integer.parseInt(JOptionPane.showInputDialog("ID USUPESSOA"));
        int numero = Integer.parseInt(JOptionPane.showInputDialog("NUMERO"));
        String rua = JOptionPane.showInputDialog("RUA");
        String cep = JOptionPane.showInputDialog("CEP");
        String uf = JOptionPane.showInputDialog("UF");
        
        Logradouro logEnt = new Logradouro (idLog, idUsupes, rua, numero, cep, uf);
        ControllerLogradouro contLog = new ControllerLogradouro();
        
        
        
        Logradouro logSaida = contLog.inserir(logEnt);
        
        
        
        
        JOptionPane.showMessageDialog(null, "LOGRADOURO ENCONTRADO!\n" + logSaida.toString()+ "\n\nOK PARA VOLTAR AO MENU PRINCIPAL");
 }
 public static void excluir() throws SQLException, ClassNotFoundException {
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("ID LOGRADOURO"));
        int idUsupes = Integer.parseInt(JOptionPane.showInputDialog("ID USUPESSOA"));
        int numero = Integer.parseInt(JOptionPane.showInputDialog("NUMERO"));
        String rua = JOptionPane.showInputDialog("RUA");
        String cep = JOptionPane.showInputDialog("CEP");
        String uf = JOptionPane.showInputDialog("UF");
        
        Logradouro logEnt = new Logradouro (idLog, idUsupes, rua, numero, cep, uf);
        ControllerLogradouro contLog = new ControllerLogradouro();
        
        
        
        Logradouro logSaida = contLog.inserir(logEnt);
        
        
        
        
        JOptionPane.showMessageDialog(null, "LOGRADOURO EXCLUIDO COM SUCESSO!\n" + logSaida.toString()+ "\n\nOK PARA VOLTAR AO MENU PRINCIPAL");
 }
 public static void listar() throws SQLException, ClassNotFoundException {
        int idLog = Integer.parseInt(JOptionPane.showInputDialog("ID LOGRADOURO"));
        int idUsupes = Integer.parseInt(JOptionPane.showInputDialog("ID USUPESSOA"));
        int numero = Integer.parseInt(JOptionPane.showInputDialog("NUMERO"));
        String rua = JOptionPane.showInputDialog("RUA");
        String cep = JOptionPane.showInputDialog("CEP");
        String uf = JOptionPane.showInputDialog("UF");
        
        Logradouro logEnt = new Logradouro (idLog, idUsupes, rua, numero, cep, uf);
        ControllerLogradouro contLog = new ControllerLogradouro();
        
        
        
        Logradouro logSaida = contLog.inserir(logEnt);
        
        
        
        
        JOptionPane.showMessageDialog(null, "LOGRADOUROS LISTADOS COM SUCESSO!\n" + logSaida.toString()+ "\n\nOK PARA VOLTAR AO MENU PRINCIPAL");
 }
}
