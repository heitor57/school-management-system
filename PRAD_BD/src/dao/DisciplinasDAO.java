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
import javabeans.Disciplinas;
import javabeans.Professores;
import javax.swing.JOptionPane;
import jdbc.ConectionFactory;

/**
 *
 * @author Suporte
 */
public class DisciplinasDAO {
    private Connection conecta;
    public DisciplinasDAO(){
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
    public int getDisciplina(String nome){
        try{
            String Sql = "SELECT * FROM disciplinas WHERE \"D_NOME\" = ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("D_ID");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return -1;
    }
    public List<Disciplinas> listarDisciplinas(){
        try{
            List<Disciplinas> lista = new ArrayList<Disciplinas>();
            String Sql = "select * from disciplinas ORDER BY \"D_ID\" ";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Disciplinas c = new Disciplinas();
                c.setId(rs.getInt("D_ID"));
                c.setNome(rs.getString("D_NOME"));
                c.setDescricao(rs.getString("D_DESCRICAO"));
                c.setPid(rs.getInt("P_ID"));
                lista.add(c);
            }
        
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public List<Disciplinas> listarDisciplinasPorNome(String nome){
        try{
            List<Disciplinas> lista = new ArrayList<Disciplinas>();
            String Sql="select * from disciplinas where \"D_NOME\" like ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1,"%"+nome+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Disciplinas c = new Disciplinas();
                c.setId(rs.getInt("D_ID"));
                c.setNome(rs.getString("D_NOME"));
                c.setDescricao(rs.getString("D_DESCRICAO"));
                c.setPid(rs.getInt("P_ID"));
                lista.add(c);
            }
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public void removerDisciplina(Disciplinas obj)
    {
        try{
            String cmdsql = "DELETE FROM disciplinas WHERE \"D_ID\"=?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
    
    public void cadastrarDisciplina(Disciplinas obj)
    {
        try{
            String cmdsql = "INSERT INTO disciplinas(\"D_NOME\",\"D_DESCRICAO\",\"P_ID\") VALUES (?,?,?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDescricao());
            stmt.setInt(3, obj.getPid());
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
    public void alterarDisciplina(Disciplinas obj)
    {
        try{
            String cmdsql = "update disciplinas set \"D_NOME\"=?,\"D_DESCRICAO\"=?,\"P_ID\"=? where \"D_ID\"=?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDescricao());
            stmt.setInt(3, obj.getPid());
            stmt.setInt(4, obj.getId());
            stmt.execute();
            
            stmt.close();
            
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
    }
}
