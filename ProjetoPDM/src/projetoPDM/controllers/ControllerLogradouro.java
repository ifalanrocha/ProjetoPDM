package projetoPDM.controllers;

import java.sql.SQLException;
import projetoPDM.models.beans.Logradouro;
import projetoPDM.models.daos.DaoLogradouro;


public class ControllerLogradouro {
   
static DaoLogradouro daoLog;
    
    public Logradouro inserir (Logradouro logEnt) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.inserir(logEnt);
    }
}
