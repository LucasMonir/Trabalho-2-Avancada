package Pessoa;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class PessoaTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas.clear();
        this.pessoas.addAll(pessoas);
        
        fireTableDataChanged();
    }

    public void addPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
        fireTableDataChanged();
    }

    public void dellPessoa(int index){
        pessoas.remove(index);
        fireTableDataChanged();
    }

    public Pessoa getPessoa(int index){
        return pessoas.get(index);
    }

    public ArrayList<Pessoa> getLista(){
        return this.pessoas;
    }

    @Override
    public int getRowCount() {
        return pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nome";
            case 1:
                return "Cpf";
            case 2:
                return "Matrícula";
            case 3:
                return "Matéria";
            case 4:
                return "Turno";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa p = pessoas.get(rowIndex);
        switch (columnIndex){
            case 0:
                return p.getNome();
            case 1: 
                return p.getCpf();
            case 2:
                return p.getMatricula();
            case 3:
                return p.getMateria();
            case 4:
                return p.getTurno();
            default: 
                return null;
        }
    }

    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1: 
                return Integer.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return String.class; 
            default: 
                return null;
        }
    }
}
