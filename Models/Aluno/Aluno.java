package Models.Aluno;
import Models.Pessoa.*;

public class Aluno extends Pessoa{
    public Aluno(String nome, int cpf, int matricula, String materia, String turno) {
        super(nome, cpf, matricula, materia, turno);
    }
}
