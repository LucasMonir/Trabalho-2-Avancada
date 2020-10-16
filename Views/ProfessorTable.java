package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import Models.Pessoa.*;

public class ProfessorTable extends JFrame {
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
    private JTable professorTable = new JTable();

    public ProfessorTable() {
        super("Professores registrados: ");

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("Kleber", 1234, 213123, "Teologia", "Noturno"));
        pessoas.add(new Pessoa("Rogério", 12213, 2112323, "S.I", "Diurno"));

        setLayout(new BorderLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JMenuBar m1Bar = new JMenuBar();
        setJMenuBar(m1Bar);
        JMenu menu = new JMenu("Configurações");
        m1Bar.add(menu);
        menu.setMnemonic(KeyEvent.VK_C);

        ButtonGroup grupoBotao = new ButtonGroup();
        JMenuItem cb1JMenuItem = new JCheckBoxMenuItem("Permissões de Administrador");
        menu.add(cb1JMenuItem);
        grupoBotao.add(cb1JMenuItem);

        JMenuItem newProfessor = new JMenuItem("Novo Professor");
        menu.add(newProfessor);

        JPanel p1 = new JPanel();
        p1.setBorder(new EmptyBorder(20, 20, 20, 20));

        p1.setLayout(new GridLayout(0, 1));

        p1.add(new JLabel("Nome: "));
        p1.add(nome);

        p1.add(new JLabel("CPF: "));
        p1.add(cpf);

        p1.add(new JLabel("Matricula do Profesor: "));
        p1.add(matricula);

        p1.add(new JLabel("Matéria: "));
        p1.add(materia);

        p1.add(new JLabel("Turno: "));
        p1.add(turno);

        ptm.setPessoas(pessoas);
        professorTable.setModel(ptm);

        professorTable.setBorder(new EmptyBorder(20, 20, 20, 20));

        p1.add(registrar);
        p1.add(editar);
        p1.add(cancelar);

        getContentPane().add(p1, BorderLayout.NORTH);

        add(new JScrollPane(professorTable), BorderLayout.CENTER);
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

    public JTable getProfessorTable() {
        return professorTable;
    }

    public void setNomeField(String nome) {
        this.nome.setText(nome);
    }

    public void setCpfField(String cpf) {
        this.cpf.setText(cpf);
    }

    public void setMatriculaField(String matricula) {
        this.matricula.setText(matricula);
    }

    public void setMateriaField(String materia) {
        this.materia.setText(materia);
    }

    public void setTurnoField(String turno) {
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
        return turno.getText();
    }

    public void setIntFilterAction(KeyListener keyPressed) {
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

    public void setProfessorTableSelectAction(MouseListener action) {
        professorTable.addMouseListener(action);
    }

    public void setProfessorTableDeleteAction(KeyListener keyPressed) {
        professorTable.addKeyListener(keyPressed);
    }
}