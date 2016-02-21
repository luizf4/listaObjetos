package model;

/**
 * @author Luiz Fernando de Souza Matricula: 225272 OD Prof.ª Silvia Brunini ADS
 * - Polo Sorocaba
 */
public class Funcionario {

    private String nome;
    private int matricula;
    private double salario;

    public Funcionario() {

        this.nome = "";
        this.matricula = 0;
        this.salario = 0;

    }

    public Funcionario(String nome, int matricula, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome = " + nome + ", matricula= " + matricula
                + ", salario= " + salario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.matricula;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

}
