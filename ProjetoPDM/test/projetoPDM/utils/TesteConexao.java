
package projetoPDM.utils;

import projetoPDM.utils.ConexaoDb;


public class TesteConexao {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(ConexaoDb.statusConection());
        ConexaoDb.getConexaoMySQL();
        System.out.println(ConexaoDb.statusConection());

    }   
}
