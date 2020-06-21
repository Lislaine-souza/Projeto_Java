
package projeto1;


    public class Produto {
    int id_produto;
    String Nome_produto;
    float valor_un;
    int qtde_estoque;
    
    public int getId() {
        return id_produto;
    }

    public void setId(int id_produto) {
        this.id_produto = id_produto;
    }
    
    public String getNome_produto() {
        return Nome_produto;
    }

    public void setNome_produto(String Nome_produto) {
        this.Nome_produto = Nome_produto;
    }
    
    public float getValor_un() {
        return valor_un;
    }

    public void setValor_un(float valor_un) {
        this.valor_un = valor_un;
    }
    
    public int getQtde_estoque() {
        return qtde_estoque;
    }

    public void setQtde_estoque(int qtde_estoque) {
        this.qtde_estoque = qtde_estoque;
    }
    
 @Override
    public String toString() {
        return "Cliente{" + "id=" + id_produto + "nome produto" + Nome_produto + "valor_un=" + Float.toString(valor_un) + "qtde_estoque=" + qtde_estoque +"}";   
}
    
    
}