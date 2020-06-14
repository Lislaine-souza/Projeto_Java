
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NFDao implements FuncoesNFDAO {
    //prepara para criar uma conexão com o BD
    private Connection conexao;
    private final FabricaConexao criaConexao = new FabricaConexao();
            
    @Override
    public void adicionar (NF nf) throws SQLException {
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "INSERT INTO NF " +
                    "(id_nota,id_cliente,valor_total,valor_frete) " +
                    "values (?,?,?,?)";        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1,nf.getId());
        ps.setInt(2,nf.getId_Cliente());
        ps.setFloat(3,nf.getValor_total());
        ps.setFloat(4,nf.getValor_frete());
        ps.execute();
        ps.close();
        conexao.close();        
    }
}
