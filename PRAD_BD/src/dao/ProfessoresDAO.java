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
import javabeans.Professores;
import javax.swing.JOptionPane;
import jdbc.ConectionFactory;

/**
 *
 * @author Suporte
 */
public class ProfessoresDAO {
    private Connection conecta;
    public ProfessoresDAO(){
        this.conecta = new ConectionFactory().conecta();
    }
    public List<Professores> listarProfessores(){
        try{
            List<Professores> lista = new ArrayList<Professores>();
            String Sql = "select * from professores ORDER BY \"P_ID\" ";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Professores c = new Professores();
                c.setId(rs.getInt("P_ID"));
                c.setNome(rs.getString("P_NOME"));
                c.setEmail(rs.getString("P_EMAIL"));
                c.setTelefone(rs.getString("P_TELEFONE"));
                lista.add(c);
            }
        
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public List<Professores> listarProfessoresPorNome(String nome){
        try{
            List<Professores> lista = new ArrayList<Professores>();
            String Sql="select * from professores where \"P_NOME\" like ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1,"%"+nome+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Professores c = new Professores();
                c.setId(rs.getInt("P_ID"));
                c.setNome(rs.getString("P_NOME"));
                c.setEmail(rs.getString("P_EMAIL"));
                c.setTelefone(rs.getString("P_TELEFONE"));
                lista.add(c);
            }
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public void removerProfessor(Professores obj)
    {
        try{
            String cmdsql = "DELETE FROM professores WHERE \"P_ID\"=?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
    
    public void cadastrarProfessor(Professores obj)
    {
        try{
            String cmdsql = "INSERT INTO professores(\"P_NOME\",\"P_EMAIL\",\"P_TELEFONE\") VALUES (?,?,?)";
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
    public void alterarProfessor(Professores obj)
    {
        try{
            String cmdsql = "update professores set \"P_NOME\"=?,\"P_EMAIL\"=?,\"P_TELEFONE\"=? where \"P_ID\"=?";
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
