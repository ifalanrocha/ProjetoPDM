package projetoPDM.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetoPDM.models.beans.Aluno;
import projetoPDM.utils.ConexaoDb;

public class DaoAluno {
    
    
    private final Connection c;
    
    public DaoAluno() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Aluno excluir(Aluno aluEnt) throws SQLException{
        String sql = "DELETE FROM aluno WHERE idalu = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,aluEnt.getIdalu());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return aluEnt;
    }
    
    public Aluno buscar(Aluno aluEnt) throws SQLException{
        String sql = "SELECT a.idalu, a.nome, a.ra, a.ano, a.idade FROM dbDispositivosM.aluno a WHERE idalu = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,aluEnt.getIdalu());
            // executa
            ResultSet rs = stmt.executeQuery();
            Aluno aluSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                aluSaida = new Aluno(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return aluSaida;
   }

    public Aluno inserir(Aluno aluEnt) throws SQLException{
        String sql = "INSERT INTO dbDispositivosM.aluno" + " (nome, ra, ano, idade)" + " VALUES (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,aluEnt.getNome());
        stmt.setString(2,aluEnt.getRa());
        stmt.setString(3,aluEnt.getAno());
        stmt.setString(4,aluEnt.getIdade());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idalu = rs.getInt(1);
            aluEnt.setIdalu(idalu);
        }
        stmt.close();
        return aluEnt;
    }

    public Aluno alterar(Aluno aluEnt) throws SQLException{
        String sql = "UPDATE dbDispositivosM.aluno SET nome = ?, ra = ?, ano = ?, idade = ? WHERE idalu = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,aluEnt.getNome());
        stmt.setString(2,aluEnt.getRa());
        stmt.setString(3,aluEnt.getAno());
        stmt.setString(4,aluEnt.getIdade());
        stmt.setInt(5,aluEnt.getIdalu());

        // executa
        stmt.execute();
        stmt.close();
        return aluEnt;
    }

   public List<Aluno> listar(Aluno aluEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Aluno> aluu = new ArrayList<>();
        
        String sql = "SELECT a.idalu, a.nome, a.ra, a.ano, a.idade FROM dbDispositivosM.aluno a WHERE nome LIKE ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + aluEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Pessoa
            Aluno alu = new Aluno(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            aluu.add(alu);
        }
        
        rs.close();
        stmt.close();
        return aluu;
   }
}
