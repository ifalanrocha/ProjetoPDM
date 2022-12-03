package projetoPDM.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetoPDM.models.beans.Aluno;
import projetoPDM.models.beans.RC;
import projetoPDM.models.beans.Usuario;
import projetoPDM.models.daos.DaoRC;

public class ControllerRC {
        static DaoRC daoRc;
        ControllerUsuario contUsu;
        ControllerAluno contAlu;
    
    public RC inserir (RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.inserir(darc);
    }
    public RC alterar (RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.alterar(darc);
    }
    public List<RC> listar(RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC();

        List<RC> listaUsuPesAux = daoRc.listar(darc);

        List<RC> listaUsuPesRetorno = new ArrayList<>();
                
        for(RC usupes : listaUsuPesAux) {        
            listaUsuPesRetorno.add(buscar(usupes));
        }

        return listaUsuPesRetorno;
    }
    
    public RC excluir(RC darc) throws SQLException, ClassNotFoundException {
        daoRc = new DaoRC(); 
        return daoRc.excluir(darc);
    }
    
    public RC buscar(RC darc) throws SQLException, ClassNotFoundException {

        daoRc = new DaoRC();
        RC usupesSaida = daoRc.buscar(darc);

        Usuario usuEnt = new Usuario(usupesSaida.getIdusu());
        contUsu = new ControllerUsuario();
        usupesSaida.setUsu(contUsu.buscar(usuEnt));
        
        Aluno aluEnt = new Aluno(usupesSaida.getIdalu());
        contAlu = new ControllerAluno();
        usupesSaida.setAlu(contAlu.buscar(aluEnt));

        return usupesSaida;
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
