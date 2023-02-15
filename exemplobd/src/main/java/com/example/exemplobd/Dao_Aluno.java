package com.example.exemplobd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao_Aluno{

    public void adiciona(Aluno c) throws SQLException{
        String sql = SQL_Constantes.INSERT;

        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, null);
            stmt.setString(2, c.getNome());
            stmt.setFloat(3, c.getNota1());
            stmt.setFloat(4, c.getNota2());
            stmt.setFloat(5, c.getNota3());
            stmt.setFloat(6, c.getMedia());
            stmt.execute();
        }
    }

    public List<Aluno> pesquisaTodos() throws SQLException{
        List<Aluno> alunos = new ArrayList();
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_Constantes.SEARCH);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluno a = new Aluno();

                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
                a.setNota1(rs.getFloat("nota1"));
                a.setNota2(rs.getFloat("nota2"));
                a.setNota3(rs.getFloat("nota3"));
                a.setMedia(rs.getFloat("media"));
                alunos.add(a);
            }
        }
        return alunos;
    }

    public void altera(Aluno c) throws SQLException{
        String sql = SQL_Constantes.UPDATE;
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setFloat(1, c.getNota1());
            stmt.setFloat(2, c.getNota2());
            stmt.setFloat(3, c.getNota3());
            stmt.setFloat(4, c.getMedia());
            stmt.setInt(5, c.getMatricula());
            stmt.execute();
        }
    }

    public void remove(Aluno c) throws SQLException{
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_Constantes.REMOVE)){
            stmt.setInt(1, c.getMatricula());
            stmt.execute();
        }
    }

    public boolean pesquisa(Aluno c) throws SQLException{
        List<Aluno> todos = pesquisaTodos();

        for (Object cc : todos) {
            if (((Aluno)cc).equals(c)) {
                return true;
            }
        }
        return false;
    }

    public Aluno pesquisaAluno(String nome) throws SQLException{
        List<Aluno> alunos = new Dao_Aluno().pesquisaTodos();

        for (Aluno c : alunos) {
            if (c.getNome().equals(nome))
                return c;
        }
        return null;
    }

    public int buscaId(String nome) throws SQLException {
        return pesquisaAluno(nome).getMatricula();
    }

    public int buscaId(Aluno a) throws SQLException {
            List<Aluno> todos = pesquisaTodos();

            for (Object cc : todos) {
                if (((Aluno)cc).equals(a)) {
                    return a.getMatricula();
                }
            }
            return -1;
        }
}
