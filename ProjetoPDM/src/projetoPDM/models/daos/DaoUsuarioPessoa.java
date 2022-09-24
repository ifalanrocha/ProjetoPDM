package projetoPDM.models.daos;

import projetoPDM.models.beans.UsuarioPessoa;
import projetoPDM.utils.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetoPDM.models.beans.Pessoa;
import projetoPDM.models.beans.Usuario;


public class DaoUsuarioPessoa {
    
    private final Connection c;
    
    public DaoUsuarioPessoa() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public UsuarioPessoa excluir(UsuarioPessoa usupesEnt) throws SQLException{
        String sql = "DELETE FROM dbDispositivosM.usupes WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usupesEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usupesEnt;
    }
    
    public UsuarioPessoa buscar(UsuarioPessoa usupesEnt) throws SQLException{
        String sql = "SELECT u.id, u.idUsuario, u. FROM dbDispositivosM.usupes u WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usupesEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            UsuarioPessoa usupesSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
            Pessoa novaPessoa = new Pessoa();
            Usuario novoUsuario = new Usuario();
                usupesSaida = new UsuarioPessoa(
                    rs.getInt(1),
                    novoUsuario.getId(),
                    novaPessoa.getId(),
                    rs.getString(4),
                    novoUsuario,
                    novaPessoa);
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usupesSaida;
   }

    public UsuarioPessoa inserir(UsuarioPessoa usuEnt) throws SQLException{
        String sql = "INSERT INTO dbDispositivosM.usupes" + " (id, idusuario, idpessoa, obs)" + " VALUES (?,?,?,?)"; //ver se o @ funciona no lugar do ?
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            Pessoa novaPessoa = new Pessoa();
            Usuario novoUsuario = new Usuario();
        // seta os valores
        stmt.setInt(1,usuEnt.getId());
        stmt.setInt(2,usuEnt.getIdUsuario());
        stmt.setInt(3,usuEnt.getIdPessoa());
        stmt.setString(4,usuEnt.getObs());


        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usuEnt.setId(id);
        }
        stmt.close();
        return usuEnt;
    }

    public UsuarioPessoa alterar(UsuarioPessoa usuEnt) throws SQLException{
        String sql = "UPDATE dbDispositivosM.usupes SET id = ?, idusuario = ?, idpessoa = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuEnt.getId());
        stmt.setInt(2,usuEnt.getIdUsuario());
        stmt.setInt(3,usuEnt.getIdPessoa());
        stmt.setString(4,usuEnt.getObs());


        // executa
        stmt.execute();
        stmt.close();
        return usuEnt;
    }

   public List<UsuarioPessoa> listar(UsuarioPessoa usupesEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<UsuarioPessoa> usupess = new ArrayList<>();
        
        String sql = "SELECT u.id, u.idusuario, u.idpessoa, u.obs FROM dbDispositivosM.usupes u WHERE login like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usupesEnt.getId() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Pessoa novaPessoa = new Pessoa();
            Usuario novoUsuario = new Usuario();
            UsuarioPessoa usupes = new UsuarioPessoa(
                    rs.getInt(1),
                    novoUsuario.getId(),
                    novaPessoa.getId(),
                    rs.getString(4),
                    novoUsuario,
                    novaPessoa);
            // adiciona o usu à lista de usus
            usupess.add(usupes);
        }
        
        rs.close();
        stmt.close();
        return usupess;
   
   }
}