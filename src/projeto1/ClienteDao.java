
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
        
    public class ClienteDao implements FuncoesClienteDAO {
    //prepara para criar uma conexão com o BD
    private Connection conexao;
    private final FabricaConexao criaConexao = new FabricaConexao();
            
    @Override
    public void adicionar (Cliente cliente) throws SQLException {
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "INSERT INTO CLIENTE " +
                    "(id_cliente,nome,sexo,salario) " +
                    "values (?,?,?,?)";        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        ps.setString(2, cliente.getNome());
        ps.setString(3, cliente.getSexo());
        ps.setFloat(4, cliente.getSalario());
        ps.execute();
        ps.close();
        conexao.close();        
    }
    public void imprimir() throws SQLException{
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "SELECT * FROM CLIENTE";
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
       while(rs.next()){
            int id = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            String sexo = rs.getString("sexo");
            Float salario = rs.getFloat("salario");
           
            
                System.out.println(" código: " + id + " Nome: " + nome + " Sexo: " + sexo + 
                        " Salario: " + salario);
        }
        ps.close();
        rs.close();
        conexao.close(); 
    }
    public void excluir(Cliente cliente) throws SQLException{
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "DELETE FROM CLIENTE WHERE ID=?";
        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        ps.execute();      
        ps.close();
        conexao.close(); 
    }

    
   
 }
    

