
package projetoPDM.utils;


public class TesteConexao {
    
    public static void main(String[] args) {

        System.out.println(ConexaoDb.statusConection());
        ConexaoDb.getConexaoMySQL();
        System.out.println(ConexaoDb.statusConection());
    }   
}
