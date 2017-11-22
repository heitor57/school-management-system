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
import jdbc.ConectionFactory;

/**
 *
 * @author Heitor
 */
public class UsuarioDAO {
    private Connection conecta;
    public UsuarioDAO(){
        this.conecta = new ConectionFactory().conecta();
    }
    public boolean efetuarLogin(String email,String senha){
        try{
            String cmdsql = "select * from usuario where u_email=? and u_senha=?";
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1,email);
            stmt.setString(2,senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException erro){
           throw new RuntimeException(erro); 
        }
        return false;
    }
}
