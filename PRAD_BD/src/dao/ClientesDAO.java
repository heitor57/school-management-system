/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javabeans.Clientes;
import jdbc.ConectionFactory;
/**
 *
 * @author Suporte
 */
public class ClientesDAO {
    private Connection conecta;
    
    public ClientesDAO(){
        this.conecta = new ConectionFactory().conecta();
    }
    public List<Clientes> listarClientesPorNome(String nome){
        try{
            List<Clientes> lista = new ArrayList<Clientes>();
            String Sql="select * from cliente where cli_nome like ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1,"%"+nome+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Clientes c = new Clientes();
                c.setId(rs.getInt("cli_codigo"));
                c.setNome(rs.getString("cli_nome"));
                c.setEmail(rs.getString("cli_email"));
                c.setTelefone(rs.getString("cli_telefone"));
                lista.add(c);
            }
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public List<Clientes> listarClientes(){
        try{
            List<Clientes> lista = new ArrayList<Clientes>();
            String Sql = "select * from cliente";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Clientes c = new Clientes();
                c.setId(rs.getInt("cli_codigo"));
                c.setNome(rs.getString("cli_nome"));
                c.setEmail(rs.getString("cli_email"));
                c.setTelefone(rs.getString("cli_telefone"));
                lista.add(c);
            }
        
            return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public void cadastrarCliente(Clientes obj)
    {
        try{
            String cmdsql = "insert into cliente(cli_nome, cli_email, cli_telefone) values (?,?,?)";
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
    public void alterarCliente(Clientes obj)
    {
        try{
            String cmdsql = "update cliente set cli_nome=?, cli_email=?, cli_telefone=? where cli_codigo=?";
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
    
    public boolean efetuarLogin(String email,String senha){
        try{
            String cmdsql = "select * from cliente where cli_email=? and cli_senha=?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1,email);
            stmt.setString(2,senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.first()){
                return true;
            }
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
        return false;
    }
}
