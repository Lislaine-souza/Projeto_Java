
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class NF_produtoDao implements Funcao_NF_produtoDao {
    //prepara para criar uma conexão com o BD
    private Connection conexao;
    private final FabricaConexao criaConexao = new FabricaConexao();
            
    @Override
    public void adicionar (NF_produto nf_produto) throws SQLException {
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "INSERT INTO NF_PRODUTO " +
                    "(idNfProduto,idNota,idproduto,qtdadeVendida) " +
                    "values (?,?,?,?)";        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1,nf_produto.getId());
        ps.setInt(2,nf_produto.getidNota());
        ps.setInt(3,nf_produto.getidproduto());
        ps.setInt(4,nf_produto.getQtde());
        ps.execute();
        ps.close();
        conexao.close();        
    }
    public void imprimir() throws SQLException{
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "SELECT * FROM NF_PRODUTO";
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
       while(rs.next()){
            int id = rs.getInt("idNfProduto");
            int idNota = rs.getInt("idNota");
            int idproduto = rs.getInt("idproduto");
            int qtdade_vendida = rs.getInt("qtdadeVendida");
            
            
                System.out.println(" idNfProduto: " + id + " idNota: " + idNota + " idproduto: " + idproduto + 
                        " Quantidade_vendida: " + qtdade_vendida );
        }
        ps.close();
        rs.close();
        conexao.close(); 
    }
    
    
}
