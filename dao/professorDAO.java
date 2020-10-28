package dao;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;

import database.DBConnection;
import Models.professor.*;
import Models.Pessoa.*;
import Models.Profs.Professor;

public class professorDAO {
    private Professor professor;
    private int Position;
    private List <Professor> ProfessorList;

    public  professorDAO() {
        Position = 0;
        ProfessorList = new ArrayList<Professor>();
        create();

    }

    private void create() {
        try {
            Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query =
				"create table if not exists professor ( " +
                "nome VARCHAR (50), " +
                "cpf INTEGER, " +
                "matricula INTEGER, " +
                "materia VARCHAR(50), " +
                "turno VARCHAR(50), " +
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void load(String filter) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();

			String query = "select * from professor";
			if (filter.length() > 0) {
				query += " where " + filter;
			}
			System.out.println("QUERY: " + query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Professor prof= new Professor();
				prof.setMatricula(rs.getInt("matricula"));
				prof.setNome(rs.getString("nome"));
                prof.setCpf(rs.getInt("cpf"));
                prof.setMateria(rs.getString("materia"));
                prof.setTurno(rs.getString("turno"));
				ProfessorList.add(prof);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void insert(Professor prof) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();

			String query = "insert into professor (cpf, nome, matricula, turno, materia) " + "values ("
					+ prof.getMatricula() + ",'" + prof.getNome() + "', " + prof.getCpf() + prof.getMateria() + "', "+ prof.getTurno() " )";
			System.out.println("QUERY: " + query);
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.clear();
    }
    
    public void update(Professor prof) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();

			String query = "update professor set " +
						"nome = '" + prof.getNome() + "', " +
                        "matricula = " + prof.getMatricula() + " " +
                        "materia = " + prof.getMateria()+ " " +
                        "turno = " + prof.getMatricula() + " " +
						"where cpf = " + prof.getCpf();
			System.out.println("QUERY: " + query);
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.clear();
    }
    public void delete(Professor professor) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query = "delete from professor where cpf = " + professor.getCpf();
			System.out.println("QUERY: " + query);
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.clear();
    }
    public void clear() {
		Position = 0;
		ProfessorList.clear();
	}

	public void reset() {
		Position = 0;
	}

	public int size() {
		return ProfessorList.size();
	}

	public Professor next() {
		Professor prof = null;
		if (Position < ProfessorList.size()) {
			prof = ProfessorList.get(Position);
			Position++;
		}
		return prof;
	}
}

        }
    }
}
