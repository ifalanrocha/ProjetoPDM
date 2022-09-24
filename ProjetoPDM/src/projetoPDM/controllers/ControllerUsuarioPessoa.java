package projetoPDM.controllers;

import projetoPDM.models.beans.Usuario;
import projetoPDM.models.beans.Pessoa;
import projetoPDM.models.beans.UsuarioPessoa;
import projetoPDM.models.daos.DaoUsuarioPessoa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerUsuarioPessoa {
    
    ControllerUsuario contUsu;
    ControllerPessoa contPes;
    DaoUsuarioPessoa daoUsuPes;
    
    public UsuarioPessoa inserir(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();
        usupesEnt = daoUsuPes.inserir(usupesEnt);
        return usupesEnt;
    }

    public UsuarioPessoa alterar(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();
        usupesEnt = daoUsuPes.alterar(usupesEnt);
        return usupesEnt;
    }

    public List<UsuarioPessoa> listar(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();

        List<UsuarioPessoa> listaUsuPesAux = daoUsuPes.listar(usupesEnt);

        List<UsuarioPessoa> listaUsuPesRetorno = new ArrayList<>();
                
        for(UsuarioPessoa usupes : listaUsuPesAux) {        
            listaUsuPesRetorno.add(buscar(usupes));
        }

        return listaUsuPesRetorno;
    }

    public UsuarioPessoa excluir(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {
        daoUsuPes = new DaoUsuarioPessoa();
        usupesEnt = daoUsuPes.excluir(usupesEnt);
        return usupesEnt;
    }

    public UsuarioPessoa buscar(UsuarioPessoa usupesEnt) throws SQLException, ClassNotFoundException {

        daoUsuPes = new DaoUsuarioPessoa();
        UsuarioPessoa usupesSaida = daoUsuPes.buscar(usupesEnt);

        Usuario usuEnt = new Usuario(usupesSaida.getIdUsuario());
        contUsu = new ControllerUsuario();
        usupesSaida.setUsu(contUsu.buscar(usuEnt));
        
        Pessoa pes = new Pessoa(usupesSaida.getIdPessoa());
        contPes = new ControllerPessoa();
        usupesSaida.setPes(contPes.buscar(pes));

        return usupesEnt;
    }
}
