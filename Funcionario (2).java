public class Funcionario {
    private double salario;
    private long registro;
    private boolean estaAtivo;
    private String nome;
    private String departamento;
    private String rg;

    Funcionario(long registro, String departamento, String nome, String rg, double salario, boolean estaAtivo) {
        this.registro = registro;
        this.departamento = departamento;
        this.nome = nome;
        this.rg = rg;
        this.salario = salario;
        this.estaAtivo = estaAtivo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public long getRegistro() {
        return registro;
    }

    public void setRegistro(long registro) {
        this.registro = registro;
    }

    public boolean Ativo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void bonificar(double salario) {
        setSalario(getSalario() + salario);
    }

}