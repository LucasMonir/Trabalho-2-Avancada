package Views;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import Models.Pessoa.*;

public class AlunoTable extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nome = new JTextField();
    private JTextField cpf = new JTextField();
    private JTextField materia = new JTextField();
    private JTextField matricula = new JTextField();
    private JTextField turno = new JTextField();
    private PessoaTableModel ptm = new PessoaTableModel();
    private JButton registrar = new JButton("Registrar");
    private JButton editar = new JButton("Editar");
    private JButton cancelar = new JButton("Cancelar");
    private Color corPadrao = registrar.getBackground();
    private ButtonGroup group = new ButtonGroup();
    private JTable alunoTable = new JTable();

    public AlunoTable() {
        super("Alunos matriculados: ");
        setResizable(false);
        setPreferredSize(new Dimension(400, 300));

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("Benevenuto", 1234, 213123, "Teologia", "Noturno"));
        pessoas.add(new Pessoa("Cleito", 12213, 2112323, "S.I", "Diurno"));

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(0, 3));

        JRadioButton noturno = new JRadioButton("Noturno");
        noturno.setActionCommand("Noturno");

        JRadioButton matutino = new JRadioButton("Matutino");
        noturno.setActionCommand("Matutino");

        JRadioButton vespertino = new JRadioButton("Vespertino");
        noturno.setActionCommand("Vespertino");

        group.add(matutino);
        group.add(vespertino);
        group.add(noturno);

        p1.add(new JLabel("Nome: "));
        p1.add(nome);
        p1.add(new JLabel("Turno: "));

        p1.add(new JLabel("CPF (Numérico): "));
        p1.add(cpf);
        p1.add(matutino);

        p1.add(new JLabel("Matricula (Numérico): "));
        p1.add(matricula);
        p1.add(vespertino);

        p1.add(new JLabel("Matéria: "));
        p1.add(materia);
        p1.add(noturno);

        ptm.setPessoas(pessoas);
        alunoTable.setModel(ptm);

        p1.add(registrar);
        p1.add(cancelar);
        p1.add(editar);

        getContentPane().add(p1, BorderLayout.NORTH);

        add(new JScrollPane(alunoTable), BorderLayout.CENTER);
        pack();
        setVisible(false);
    }

    public Pessoa registraPessoas() {
        return new Pessoa(getNome(), getCpf(), getMatricula(), getMateria(), getTurno());
    }

    public void cleaner() {
        nome.setText("");
        cpf.setText("");
        materia.setText("");
        matricula.setText("");
    }

    public String getSelectedButton(ButtonGroup btg) {
        for (Enumeration<AbstractButton> buttons = btg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public JButton getRegistrar() {
        return registrar;
    }

    public JButton getEditar(){
        return editar;
    }

    public JButton getCancelar(){
        return cancelar;
    }

    public Color getCorBotoes() {
        return corPadrao;
    }

    public PessoaTableModel getPtm() {
        return ptm;
    }

    public JTable getAlunoTable() {
        return alunoTable;
    }

    public void setNomeField(String nome){
        this.nome.setText(nome);
    }

    public void setCpfField(String cpf){
        this.cpf.setText(cpf);
    }

    public void setMatriculaField(String matricula){
        this.matricula.setText(matricula);
    }

    public void setMateriaField(String materia){
        this.materia.setText(materia);
    }

    public void setTurnoField(String turno){
        this.turno.setText(turno);
    }

    public String getNome() {
        return nome.getText();
    }

    public int getCpf() {
        return Integer.parseInt(cpf.getText());
    }

    public int getMatricula() {
        return Integer.parseInt(matricula.getText());
    }

    public String getMateria() {
        return materia.getText();
    }

    public String getTurno() {
        return getSelectedButton(group);
    }

    public void setIntFilterAction(KeyListener keyPressed){
        cpf.addKeyListener(keyPressed);
        matricula.addKeyListener(keyPressed);
    }

    public void setRegistrarAction(MouseListener action) {
        registrar.addMouseListener(action);
    }

    public void setEditarAction(MouseListener action) {
        editar.addMouseListener(action);
    }

    public void setCancelarAction(MouseListener action) {
        cancelar.addMouseListener(action);
    }

    public void setAlunoTableSelectAction(MouseListener action) {
        alunoTable.addMouseListener(action);
    }

    public void setAlunoTableDeleteAction(KeyListener keyPressed){
        alunoTable.addKeyListener(keyPressed);
    }
}
