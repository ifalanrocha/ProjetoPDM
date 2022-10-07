package projetoPDM.controllers;

import java.sql.SQLException;
import java.util.List;
import projetoPDM.models.beans.RC;
import projetoPDM.models.daos.DaoRC;

public class ControllerRC {
        static DaoRC daoRc;
    
    public RC inserir (RC bol) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.inserir(bol);
    }
    public RC alterar (RC bol) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.alterar(bol);
    }
    public List<RC> listar (RC bol) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.listar(bol);
    }
    public RC excluir(RC bol) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.excluir(bol);
    }
    public RC buscar(RC bol) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.buscar(bol);
    }
}
