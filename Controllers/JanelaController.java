package Controllers;

import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import Views.Janela;

public class JanelaController {
    public JanelaController(Janela jn){
        jn.setOkAction(new MouseListener(){

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String stringVazia = "";
                String menuSelecionado =  jn.getSelectedMenuItem();
                
                if(!menuSelecionado.equals(stringVazia)){
                    JOptionPane.showMessageDialog(null,"Você selecionou " + menuSelecionado);
                    
                    if(menuSelecionado == "Alunos"){
                        jn.at.setVisible(true);
                    } else {
                        jn.pt.setVisible(true);
                    }
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {}
            
        });

        jn.setContentPanelAction(new MouseListener(){

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {}

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                jn.setNumeroDeAlunos(jn.contadorAluno());
                jn.setNumeroDeProfessores(jn.contadorProfessor());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {}

        });
    }
}
