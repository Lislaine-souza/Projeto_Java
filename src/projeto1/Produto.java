
package projeto1;


    public class Produto {
    int idproduto;
    String nomeProduto;
    float valorUn;
    int qtdadeEstoque;
    
    public int getId() {
        return idproduto;
    }

    public void setId(int idproduto) {
        this.idproduto = idproduto;
    }
    
    public String getnomeProduto() {
        return nomeProduto;
    }

    public void setnomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public float getvalorUn() {
        return valorUn;
    }

    public void setvalorUn(float valorUn) {
        this.valorUn = valorUn;
    }
    
    public int getqtdadeEstoque() {
        return qtdadeEstoque;
    }

    public void setqtdadeEstoque(int qtdadeEstoque) {
        this.qtdadeEstoque = qtdadeEstoque;
    }
    
 @Override
    public String toString() {
        return "Cliente{" + "id=" + idproduto + "nome produto" + nomeProduto + "valorUn=" + Float.toString(valorUn) + "qtdadeEstoque=" + qtdadeEstoque +"}";   
}
    
    
}