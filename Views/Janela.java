package Views;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import Controllers.TableController;

import java.awt.image.BufferedImage;
import java.io.File;

public class Janela extends JFrame {
    private static final long serialVersionUID = 1L;

    public AlunoTable at = new AlunoTable();
    public ProfessorTable pt = new ProfessorTable();
    public TableController tc = new TableController(at, pt);
    private String[] opcoesMenu = { "", "Alunos", "Professores" };
    private JComboBox<String> selecaoMenu = new JComboBox<>(opcoesMenu);
    private JLabel numeroDeAulos = new JLabel("Número de alunos registrados: " + contadorAluno());
    private JLabel numeroDeProfessores = new JLabel("Número de professores registrados: " + contadorProfessor());
    private JButton ok = new JButton("OK");

    public Janela() {
        super("Gerenciamento de Alunos e Professores");

        setPreferredSize(new Dimension(400, 300));
        setResizable(false);

        
        selecaoMenu.setSelectedIndex(0);
        setLayout(new GridLayout(0, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(0, 1));
        
        p1.add(numeroDeAulos);
        p1.add(numeroDeProfessores);
        p1.add(new JLabel("Selecione opção a ser exibida: "));
        p1.add(selecaoMenu);
        p1.add(ok);

        try {
            BufferedImage myPicture = ImageIO.read(new File("unisul.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            add(picLabel);
        } catch (Exception e) {
            System.out.println(e + "FILE NOT FOUND!!!!");
        }

        getContentPane().add(p1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String getSelectedMenuItem() {
        return (String) selecaoMenu.getSelectedItem();
    }

    public void setOkAction(MouseListener action) {
        ok.addMouseListener(action);
    }

    public void setContentPanelAction(MouseListener action) {
        getContentPane().addMouseListener(action);
    }

    public void setNumeroDeAlunos(int numero) {
        numeroDeAulos.setText("Número de alunos registrados: " + numero);
    }

    public void setNumeroDeProfessores(int numero) {
        numeroDeProfessores.setText("Número de professores registrados: " + numero);
    }

    public int contadorAluno() {
        int a = 0;
        for (Object o : at.getPtm().getLista()) {
            a++;
        }
        return a;
    }

    public int contadorProfessor() {
        int a = 0;
        for (Object o : pt.getPtm().getLista()) {
            a++;
        }
        return a;
    }

    public static void main(String args[]) {
        new Janela();
    }
}