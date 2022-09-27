package projetoPDM.views;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Menu {
     
    public static void Principal() throws SQLException, ClassNotFoundException {
        int num = 10;
        while (num != 0) {
        String msg = "MENU PRINCIPAL\n\nINSIRA UMA OPÇÃO:\n0 - SAIR \n1 - USUARIO \n2 - PESSOA \n3 - USUARIO/PESSOA \n4 - LOGRADOURO \n5 - PESSOAALUNO \n6 - DISCIPLINA \n7 - DISCIPLINAALUNO \n8 - ALUNO";
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"DESEJA SAIR?");
                if (sair > 0) Principal();
                break;
            case 1:
                mUsuario();
                break;
            case 2:
                mPessoa();
                break;
            case 3:
                mUsuarioPessoa();
                break;
            case 4:
                mLogradouro();
                break;
            case 5:
                mPessoaAluno();
                break;
            case 6:
                mDisciplina();
                break;
            case 7:
                mDisciplinaAluno();
                break;
            case 8:
                mAluno();
                break;
                
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
        }

      }
   }
}
        public static void mPessoa() throws SQLException, ClassNotFoundException {
        int num = 1;
        while (num != 0) {
        String msg = " MENU PESSOA\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n0 - VOLTAR" ;
        if  (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 1:
                ManterPessoa.inserir();
                break;
            case 2:
                ManterPessoa.alterar();
                break;
            case 3:
                ManterPessoa.buscar();
                break;
            case 4:
                ManterPessoa.excluir();
                break;
            case 5:
                ManterPessoa.listar();
                break;
            case 6:
                Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}
        public static void mUsuario() throws SQLException, ClassNotFoundException {
        int num = 1;
        while (num != 0) {
        String msg = " MENU USUARIO\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 1:
                ManterUsuario.inserir();
                break;
            case 2:
                ManterUsuario.alterar();
                break;
            case 3:
                ManterUsuario.buscar();
                break;
            case 4:
                ManterUsuario.excluir();
                break;
            case 5:
                ManterUsuario.listar();
                break;
            case 6:
                Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}
        public static void mUsuarioPessoa() throws SQLException, ClassNotFoundException {        
        int num = 1;
        while (num != 0) {
        String msg = " MENU USUARIO PESSOA\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 1:
                ManterUsuarioPessoa.inserir();
                break;
            case 2:
                ManterUsuarioPessoa.alterar();
                break;
            case 3:
                ManterUsuarioPessoa.buscar();
                break;
            case 4:
                ManterUsuarioPessoa.excluir();
                break;
            case 5:
                ManterUsuarioPessoa.listar();
                break;
            case 6:
                Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}
        
        public static void mLogradouro() throws SQLException, ClassNotFoundException {
        int num = 1;
        while (num != 0) {
        String msg = " MENU PESSOA\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 1:
                ManterLogradouro.inserir();
                break;
            case 2:
                ManterLogradouro.alterar();
                break;
            case 3:
                ManterLogradouro.buscar();
                break;
            case 4:
                ManterLogradouro.excluir();
                break;
            case 5:
                ManterLogradouro.listar();
                break;
            case 6:
                Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}
        public static void mPessoaAluno() throws SQLException, ClassNotFoundException {
        int num = 1;
        while (num != 0) {
        String msg = " MENU PESSOA\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 1:
                ManterLogradouro.inserir();
                break;
            case 2:
                ManterLogradouro.alterar();
                break;
            case 3:
                ManterLogradouro.buscar();
                break;
            case 4:
                ManterLogradouro.excluir();
                break;
            case 5:
                ManterLogradouro.listar();
                break;
            case 6:
                Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}
        public static void mDisciplina() throws SQLException, ClassNotFoundException {
        int num = 1;
        while (num != 0) {
        String msg = " MENU PESSOA\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 1:
                ManterLogradouro.inserir();
                break;
            case 2:
                ManterLogradouro.alterar();
                break;
            case 3:
                ManterLogradouro.buscar();
                break;
            case 4:
                ManterLogradouro.excluir();
                break;
            case 5:
                ManterLogradouro.listar();
                break;
            case 6:
                Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}
        public static void mDisciplinaAluno() throws SQLException, ClassNotFoundException {
        int num = 1;
        while (num != 0) {
        String msg = " MENU PESSOA\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 1:
                ManterLogradouro.inserir();
                break;
            case 2:
                ManterLogradouro.alterar();
                break;
            case 3:
                ManterLogradouro.buscar();
                break;
            case 4:
                ManterLogradouro.excluir();
                break;
            case 5:
                ManterLogradouro.listar();
                break;
            case 6:
                Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}
        public static void mAluno() throws SQLException, ClassNotFoundException {
        int num = 1;
        while (num != 0) {
        String msg = " MENU PESSOA\n\nINSIRA UMA OPÇÃO:\n1 - INSERIR \n2 - ALTERAR \n3 - BUSCAR \n4 - EXCLUIR \n5 - LISTAR \n6 - VOLTAR" ;
        if (JOptionPane.showInputDialog(msg) == null){
            
            JOptionPane.showMessageDialog(null, "Cancelado");
                break;
                
        }else{
        switch (num) {
            case 1:
                ManterLogradouro.inserir();
                break;
            case 2:
                ManterLogradouro.alterar();
                break;
            case 3:
                ManterLogradouro.buscar();
                break;
            case 4:
                ManterLogradouro.excluir();
                break;
            case 5:
                ManterLogradouro.listar();
                break;
            case 6:
                Principal();
                break;
            default:
                JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
                }
            }
        }
    }
}