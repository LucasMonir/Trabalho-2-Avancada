package Models.Profs;
import Models.Pessoa.*;

public class Professor extends Pessoa{
    public Professor(String nome, int cpf, int matricula, String materia, String turno) {
        super(nome, cpf, matricula, materia, turno);
    }
}

