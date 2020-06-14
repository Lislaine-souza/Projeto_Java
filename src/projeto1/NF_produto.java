
package projeto1;


public class NF_produto {
    
    int id_nf_produto;
    int id_nota;
    int id_produto;
    int qtde_vendida;
    
    
    
    public int getId() {
        return id_nf_produto;
    }

    public void setId(int id_nf_produto) {
        this.id_nf_produto = id_nf_produto;
    }
    
    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }
    
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    public int getQtde() {
        return qtde_vendida;
    }

    public void setQtde(int qtde_vendida) {
        this.qtde_vendida = qtde_vendida;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id_nf_produto + "id_nota=" + id_nota + "id_produto=" + id_produto + "Qtde_vendida=" + qtde_vendida + "}";   
}
    
}

