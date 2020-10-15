package Pessoa;

public class Pessoa {
    private String nome;
    private int cpf;
    private int matricula;
    private String materia;
    private String turno;

    public Pessoa(String nome, int cpf, int matricula, String materia, String turno) {
        setNome(nome);
        setCpf(cpf);
        setMateria(materia);
        setMatricula(matricula);
        setTurno(turno);
    }

    public String getNome() {
        return nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
