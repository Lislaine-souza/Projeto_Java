
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    "(id_nota,id_cliente,valor_total,valor_frete,data) " +
                    "values (?,?,?,?,?)";        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ps.setInt(1,nf.getId());
        ps.setInt(2,nf.getId_Cliente());
        ps.setFloat(3,nf.getValor_total());
        ps.setFloat(4,nf.getValor_frete());
        ps.setObject(5, nf.getData());
        
        
        ps.execute();
        ps.close();
        conexao.close();        
    }
}
