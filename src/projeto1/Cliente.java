
package projeto1;


public class Cliente {
    private int idCliente;
    private String nome;
    private String sexo;
    private float salario;
    
    public int getId() {
        return idCliente;
    }

    public void setId(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    @Override
    public String toString() {
        return "Cliente{" + "id=" + idCliente + "nome=" + nome + "sexo=" + sexo + "salario=" + Float.toString (salario) +"}";
  
}
}


