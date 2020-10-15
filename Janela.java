import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import Profs.ProfessorTable;
import Aluno.AlunoTable;
import java.awt.image.BufferedImage;
import java.io.File;

class Janela extends JFrame{
    private static final long serialVersionUID = 1L;

    static AlunoTable at = new AlunoTable();
    static ProfessorTable pt = new ProfessorTable();
    
    Janela(){



        //ADICIONAR PADDING

        super("Gerenciamento de Alunos e Professores");
        
        setPreferredSize(new Dimension(400,300));
        setResizable(false);

        String[] opcoesMenu = {"", "Alunos", "Professores"};
        JComboBox<String> selecaoMenu = new JComboBox<>(opcoesMenu);
        selecaoMenu.setSelectedIndex(0);
        setLayout(new GridLayout(0, 1));
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(0, 1));

        JLabel l1 = new JLabel("Número de alunos registrados: " + contadorAluno());
        JLabel l2 = new JLabel("Número de professores registrados: " + contadorProfessor());
        
        p1.add(l1);
        p1.add(l2);
        
        p1.add(new JLabel("Selecione opção a ser exibida: "));

        p1.add(selecaoMenu);
        
        JButton ok = new JButton("OK");
        
        ok.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String stringVazia = "";
                String menuSelecionado = (String) selecaoMenu.getSelectedItem();
                
                if(!menuSelecionado.equals(stringVazia)){
                    JOptionPane.showMessageDialog(null,"Você selecionou " + menuSelecionado);
                    
                    if(menuSelecionado == "Alunos"){
                        at.setVisible(true);
                    } else {
                        pt.setVisible(true);
                    }
                }
                
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

        p1.add(ok);

        try {
            BufferedImage myPicture = ImageIO.read(new File("unisul.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            add(picLabel);
        } catch (Exception e) {
            System.out.println(e + "FILE NOT FOUND!!!!");
        }

        getContentPane().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                l1.setText("Número de alunos registrados: " + contadorAluno());
                l2.setText("Número de professores registrados: " + contadorProfessor());
            }

            @Override
            public void mouseExited(MouseEvent e) {}
        }); 

        getContentPane().add(p1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);    
    }

    public static int contadorAluno(){
        int a = 0;
        for (Object o : at.getPtm().getLista()) {
            a++;
        }
        return a;
    }
    
    public static int contadorProfessor(){
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