package dao;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;

import database.DBConnection;
import Models.Pessoa.*;

public class pessoaDAO {
    private Pessoa pessoa;
    private int Position;
    private List <Pessoa> PessoaList;

    public  pessoaDAO() {
        Position = 0;
        PessoaList = new ArrayList<Pessoa>();
        create();

    }

    private void create() {
        try {
            Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query =
				"create table if not exists pessoa ( " +
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

			String query = "select * from pessoa";
			if (filter.length() > 0) {
				query += " where " + filter;
			}
			System.out.println("QUERY: " + query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setMatricula(rs.getInt("matricula"));
				pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getInt("cpf"));
                pessoa.setMateria(rs.getString("materia"));
                pessoa.setTurno(rs.getString("turno"));
				PessoaList.add(pessoa);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void insert(Pessoa pessoa) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();

			String query = "insert into pessoa (cpf, nome, matricula, turno, materia) " + "values ("
					+ pessoa.getMatricula() + ",'" + pessoa.getNome() + "', " + pessoa.getCpf() + pessoa.getMateria() + "', "+ pessoa.getTurno() " )";
			System.out.println("QUERY: " + query);
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.clear();
    }
    
    public void update(Pessoa pessoa) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();

			String query = "update pessoa set " +
						"nome = '" + pessoa.getNome() + "', " +
                        "matricula = " + pessoa.getMatricula() + " " +
                        "materia = " + pessoa.getMateria()+ " " +
                        "turno = " + pessoa.getMatricula() + " " +
						"where cpf = " + pessoa.getCpf();
			System.out.println("QUERY: " + query);
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.clear();
    }
    public void delete(Pessoa pessoa) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query = "delete from pessoa where cpf = " + pessoa.getCpf();
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
		PessoaList.clear();
	}

	public void reset() {
		Position = 0;
	}

	public int size() {
		return PessoaList.size();
	}

	public Pessoa next() {
		Pessoa pessoa = null;
		if (Position < PessoaList.size()) {
			pessoa = PessoaList.get(Position);
			Position++;
		}
		return pessoa;
	}
}

        }
    }
}
