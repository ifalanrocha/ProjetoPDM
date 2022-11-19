package projetoPDM.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetoPDM.models.beans.Usuario;
import projetoPDM.utils.ConexaoDb;

public class DaoUsuario {
    
    private final Connection c;
    
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Usuario validar(Usuario usuEnt) throws SQLException {
        String sql = "SELECT u.idusu, u.login, u.senha, u.status, u.tipo FROM dbDispositivosM.usuario u WHERE login = ? AND senha = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        ResultSet rs = stmt.executeQuery();
        Usuario usuSaida = new Usuario();
        while (rs.next()) {      
            usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
        }
        stmt.close();
        return usuSaida; 
    }

    public Usuario excluir(Usuario usuEnt) throws SQLException{
        String sql = "DELETE FROM dbDispositivosM.usuario WHERE idusu = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,usuEnt.getIdusu());
        stmt.execute();
        stmt.close();
        c.close();
        return usuEnt;
    }
    
    public Usuario buscar(Usuario usuEnt) throws SQLException{
        String sql = "SELECT u.idusu, u.login, u.senha, u.status, u.tipo FROM dbDispositivosM.usuario u WHERE idusu = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1,usuEnt.getIdusu());
            ResultSet rs = stmt.executeQuery();
            Usuario usuSaida = null;
            while (rs.next()) {      
                usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            }
            stmt.close();
        return usuSaida;
   }

    public Usuario inserir(Usuario usuEnt) throws SQLException{
        String sql = "INSERT INTO dbDispositivosM.usuario " + " (login, senha, status, tipo) " + " VALUES (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        stmt.setString(3,usuEnt.getStatus());
        stmt.setString(4,usuEnt.getTipo());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idusu = rs.getInt(1);
            usuEnt.setIdusu(idusu);
        }
        stmt.close();
        return usuEnt;
    }

    public Usuario alterar(Usuario usuEnt) throws SQLException{
        String sql = "UPDATE dbDispositivosM.usuario SET login = ?, senha = ?, status = ?, tipo = ? WHERE idusu = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1,usuEnt.getLogin());
        stmt.setString(2,usuEnt.getSenha());
        stmt.setString(3,usuEnt.getStatus());
        stmt.setString(4,usuEnt.getTipo());
        stmt.setInt(5,usuEnt.getIdusu());
        stmt.execute();
        stmt.close();
        return usuEnt;
    }

   public List<Usuario> listar(Usuario usuEnt) throws SQLException{
        List<Usuario> usus = new ArrayList<>();
        String sql = "SELECT u.idusu, u.login, u.senha, u.status, u.tipo FROM dbDispositivosM.usuario u WHERE login LIKE ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,"%" + usuEnt.getLogin() + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {      
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            usus.add(usu);
        }
        rs.close();
        stmt.close();
        return usus;
   }
}
