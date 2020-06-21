
package projeto1;

import java.sql.SQLException;


interface Funcao_NF_produtoDao {
    public void adicionar (NF_produto nf_produto) throws SQLException;
    public void imprimir () throws SQLException;
}
