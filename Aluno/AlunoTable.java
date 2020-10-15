package Aluno;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import Pessoa.*;

public class AlunoTable extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nome = new JTextField();
    private JTextField cpf = new JTextField();
    private JTextField materia = new JTextField();
    private JTextField matricula = new JTextField();
    private JTextField turno = new JTextField();
    private PessoaTableModel ptm = new PessoaTableModel();

    public AlunoTable() {
        super("Alunos matriculados: ");
        
        setPreferredSize(new Dimension(400,300));

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("Benevenuto", 1234, 213123, "Teologia", "Noturno")); 
        pessoas.add(new Pessoa("Cleito", 12213, 2112323, "S.I", "Diurno")); 
        
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        cpf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
              char letra = e.getKeyChar();
              if (!((letra >= '0') && (letra <= '9') || (letra == KeyEvent.VK_BACK_SPACE) || (letra == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
              }
            }
        }); 

        matricula.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
              char letra = e.getKeyChar();
              if (!((letra >= '0') && (letra <= '9') || (letra == KeyEvent.VK_BACK_SPACE) || (letra == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
              }
            }
        }); 

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(0, 3));

        JRadioButton noturno = new JRadioButton("Noturno");
        noturno.setActionCommand("Noturno");
        
        JRadioButton matutino = new JRadioButton("Matutino");
        noturno.setActionCommand("Matutino");

        JRadioButton vespertino = new JRadioButton("Vespertino");
        noturno.setActionCommand("Vespertino");
        
        ButtonGroup group = new ButtonGroup();
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
        JTable alunoTable = new JTable();
        alunoTable.setModel(ptm);

        JButton registrar = new JButton("Registrar");
        
        Color cor = registrar.getBackground();

        registrar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int resposta = JOptionPane.showConfirmDialog(null, "Confirmar dados: Nome: "+ nome.getText() + "\n"
                +"CPF: " + cpf.getText() + "\n"
                +"Matricula: " + matricula.getText() + "\n"
                +"Matéria: " + materia.getText() + "\n"
                +"Turno: " + getSelectedButton(group)  + "\n");
                
                if (resposta == 0){
                    ptm.addPessoa(registraPessoas(nome.getText(), Integer.parseInt(cpf.getText()), Integer.parseInt(matricula.getText()), materia.getText(), getSelectedButton(group)));      
                    cleaner();
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!", "Operação cancelada", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                registrar.setBackground(Color.CYAN);
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
                int resposta = JOptionPane.showConfirmDialog(null, "Confirmar dados: Nome: "+ nome.getText() + "\n"
                +"CPF: " + cpf.getText() + "\n"
                +"Matricula: " + matricula.getText() + "\n"
                +"Matéria: " + materia.getText() + "\n"
                +"Turno: " + getSelectedButton(group) + "\n");
                
                if (resposta == 0){
                    ptm.getPessoa(alunoTable.getSelectedRow()).setNome((nome.getText()));
                    ptm.getPessoa(alunoTable.getSelectedRow()).setCpf(Integer.parseInt(cpf.getText()));
                    ptm.getPessoa(alunoTable.getSelectedRow()).setMatricula(Integer.parseInt(matricula.getText()));
                    ptm.getPessoa(alunoTable.getSelectedRow()).setMateria(materia.getText());
                    ptm.getPessoa(alunoTable.getSelectedRow()).setTurno(getSelectedButton(group));
                    ptm.fireTableDataChanged();
                        
                    cleaner();
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!", "Operação cancelada", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                editar.setBackground(Color.CYAN);
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
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                cancelar.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelar.setBackground(cor);
            }
        });

        alunoTable.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Pessoa p = ptm.getPessoa(alunoTable.getSelectedRow());
                nome.setText(p.getNome());
                cpf.setText("" + p.getCpf());
                matricula.setText("" + p.getMatricula());
                materia.setText(p.getMateria());
                turno.setText(getSelectedButton(group));
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

        alunoTable.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				ptm.dellPessoa(alunoTable.getSelectedRow());
                cleaner();
			}

			@Override
            public void keyReleased(KeyEvent e){}
            
        });

        p1.add(registrar);
        p1.add(cancelar);
        p1.add(editar);
        
        getContentPane().add(p1, BorderLayout.NORTH);

        add(new JScrollPane(alunoTable), BorderLayout.CENTER);
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
    }

    public String getSelectedButton(ButtonGroup btg){  
        for (Enumeration<AbstractButton> buttons = btg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public PessoaTableModel getPtm(){
        return ptm;
    }
}
