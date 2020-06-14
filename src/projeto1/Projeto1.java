
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Projeto1 {
   

   
    public static void main(String[] args) throws SQLException {
        
   
         try (Connection conexao = new FabricaConexao().estabeleceConexao()) {
         int i;    
             
            DatabaseMetaData dadosBanco = conexao.getMetaData();
            String bancoNome = dadosBanco.getDatabaseProductName();
            Scanner scan = new Scanner (System.in);
           
            System.out.println("Banco usado: " + bancoNome);
            System.out.println("Driver usado: " + dadosBanco.getDriverName());
            
            System.out.println("OLÁ!ESCOLHA UMA DAS FUNÇÕES: ");  
            System.out.println("[1]Cadastrar cliente");
            System.out.println("[2]Cadastrar produto");
            System.out.println("[3]Lançar nota fiscal");
            System.out.println("[4]Lançar nota fiscal do produto");
            
            i = scan.nextInt();
           
         if (i == 1){
            cadastrar();  
         } 
         else if (i == 2){
            cadastrar_produto();
         }
         else if (i == 3){
             cadastrar_NF();
            
         }
         else if (i == 4){
             cadastrar_NF_produto();
            
         }
         
         }
    }
    
 public static void cadastrar() throws SQLException{
        System.out.println("Cadastrando: " ); 
        ClienteDao DAO = new ClienteDao();
        Scanner scan = new Scanner (System.in);
        int id;
        String nome;
        String sexo;
        float salario;
        
        System.out.print("Digite um número idendificador:" );
        id = scan.nextInt();
        System.out.print("Digite um nome:" );
        nome = scan.next();
        System.out.print("Digite [f] se for feminino ou [m] se for masculino:" );
        sexo = scan.next();
        System.out.print("Digite o salario:" );
        salario = scan.nextFloat();
        
           
        Cliente cliente = new Cliente();
        
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setSexo(sexo);
        cliente.setSalario(salario);
        
       DAO.adicionar(cliente);
    }
    
 public static void cadastrar_produto() throws SQLException{
        System.out.println("Cadastrando Produtos: " ); 
        ProdutoDao DAO = new ProdutoDao();
        Scanner scan = new Scanner (System.in);
        int id;
        String Nome_produto;
        float valor_un;
        int qtde_estoque;
                
        System.out.print("Digite um número idendificador:" );
        id = scan.nextInt();
        System.out.print("Digite o nome do produto:" );
        Nome_produto = scan.next();
        System.out.print("Digite o valor do produto:" );
        valor_un = scan.nextFloat();
        System.out.print("Digite a quantidade no estoque:" );
        qtde_estoque = scan.nextInt();
        
        Produto produto = new Produto();
        
        produto.setId(id);
        produto.setNome_produto(Nome_produto);
        produto.setValor_un(valor_un);
        produto.setQtde_estoque(qtde_estoque);
        
        
       DAO.adicionar(produto);
    }
   
 public static void cadastrar_NF() throws SQLException{
      System.out.println("Cadastrando nota fiscal: " ); 
        NFDao DAO = new NFDao();
        Scanner scan = new Scanner (System.in);
        int id_nota;
        int id_cliente;
        float valor_total;
        float valor_frete;
                
        System.out.print("Digite um número idendificador: " );
        id_nota = scan.nextInt();
        System.out.print("Digite o numero identificador do cliente: " );
        id_cliente = scan.nextInt();
        System.out.print("Digite o valor total da nota: " );
        valor_total = scan.nextInt();
        System.out.print("Digite o valor do frete: " );
        valor_frete = scan.nextInt();
        
        NF nf = new NF();
        
        nf.setId(id_nota);
        nf.setId_Cliente(id_cliente);
        nf.setValor_total(valor_total);
        nf.setValor_frete(valor_frete);
        
        
       DAO.adicionar(nf);
    }
      
 public static void cadastrar_NF_produto() throws SQLException{
      System.out.println("Cadastrando nota fiscal do produto: " ); 
        NF_produtoDao DAO = new NF_produtoDao();
        Scanner scan = new Scanner (System.in);
       
        int id_NF_produto;
        int id_nota;
        int id_produto;
        int qtde_vendida;
        

        System.out.print("Digite o numero identificador da nota fiscal do produto: " );
        id_NF_produto = scan.nextInt();        
        System.out.print("Digite um número idendificador da nota fiscal: " );
        id_nota = scan.nextInt();
        System.out.print("Digite o numero identificador do produto: " );
        id_produto = scan.nextInt();
        System.out.print("Digite quantos itens foram vendidos: " );
        qtde_vendida = scan.nextInt();
        
        NF_produto nf_produto = new NF_produto();
        
        nf_produto.setId(id_NF_produto);
        nf_produto.setId_nota(id_nota);
        nf_produto.setId_produto(id_produto);
        nf_produto.setQtde(qtde_vendida);
        
       DAO.adicionar(nf_produto);
    } 
    
}