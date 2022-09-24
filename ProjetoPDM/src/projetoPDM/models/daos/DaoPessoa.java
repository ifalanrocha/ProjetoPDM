package projetoPDM.models.daos;

import projetoPDM.utils.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetoPDM.models.beans.Pessoa;


public class DaoPessoa {
    
    private final Connection c;
    
    public DaoPessoa() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Pessoa excluir(Pessoa pesEnt) throws SQLException{
        String sql = "DELETE FROM pessoa WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pesEnt;
    }
    
    public Pessoa buscar(Pessoa pesEnt) throws SQLException{
        String sql = "SELECT p.id, p.nome, p.rg, p.cpf, p.tipo, p.email FROM dbDispositivosM.pessoa p WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pesEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Pessoa pesSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                pesSaida = new Pessoa(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pesSaida;
   }

    public Pessoa inserir(Pessoa pesEnt) throws SQLException{
        String sql = "INSERT INTO dbDispositivosM.pessoa" + " (nome, rg, cpf, email)" + " VALUES (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,pesEnt.getNome());
        stmt.setString(2,pesEnt.getRg());
        stmt.setString(3,pesEnt.getCpf());
        stmt.setString(4,pesEnt.getEmail());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pesEnt.setId(id);
        }
        stmt.close();
        return pesEnt;
    }

    public Pessoa alterar(Pessoa pesEnt) throws SQLException{
        String sql = "UPDATE dbDispositivosM.pessoa SET nome = ?, rg = ?, cpf = ?, email = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,pesEnt.getNome());
        stmt.setString(2,pesEnt.getRg());
        stmt.setString(3,pesEnt.getCpf());
        stmt.setString(4,pesEnt.getEmail());
        stmt.setInt(5,pesEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pesEnt;
    }

   public List<Pessoa> listar(Pessoa pesEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Pessoa> pess = new ArrayList<>();
        
        String sql = "SELECT p.nome FROM dbDispositivosM.pessoa p";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pesEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Pessoa
            Pessoa pes = new Pessoa(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            pess.add(pes);
        }
        
        rs.close();
        stmt.close();
        return pess;
   }
}
