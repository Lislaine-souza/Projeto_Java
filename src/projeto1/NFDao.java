
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NFDao implements FuncoesNFDAO {
    //prepara para criar uma conexão com o BD
    private Connection conexao;
    private final FabricaConexao criaConexao = new FabricaConexao();
            
    @Override
    public void adicionar (NF nf) throws SQLException {
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "INSERT INTO NF " +
                    "(idNota,idCliente,valorTotal,valor_frete,data,hora) " +
                    "values (?,?,?,?,?,?)";        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1,nf.getId());
        ps.setInt(2,nf.getidCliente());
        ps.setFloat(3,nf.getvalorTotal());
        ps.setFloat(4,nf.getValor_frete());
        ps.setObject(5, nf.getData());
        ps.setObject(6, nf.getTime());
        
        
        ps.execute();
        ps.close();
        conexao.close();        
    }
    public void imprimir() throws SQLException{
        this.conexao = criaConexao.estabeleceConexao(); //conecta com o BD
        String sql = "SELECT * FROM NF";
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
       while(rs.next()){
            int id = rs.getInt("idNota");
            Float valorTotal = rs.getFloat("valorTotal");
            Float valor_frete = rs.getFloat("valor_frete");
            int id_cli = rs.getInt("idCliente");
            Date data = rs.getDate("data");
            Time hora = rs.getTime("hora");
            
                System.out.println(" idNota: " + id + " valorTotal: " + valorTotal + " Valor_frete: " + valor_frete + 
                        " idCliente: " + id_cli + " Data: " + data + " Hora: " + hora);
        }
        ps.close();
        rs.close();
        conexao.close(); 
    }
}
