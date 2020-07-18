
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

    public class ProdutoDao implements FuncoesProdutoDAO {
    //prepara para criar uma conexão com o BD
    private Connection conexao;
    private final FabricaConexao criaConexao = new FabricaConexao();
            
    @Override
    public void adicionar (Produto produto) throws SQLException {
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "INSERT INTO PRODUTO " +
                    "(idproduto,nomeProduto,valorUn,qtdadeEstoque) " +
                    "values (?,?,?,?)";        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1, produto.getId());
        ps.setString(2,produto.getnomeProduto() );
        ps.setFloat(3, produto.getvalorUn());
        ps.setInt(4, produto.getqtdadeEstoque());
        ps.execute();
        ps.close();
        conexao.close();        
    }
    
    public void imprimir () throws SQLException {
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        
        String sql = "SELECT * FROM PRODUTO ";
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
            while(rs.next()){
            int id = rs.getInt("idproduto");
            String nome = rs.getString("nomeProduto");
            Float valor = rs.getFloat("valorUn");
            int qtidade = rs.getInt("qtdadeEstoque");
            
                System.out.println("ID: " + id + "\nNome: " + nome + "\nPreço: " + valor + "\nQuantidade em estoque: " 
                +  qtidade);
        }
        ps.close();
        rs.close();
        conexao.close(); 
        
    }
    
    
    
        
   
}

