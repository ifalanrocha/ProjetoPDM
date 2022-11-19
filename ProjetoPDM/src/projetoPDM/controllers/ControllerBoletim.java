package projetoPDM.controllers;

import java.sql.SQLException;
import java.util.List;
import projetoPDM.models.beans.Boletim;
import projetoPDM.models.daos.DaoBoletim;

public class ControllerBoletim {
    
    static DaoBoletim daoBol;
    
    public Boletim inserir (Boletim bol) throws SQLException, ClassNotFoundException {
        daoBol = new DaoBoletim(); 
        return daoBol.inserir(bol);
    }
    public Boletim alterar (Boletim bol) throws SQLException, ClassNotFoundException {
        daoBol = new DaoBoletim(); 
        return daoBol.alterar(bol);
    }
    public List<Boletim> listar (Boletim bol) throws SQLException, ClassNotFoundException {
        daoBol = new DaoBoletim(); 
        return daoBol.listar(bol);
    }
    public Boletim excluir(Boletim bol) throws SQLException, ClassNotFoundException {
        ControllerRC contrc = new ControllerRC();
        contrc.excluiridboletim(bol.getIdbol()); 
        daoBol = new DaoBoletim(); 
        return daoBol.excluir(bol);
    }
    public Boletim buscar(Boletim bol) throws SQLException, ClassNotFoundException {
        daoBol = new DaoBoletim(); 
        return daoBol.buscar(bol);
    }
}
