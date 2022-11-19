package projetoPDM.controllers;

import java.sql.SQLException;
import java.util.List;
import projetoPDM.models.beans.RC;
import projetoPDM.models.daos.DaoRC;

public class ControllerRC {
        static DaoRC daoRc;
    
    public RC inserir (RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.inserir(darc);
    }
    public RC alterar (RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.alterar(darc);
    }
    public List<RC> listar (RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.listar(darc);
    }
    public RC excluir(RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.excluir(darc);
    }
    public RC buscar(RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.buscar(darc);
    }
        
    public static void excluiridusuario(int idusu) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC();
        daoRc.excluiridusuario(idusu);
    }
        
    public static void excluiridaluno(int idalu) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC();
        daoRc.excluiridaluno(idalu);
    }
            
    public static void excluiridboletim(int idbol) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC();
        daoRc.excluiridboletim(idbol);
    }
}
