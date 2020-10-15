package Profs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import Pessoa.*;

public class ProfessorTable extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nome = new JTextField();
    private JTextField cpf = new JTextField();
    private JTextField materia = new JTextField();
    private JTextField matricula = new JTextField();
    private JTextField turno = new JTextField();
    private PessoaTableModel ptm = new PessoaTableModel();
    
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
        p1.setBorder(new EmptyBorder( 20, 20, 20 ,20));

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
        JTable professorTable = new JTable();
        professorTable.setModel(ptm);

        professorTable.setBorder(new EmptyBorder( 20, 20, 20 ,20));

        JButton registrar = new JButton("Registrar Professor");
        
        Color cor = registrar.getBackground();

        registrar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ptm.addPessoa(registraPessoas(nome.getText(), Integer.parseInt(cpf.getText()), Integer.parseInt(matricula.getText()), materia.getText(), turno.getText()));      
                cleaner();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                registrar.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registrar.setBackground(cor);
            }
        });

        JButton editar = new JButton("Editar");

        editar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ptm.getPessoa(professorTable.getSelectedRow()).setNome((nome.getText()));
                ptm.getPessoa(professorTable.getSelectedRow()).setCpf(Integer.parseInt(cpf.getText()));
                ptm.getPessoa(professorTable.getSelectedRow()).setMatricula(Integer.parseInt(matricula.getText()));
                ptm.getPessoa(professorTable.getSelectedRow()).setMateria(materia.getText());
                ptm.getPessoa(professorTable.getSelectedRow()).setTurno(turno.getText());
                ptm.fireTableDataChanged();
                    
                cleaner();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                editar.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editar.setBackground(cor);
            }
        });

        JButton cancelar = new JButton("Cancelar");

        cancelar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cleaner();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelar.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelar.setBackground(cor);
            }
        });

        professorTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Pessoa p = ptm.getPessoa(professorTable.getSelectedRow());
                nome.setText(p.getNome());
                cpf.setText("" + p.getCpf());
                matricula.setText("" + p.getMatricula());
                materia.setText(p.getMateria());
                turno.setText(p.getTurno());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

        });

        professorTable.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				ptm.dellPessoa(professorTable.getSelectedRow());
                cleaner();
			}

			@Override
            public void keyReleased(KeyEvent e){}
            
        });

        p1.add(registrar);
        p1.add(editar);
        p1.add(cancelar);

        getContentPane().add(p1, BorderLayout.NORTH);

        add(new JScrollPane(professorTable), BorderLayout.CENTER);
        pack();
        setVisible(false);
    }

    public Pessoa registraPessoas(String nome, int cpf, int matricula, String materia, String turno){
        Pessoa p = new Pessoa(nome, cpf, matricula, materia, turno);
        return p;
    }

    public void cleaner(){
        nome.setText("");
        cpf.setText("");
        materia.setText("");
        matricula.setText("");
        turno.setText("");
    }

    public PessoaTableModel getPtm(){
        return ptm;
    }
}