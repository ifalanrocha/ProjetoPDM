package projetoPDM.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetoPDM.models.beans.RC;
import projetoPDM.utils.ConexaoDb;

public class DaoRC {
    
        
    private final Connection c;
    
    public DaoRC() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public RC excluir(RC rcEnt) throws SQLException{
        String sql = "DELETE FROM dbDispositivosM.rc WHERE idrc = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,rcEnt.getIdrc());
        stmt.execute();
        stmt.close();
        c.close();
        return rcEnt;
    }
    
    public RC buscar(RC rcEnt) throws SQLException{
        String sql = "SELECT r.idrc, r.idusu, r.idalu, r.idbol FROM dbDispositivosM.rc r WHERE idrc = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,rcEnt.getIdrc());
            // executa
            ResultSet rs = stmt.executeQuery();
            RC rcSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                rcSaida = new RC(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return rcSaida;
   }

    public RC inserir(RC rcEnt) throws SQLException{
        String sql = "INSERT INTO dbDispositivosM.rc" + " (idusu, idalu, idbol)" + " VALUES (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,rcEnt.getIdusu());
        stmt.setInt(2,rcEnt.getIdalu());
        stmt.setInt(3,rcEnt.getIdbol());


        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idbol = rs.getInt(1);
            rcEnt.setIdbol(idbol);
        }
        stmt.close();
        return rcEnt;
    }

    public RC alterar(RC rcEnt) throws SQLException{
        String sql = "UPDATE dbDispositivosM.rc SET idusu = ?, idalu = ?, idbol = ? WHERE idrc = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,rcEnt.getIdrc());
        stmt.setInt(2,rcEnt.getIdusu());
        stmt.setInt(3,rcEnt.getIdalu());
        stmt.setInt(4,rcEnt.getIdbol());
        // executa
        stmt.execute();
        stmt.close();
        return rcEnt;
    }

   public List<RC> listar(RC rcEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<RC> rce = new ArrayList<>();
        
        String sql = "SELECT r.idrc FROM dbDispositivosM.rc r";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + rcEnt.getIdrc() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Pessoa
            RC rc = new RC(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4)
            );
            // adiciona o usu à lista de usus
            rce.add(rc);
        }
        
        rs.close();
        stmt.close();
        return rce;
   }
   
   public void excluiridusuario(int idusu)throws SQLException{       
        String sql = "UPDATE dbDispositivosM.rc SET idusu = null WHERE idusu = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,idusu);
        stmt.execute();
        stmt.close();
        c.close();
   }
      public void excluiridaluno(int idalu)throws SQLException{       
        String sql = "UPDATE dbDispositivosM.aluno SET idalu = null WHERE idusu = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,idalu);
        stmt.execute();
        stmt.close();
        c.close();
   }
         public void excluiridboletim(int idbol)throws SQLException{       
        String sql = "UPDATE dbDispositivosM.boletim SET idbol = null WHERE idbol = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,idbol);
        stmt.execute();
        stmt.close();
        c.close();
   }
}