package projetoPDM.models.daos;

import projetoPDM.models.beans.Logradouro;
import projetoPDM.utils.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoLogradouro {
    
    private final Connection c;
    
    public DaoLogradouro() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Logradouro validar(Logradouro logEnt) throws SQLException {
        // cria o select para ser executado no banco de dados 
        String sql = "SELECT l.id, l.idusupes, l.rua, l.numero, l.cep, l.uf FROM dbDispositivosM.logradouro l WHERE id = ? AND senha = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,logEnt.getIdLog());
        stmt.setInt(2,logEnt.getIdUsupes());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        Logradouro LogSaida = null;
        while (rs.next()) {      
            // criando o objeto Usuario
            LogSaida = new Logradouro(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        System.out.println("Usuario: " + LogSaida.toString());
        return LogSaida; 
    }

    public Logradouro excluir(Logradouro logEnt) throws SQLException{
        String sql = "DELETE FROM dbDispositivosM.logradouro WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,logEnt.getIdLog());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return logEnt;
    }
    
    public Logradouro buscar(Logradouro usuEnt) throws SQLException{
        String sql = "SELECT l.id, l.idusupes, l.rua, l.numero, l.cep, l.uf FROM dbDispositivosM.logradouro l WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usuEnt.getIdLog());
            // executa
            ResultSet rs = stmt.executeQuery();
            Logradouro logSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                logSaida = new Logradouro(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return logSaida;
   }

    public Logradouro inserir(Logradouro logEnt) throws SQLException{
        String sql = "INSERT INTO dbDispositivosM.logradouro" + " (idusupes, rua, numero, cep, uf)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,logEnt.getIdLog());
        stmt.setInt(2,logEnt.getIdUsupes());
        stmt.setString(3,logEnt.getRua());
        stmt.setInt(4,logEnt.getIdLog());
        stmt.setString(5,logEnt.getCep());
        stmt.setString(6,logEnt.getUf());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            logEnt.setIdLog(id);
        }
        stmt.close();
        return logEnt;
    }

    public Logradouro alterar(Logradouro logEnt) throws SQLException{
        String sql = "UPDATE dbDispositivosM.logradouro SET idusupes = ?, rua = ?, numero = ?, cep = ?, uf = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,logEnt.getIdLog());
        stmt.setInt(2,logEnt.getIdUsupes());
        stmt.setString(3,logEnt.getRua());
        stmt.setInt(4,logEnt.getIdLog());
        stmt.setString(5,logEnt.getCep());
        stmt.setString(6,logEnt.getUf());

        // executa
        stmt.execute();
        stmt.close();
        return logEnt;
    }

   public List<Logradouro> listar(Logradouro logEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Logradouro> usus = new ArrayList<>();
        
        String sql = "SELECT l.id, l.idusupes, l.rua, l.numero, l.cep, l.uf FROM dbDispositivosM.logradouro l WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + logEnt.getIdLog() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Logradouro log = new Logradouro(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de usus
            usus.add(log);
        }
        
        rs.close();
        stmt.close();
        return usus;
   
   }
}