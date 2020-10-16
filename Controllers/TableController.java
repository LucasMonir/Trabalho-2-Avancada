package Controllers;

import java.awt.event.*;
import javax.swing.*;
import Views.*;
import java.awt.*;
import Models.Pessoa.*;

public class TableController {
    AlunoTable at;
    ProfessorTable pt;

    public TableController(AlunoTable at, ProfessorTable pt) {
        this.at = at;
        this.pt = pt;

        at.setIntFilterAction(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char letra = e.getKeyChar();
                if (!((letra >= '0') && (letra <= '9') || (letra == KeyEvent.VK_BACK_SPACE) || (letra == KeyEvent.VK_DELETE))) {
                    at.getToolkit().beep();
                    e.consume();
                }
            }
        });

        at.setRegistrarAction(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Confirmar dados: Nome: " + at.getNome() + "\n" 
                        + "CPF: " + at.getCpf() + "\n" 
                        + "Matricula: " + at.getMatricula() + "\n" 
                        + "Matéria: " + at.getMateria() + "\n" 
                        + "Turno: " + at.getTurno() + "\n");

                if (resposta == 0) {
                    at.getPtm().addPessoa(at.registraPessoas());
                    at.cleaner();
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!", "Operação cancelada", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                at.getRegistrar().setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                at.getRegistrar().setBackground(at.getCorBotoes());
            }

        });

        at.setEditarAction(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Confirmar dados: Nome: " + at.getNome() + "\n" 
                        + "CPF: " + at.getCpf() + "\n" 
                        + "Matricula: "+ at.getMatricula() + "\n" 
                        + "Matéria: " + at.getMateria() + "\n" 
                        + "Turno: "+ at.getTurno() + "\n");

                if (resposta == 0) {
                    at.getPtm().getPessoa((at.getAlunoTable()).getSelectedRow()).setNome(at.getNome());
                    at.getPtm().getPessoa((at.getAlunoTable()).getSelectedRow()).setCpf(at.getCpf());
                    at.getPtm().getPessoa((at.getAlunoTable()).getSelectedRow()).setMatricula(at.getMatricula());
                    at.getPtm().getPessoa((at.getAlunoTable()).getSelectedRow()).setMateria(at.getMateria());
                    at.getPtm().getPessoa((at.getAlunoTable()).getSelectedRow()).setTurno(at.getTurno());
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!", "Operação cancelada", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                at.getEditar().setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                at.getEditar().setBackground(at.getCorBotoes());
            }

        });

        at.setCancelarAction(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                at.cleaner();
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                at.getCancelar().setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                at.getCancelar().setBackground(at.getCorBotoes());
            }

        });

        at.setAlunoTableSelectAction(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                Pessoa p = at.getPtm().getPessoa(at.getAlunoTable().getSelectedRow());
                at.setNomeField(p.getNome());
                at.setCpfField("" + p.getCpf());
                at.setMatriculaField("" + p.getMatricula());
                at.setMateriaField(p.getMateria());
                at.setTurnoField(p.getTurno());
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

        at.setAlunoTableDeleteAction(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                at.getPtm().dellPessoa(at.getAlunoTable().getSelectedRow());
                at.cleaner();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        pt.setIntFilterAction(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char letra = e.getKeyChar();
                if (!((letra >= '0') && (letra <= '9') || (letra == KeyEvent.VK_BACK_SPACE) || (letra == KeyEvent.VK_DELETE))) {
                    pt.getToolkit().beep();
                    e.consume();
                }
            }
        });

        pt.setRegistrarAction(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Confirmar dados: Nome: " + pt.getNome() + "\n" 
                        + "CPF: " + pt.getCpf() + "\n" 
                        + "Matricula: " + pt.getMatricula() + "\n"
                        + "Matéria: " + pt.getMateria() + "\n"
                        + "Turno: " + pt.getTurno() + "\n");

                if (resposta == 0) {
                    pt.getPtm().addPessoa(pt.registraPessoas());
                    pt.cleaner();
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!", "Operação cancelada", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                pt.getRegistrar().setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                pt.getRegistrar().setBackground(pt.getCorBotoes());
            }

        });

        pt.setEditarAction(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Confirmar dados: Nome: " + pt.getNome() + "\n" 
                        + "CPF: " + pt.getCpf() + "\n" 
                        + "Matricula: " + pt.getMatricula() + "\n" 
                        + "Matéria: " + pt.getMateria() + "\n" 
                        + "Turno: " + pt.getTurno() + "\n");

                if (resposta == 0) {
                    pt.getPtm().getPessoa((pt.getProfessorTable()).getSelectedRow()).setNome(pt.getNome());
                    pt.getPtm().getPessoa((pt.getProfessorTable()).getSelectedRow()).setCpf(pt.getCpf());
                    pt.getPtm().getPessoa((pt.getProfessorTable()).getSelectedRow()).setMatricula(pt.getMatricula());
                    pt.getPtm().getPessoa((pt.getProfessorTable()).getSelectedRow()).setMateria(pt.getMateria());
                    pt.getPtm().getPessoa((pt.getProfessorTable()).getSelectedRow()).setTurno(pt.getTurno());
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!", "Operação cancelada", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                pt.getEditar().setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                pt.getEditar().setBackground(at.getCorBotoes());
            }

        });

        pt.setCancelarAction(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                pt.cleaner();
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {}

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                pt.getCancelar().setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                pt.getCancelar().setBackground(pt.getCorBotoes());
            }

        });

        pt.setProfessorTableSelectAction(new MouseListener() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                Pessoa p = pt.getPtm().getPessoa(pt.getProfessorTable().getSelectedRow());
                pt.setNomeField(p.getNome());
                pt.setCpfField("" + p.getCpf());
                pt.setMatriculaField("" + p.getMatricula());
                pt.setMateriaField(p.getMateria());
                pt.setTurnoField(p.getTurno());
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

        pt.setProfessorTableDeleteAction(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                pt.getPtm().dellPessoa(pt.getProfessorTable().getSelectedRow());
                pt.cleaner();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
}
