
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NF_produtoDao implements Funcao_NF_produtoDao {
    //prepara para criar uma conexão com o BD
    private Connection conexao;
    private final FabricaConexao criaConexao = new FabricaConexao();
            
    @Override
    public void adicionar (NF_produto nf_produto) throws SQLException {
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "INSERT INTO NF_PRODUTO " +
                    "(id_nf_produto,id_nota,id_produto,qtde_vendida) " +
                    "values (?,?,?,?)";        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1,nf_produto.getId());
        ps.setInt(2,nf_produto.getId_nota());
        ps.setInt(3,nf_produto.getId_produto());
        ps.setInt(4,nf_produto.getQtde());
        ps.execute();
        ps.close();
        conexao.close();        
    }
    
    
    
}
