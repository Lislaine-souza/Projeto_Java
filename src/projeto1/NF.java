
package projeto1;

import java.util.Date;


public class NF {
    int id_nota;
    int id_cliente;
    float valor_total;
    float valor_frete;
    Date data;
    
    
    public int getId() {
        return id_nota;
    }

    public void setId(int id_nota) {
        this.id_nota = id_nota;
    }
    
    public int getId_Cliente() {
        return id_cliente;
    }

    public void setId_Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
    
    public float getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(float valor_frete) {
        this.valor_frete = valor_frete;
    }
    
    public Date getData() {
        return data;
    }

    public void setDate (Date data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id_nota + "id_cliente=" + id_cliente + "valor_frete="+ Float.toString(valor_frete) + 
                        "valor_total=" + Float.toString(valor_total)+ "Data=" + data + "}";   
}
    
}
