/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Alunos;
import javax.swing.JOptionPane;
import jdbc.ConectionFactory;

/**
 *
 * @author Suporte
 */
public class AlunosDAO {
    private Connection conecta;
    public AlunosDAO(){
        this.conecta = new ConectionFactory().conecta();
    }
    public List<Alunos> listarAlunos(){
        try{
            List<Alunos> lista = new ArrayList<Alunos>();
            String Sql = "select * from alunos ORDER BY \"A_ID\" ";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Alunos c = new Alunos();
                c.setId(rs.getInt("A_ID"));
                c.setNome(rs.getString("A_NOME"));
                c.setEmail(rs.getString("A_EMAIL"));
                c.setTelefone(rs.getString("A_TELEFONE"));
                lista.add(c);
            }
        
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public int getAluno(String nome){
        try{
            String Sql = "SELECT * FROM alunos WHERE \"A_NOME\" = ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("A_ID");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return -1;
    }
    public List<Alunos> listarAlunosPorNome(String nome){
        try{
            List<Alunos> lista = new ArrayList<Alunos>();
            String Sql="select * from alunos where \"A_NOME\" like ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1,"%"+nome+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Alunos c = new Alunos();
                c.setId(rs.getInt("A_ID"));
                c.setNome(rs.getString("A_NOME"));
                c.setEmail(rs.getString("A_EMAIL"));
                c.setTelefone(rs.getString("A_TELEFONE"));
                lista.add(c);
            }
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public void removerAluno(Alunos obj)
    {
        try{
            String cmdsql = "DELETE FROM alunos WHERE \"A_ID\"=?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
    
    public void cadastrarAluno(Alunos obj)
    {
        try{
            String cmdsql = "INSERT INTO public.alunos(\"A_NOME\",\"A_EMAIL\",\"A_TELEFONE\") VALUES (?,?,?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTelefone());
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
    public void alterarAluno(Alunos obj)
    {
        try{
            String cmdsql = "update alunos set \"A_NOME\"=?,\"A_EMAIL\"=?,\"A_TELEFONE\"=? where \"A_ID\"=?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTelefone());
            stmt.setInt(4, obj.getId());
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
}
