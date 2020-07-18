
package projeto1;


public class NF_produto {
    
    int idNfProduto;
    int idNota;
    int idproduto;
    int qtdadeVendida;
    
    
    
    public int getId() {
        return idNfProduto;
    }

    public void setId(int idNfProduto) {
        this.idNfProduto = idNfProduto;
    }
    
    public int getidNota() {
        return idNota;
    }

    public void setidNota(int idNota) {
        this.idNota = idNota;
    }
    
    public int getidproduto() {
        return idproduto;
    }

    public void setidproduto(int idproduto) {
        this.idproduto = idproduto;
    }
    public int getQtde() {
        return qtdadeVendida;
    }

    public void setQtde(int qtdadeVendida) {
        this.qtdadeVendida = qtdadeVendida;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + idNfProduto + "idNota=" + idNota + "idproduto=" + idproduto + "qtdadeVendida=" + qtdadeVendida + "}";   
}
    
}

