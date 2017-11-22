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
import javabeans.Matriculas;
import javax.swing.JOptionPane;
import jdbc.ConectionFactory;

/**
 *
 * @author Suporte
 */
public class MatriculasDAO {
    private Connection conecta;
    public MatriculasDAO(){
        this.conecta = new ConectionFactory().conecta();
    }
    public int getProfessor(String nome){
        try{
            String Sql = "SELECT * FROM professores WHERE \"P_NOME\" = ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("P_ID");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return -1;
    }
    
    public List<Matriculas> listarMatriculas(){
        try{
            List<Matriculas> lista = new ArrayList<Matriculas>();
            String Sql = "select * from matricula ORDER BY \"A_ID\" ";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Matriculas c = new Matriculas();
                c.setDid(rs.getInt("D_ID"));
                c.setAid(rs.getInt("A_ID"));
                lista.add(c);
            }
        
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public List<Matriculas> listarMatriculasPorNome(String nome){
        try{
            List<Matriculas> lista = new ArrayList<Matriculas>();
            String Sql="select * from matricula where \"D_NOME\" like ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1,"%"+nome+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Matriculas c = new Matriculas();
                c.setAid(rs.getInt("D_ID"));
                c.setDid(rs.getInt("A_ID"));
                lista.add(c);
            }
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public void removerMatricula(Matriculas obj)
    {
        try{
            String cmdsql = "DELETE FROM matricula WHERE \"A_ID\"=? AND \"D_ID\"=?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getAid());
            stmt.setInt(2, obj.getDid());
            stmt.execute();
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
    
    public void cadastrarMatricula(Matriculas obj)
    {
        try{
            String cmdsql = "INSERT INTO matricula(\"A_ID\",\"D_ID\") VALUES (?,?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);

            stmt.setInt(1, obj.getAid());
            stmt.setInt(2, obj.getDid());
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
    public void alterarMatricula(Matriculas obj, String alunoupd, String disciplinaupd)
    {
        try{
            String cmdsql = "update matricula set \"A_ID\"=?,\"D_ID\"=? where \"A_ID\"=? AND \"D_ID\"=? ";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getAid());
            stmt.setInt(2, obj.getDid());
            stmt.setInt(3, Integer.parseInt(alunoupd));
            stmt.setInt(4, Integer.parseInt(disciplinaupd));
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
    
}
