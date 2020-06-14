
package projeto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    String CHARSET = "?encoding=ISO8859_1";
    String SERVIDOR = "localhost";
    String PORTA = "3050";
    String USUARIO = "SYSDBA";
    //aqui não esqueçam de alterar a senha conforme o banco de vocês
    String SENHA = "masterkey";
    //não esqueçam de alterar o caminho do banco de dados de vocês
    String ENDERECO_BD = "C:\\dbJava\\DBJAVA.FDB";
    
    public Connection estabeleceConexao() {
        try {
            return DriverManager.getConnection(
                    "jdbc:firebirdsql:" + SERVIDOR + "/" + PORTA
                    + ":" + ENDERECO_BD + CHARSET, USUARIO, SENHA);                        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
    
