
package projeto1;

import java.sql.SQLException;


interface FuncoesNFDAO {
     public void adicionar (NF nf) throws SQLException;
     public void imprimir () throws SQLException;    
}
