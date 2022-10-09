package projetoPDM.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetoPDM.models.beans.Boletim;
import projetoPDM.utils.ConexaoDb;

public class DaoBoletim {
        
    private final Connection c;
    
    public DaoBoletim() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Boletim excluir(Boletim bolEnt) throws SQLException{
        String sql = "DELETE FROM boletim WHERE idbol = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,bolEnt.getIdbol());
        stmt.execute();
        stmt.close();
        c.close();
        return bolEnt;
    }
    
    public Boletim buscar(Boletim bolEnt) throws SQLException{
        String sql = "SELECT b.idbol, b.semestre, b.nmat, b.npor, b.ngeo FROM dbDispositivosM.boletim b WHERE idbol = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1,bolEnt.getIdbol());
            ResultSet rs = stmt.executeQuery();
            Boletim bolSaida = null;
            while (rs.next()) {      
                bolSaida = new Boletim(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5));
            }
            stmt.close();
        return bolSaida;
   }

    public Boletim inserir(Boletim bolEnt) throws SQLException{
        String sql = "INSERT INTO dbDispositivosM.boletim" + " (semestre, nmat, npor, ngeo)" + " VALUES (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1,bolEnt.getSemestre());
        stmt.setInt(2,bolEnt.getNmat());
        stmt.setInt(3,bolEnt.getNpor());
        stmt.setInt(4,bolEnt.getNgeo());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idbol = rs.getInt(1);
            bolEnt.setIdbol(idbol);
        }
        stmt.close();
        return bolEnt;
    }

    public Boletim alterar(Boletim bolEnt) throws SQLException{
        String sql = "UPDATE dbDispositivosM.boletim SET semestre = ?, nmat = ?, npor = ?, ngeo = ? WHERE idbol = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,bolEnt.getSemestre());
        stmt.setInt(2,bolEnt.getNmat());
        stmt.setInt(3,bolEnt.getNpor());
        stmt.setInt(4,bolEnt.getNgeo());
        stmt.setInt(5,bolEnt.getIdbol());
        stmt.execute();
        stmt.close();
        return bolEnt;
    }

   public List<Boletim> listar(Boletim bolEnt) throws SQLException{
        List<Boletim> bole = new ArrayList<>();
        String sql = "SELECT b.idbol FROM dbDispositivosM.boletim b";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,"%" + bolEnt.getIdbol() + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {      
            Boletim bol = new Boletim(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5)
            );
            bole.add(bol);
        }
        rs.close();
        stmt.close();
        return bole;
   }
}
