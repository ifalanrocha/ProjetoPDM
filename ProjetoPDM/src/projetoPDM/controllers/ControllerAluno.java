package projetoPDM.controllers;

import java.sql.SQLException;
import java.util.List;
import projetoPDM.models.beans.Aluno;
import projetoPDM.models.daos.DaoAluno;

public class ControllerAluno {

    static DaoAluno daoAlu;
    
    public Aluno inserir (Aluno alu) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAluno(); 
        return daoAlu.inserir(alu);
    }
    public Aluno alterar (Aluno alu) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAluno(); 
        return daoAlu.alterar(alu);
    }
    public List<Aluno> listar (Aluno alu) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAluno(); 
        return daoAlu.listar(alu);
    }
    public Aluno excluir(Aluno alu) throws SQLException, ClassNotFoundException {
        ControllerRC contrc = new ControllerRC();
        contrc.excluiridaluno(alu.getIdalu()); 
        daoAlu = new DaoAluno(); 
        return daoAlu.excluir(alu);
    }
    public Aluno buscar(Aluno alu) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAluno(); 
        return daoAlu.buscar(alu);
    }
}
