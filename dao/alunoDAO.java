package dao;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;

import database.DBConnection;
import Models.Aluno.*;
import Models.Pessoa.*;

public class alunoDAO {
    private Aluno aluno;
    private int Position;
    private List <Aluno> AlunoList;

    public  alunoDAO() {
        Position = 0;
        AlunoList = new ArrayList<Aluno>();
        create();

    }

    private void create() {
        try {
            Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query =
				"create table if not exists aluno ( " +
                "nome VARCHAR (50), " +
                "cpf INTEGER, " +
                "matricula INTEGER, " +
                "materia VARCHAR(50), " +
                "turno VARCHAR(50)";
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void load(String filter) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();

			String query = "select * from aluno";
			if (filter.length() > 0) {
				query += " where " + filter;
			}
			System.out.println("QUERY: " + query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Aluno alun = new Aluno();
				alun.setMatricula(rs.getInt("matricula"));
				alun.setNome(rs.getString("nome"));
                alun.setCpf(rs.getInt("cpf"));
                alun.setMateria(rs.getString("materia"));
                alun.setTurno(rs.getString("turno"));
				AlunoList.add(alun);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void insert(Aluno alun) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query = "insert into aluno (cpf, nome, matricula, turno, materia) " + "values ("
					+ alun.getMatricula() + ",'" + alun.getNome() + "', " + alun.getCpf() + alun.getMateria() + "', "+ alun.getTurno() + ")";
			System.out.println("QUERY: " + query);
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.clear();
    }
    
    public void update(Aluno alun) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();

			String query = "update aluno set " +
						"nome = '" + alun.getNome() + "', " +
                        "matricula = " + alun.getMatricula() + " " +
                        "materia = " + alun.getMateria()+ " " +
                        "turno = " + alun.getMatricula() + " " +
						"where cpf = " + alun.getCpf();
			System.out.println("QUERY: " + query);
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.clear();
    }
    public void delete(Aluno alun) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query = "delete from aluno where cpf = " + alun.getCpf();
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
		AlunoList.clear();
	}

	public void reset() {
		Position = 0;
	}

	public int size() {
		return AlunoList.size();
	}

	public Aluno next() {
		Aluno alun = null;
		if (Position < AlunoList.size()) {
			alun = AlunoList.get(Position);
			Position++;
		}
		return alun;
	}

}
