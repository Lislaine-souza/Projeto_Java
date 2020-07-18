
package projeto1;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class NF {
    int idNota;
    int idCliente;
    float valorTotal;
    float valor_frete;
    LocalDate data;
    LocalTime hora;
    
    
    public int getId() {
        return idNota;
    }

    public void setId(int idNota) {
        this.idNota = idNota;
    }
    
    public int getidCliente() {
        return idCliente;
    }

    public void setidCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public float getvalorTotal() {
        return valorTotal;
    }

    public void setvalorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public float getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(float valor_frete) {
        this.valor_frete = valor_frete;
    }
    
    public LocalDate getData() {
        return data;
    }

    public void setDate (LocalDate data) {
        this.data = data;
    }
    
    public LocalTime getTime() {
        return hora;
    }

    public void setTime (LocalTime hora) {
        this.hora = hora;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + idNota + "idCliente=" + idCliente + "valor_frete="+ Float.toString(valor_frete) + 
                        "valorTotal=" + Float.toString(valorTotal)+ "Data=" + data + "hora=" + hora +"}";   
}
    
}
