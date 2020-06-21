
package projeto1;

import java.sql.SQLException;


interface FuncoesProdutoDAO {
    public void adicionar (Produto produto) throws SQLException;
    public void imprimir()  throws SQLException;
    
}

