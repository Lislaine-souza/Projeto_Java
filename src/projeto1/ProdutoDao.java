
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
                    "(id_produto,nome_produto,valor_un,qtde_estoque) " +
                    "values (?,?,?,?)";        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1, produto.getId());
        ps.setString(2,produto.getNome_produto() );
        ps.setFloat(3, produto.getValor_un());
        ps.setInt(4, produto.getQtde_estoque());
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
            int id = rs.getInt("id_produto");
            String nome = rs.getString("nome_produto");
            Float valor = rs.getFloat("valor_un");
            int qtidade = rs.getInt("qtde_estoque");
            
                System.out.println("ID: " + id + "\nNome: " + nome + "\nPreço: " + valor + "\nQuantidade em estoque: " 
                +  qtidade);
        }
        ps.close();
        rs.close();
        conexao.close(); 
        
    }
    
    
    
        
   
}

