
package projeto1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;


public class Projeto1 {
   

   
 public static void main(String[] args) throws SQLException, ParseException {
        
   
         try (Connection conexao = new FabricaConexao().estabeleceConexao()) {
         int menu;    
             
            DatabaseMetaData dadosBanco = conexao.getMetaData();
            String bancoNome = dadosBanco.getDatabaseProductName();
            Scanner scan = new Scanner (System.in);
           
            System.out.println("Banco usado: " + bancoNome);
            System.out.println("Driver usado: " + dadosBanco.getDriverName());
            
            System.out.println("CADASTRAR");  
            System.out.println("[1]Cadastrar cliente");
            System.out.println("[2]Cadastrar produto");
            System.out.println("INCLUIR"); 
            System.out.println("[3]Lançar nota fiscal");
            System.out.println("[4]Lançar nota fiscal do produto");
            System.out.println("MOSTRAR A LISTA DE: "); 
            System.out.println("[5]PRODUTOS");
            System.out.println("[6]NOTAS FISCAIS");
            System.out.println("[7]NF PRODUTO");
            System.out.println("[8]PESSOAS");
            System.out.println("EXCLUIR");
            System.out.println("[9]CADASTRO DE PESSOA"); 
            System.out.println("\n[0]SAIR"); 
            
             menu = scan.nextInt();
        scan.nextLine();
        
            switch (menu) {
                case 1:
                    cadastrar();
                    break;
                    
                case 2:
                    cadastrarProduto();
                    break;
                 
                case 3:
                    cadastrarNF();
                    break;
                    
                case 4:
                    cadastrarNFProduto();
                    break;
                    
                case 5:
                    listaProduto();
                    break;
                    
                case 6:
                    listaNF();
                    break;
                
                case 7:
                    listaNFProduto();
                    break;
                
                case 8:
                    listaCadastros();
                    break;
                
                case 9:
                    excluirCadastro();
                    break;
                    
                default:
                    break;
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
    
 public static void cadastrarProduto() throws SQLException{
        System.out.println("Cadastrando Produtos: " ); 
        ProdutoDao DAO = new ProdutoDao();
        Scanner scan = new Scanner (System.in);
        int id;
        String nomeProduto;
        float valorUn;
        int qtdadeEstoque;
                
        System.out.print("Digite um número idendificador:" );
        id = scan.nextInt();
        System.out.print("Digite o nome do produto:" );
        nomeProduto = scan.next();
        System.out.print("Digite o valor do produto:" );
        valorUn = scan.nextFloat();
        System.out.print("Digite a quantidade no estoque:" );
        qtdadeEstoque = scan.nextInt();
        
        Produto produto = new Produto();
        
        produto.setId(id);
        produto.setnomeProduto(nomeProduto);
        produto.setvalorUn(valorUn);
        produto.setqtdadeEstoque(qtdadeEstoque);
        
        
       DAO.adicionar(produto);
      
    }
   
 public static void cadastrarNF() throws SQLException, ParseException{
     
    
      System.out.println("Cadastrando nota fiscal: " ); 
        NFDao DAO = new NFDao();
        Scanner scan = new Scanner (System.in);
        int idNota;
        int idCliente;
        float valorTotal;
        float valor_frete;
        //String s_data;
        LocalDate dataAtual = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();

        
        System.out.print("Digite um número idendificador: " );
        idNota = scan.nextInt();
        System.out.print("Digite o numero identificador do cliente: " );
        idCliente = scan.nextInt();
        System.out.print("Digite o valor total da nota: " );
        valorTotal = scan.nextInt();
        System.out.print("Digite o valor do frete: " );
        valor_frete = scan.nextInt();
       // System.out.print("Digite a data: dd/mm/aaaa ");
      //  s_data = scan.next();
       
        
        
        
        NF nf = new NF();
        
        nf.setId(idNota);
        nf.setidCliente(idCliente);
        nf.setvalorTotal(valorTotal);
        nf.setValor_frete(valor_frete);
        nf.setDate(dataAtual);
        nf.setTime(horaAtual);
        
        
        
       DAO.adicionar(nf);
       
    }
      
 public static void cadastrarNFProduto() throws SQLException{
      System.out.println("Cadastrando nota fiscal do produto: " ); 
        NF_produtoDao DAO = new NF_produtoDao();
        Scanner scan = new Scanner (System.in);
       
        int idNfProduto;
        int idNota;
        int idproduto;
        int qtdadeVendida;
        

        System.out.print("Digite o numero identificador da nota fiscal do produto: " );
        idNfProduto = scan.nextInt();        
        System.out.print("Digite um número idendificador da nota fiscal: " );
        idNota = scan.nextInt();
        System.out.print("Digite o numero identificador do produto: " );
        idproduto = scan.nextInt();
        System.out.print("Digite quantos itens foram vendidos: " );
        qtdadeVendida = scan.nextInt();
        
        NF_produto nf_produto = new NF_produto();
        
        nf_produto.setId(idNfProduto);
        nf_produto.setidNota(idNota);
        nf_produto.setidproduto(idproduto);
        nf_produto.setQtde(qtdadeVendida);
        
       DAO.adicionar(nf_produto);
    } 
 public static void listaCadastros() throws SQLException {
     System.out.println("Lista de cadastro de pessoas: " ); 
     ClienteDao DAO = new ClienteDao();
      
      DAO.imprimir();
 }
 
 public static void listaProduto() throws SQLException{
      System.out.println("Imprimir Produtos: " ); 
      ProdutoDao DAO = new ProdutoDao();
      
      DAO.imprimir();
  }
 public static void listaNF() throws SQLException {
     System.out.println("Imprimir notas fiscais: " ); 
      NFDao DAO = new NFDao();
      
      DAO.imprimir();
 }
 public static void listaNFProduto() throws SQLException {
     System.out.println("Imprimir notas fiscais dos produtos: " ); 
     NF_produtoDao DAO = new NF_produtoDao();
      
      DAO.imprimir();
 }
 public static void excluirCadastro() throws SQLException{
    Scanner scan = new Scanner(System.in);
    System.out.println("Lista de cadastro de pessoas: " ); 
    ClienteDao DAO = new ClienteDao();
    DAO.imprimir(); 
    System.out.println("Digite o ID a ser excluído: ");
    int id = scan.nextInt();
    scan.nextLine();
    DAO.excluir(id);
     
 }   

    
}

