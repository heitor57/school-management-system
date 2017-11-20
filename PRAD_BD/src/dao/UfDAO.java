/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Uf;
import jdbc.ConectionFactory;

/**
 *
 * @author Heitor
 */
public class UfDAO {
    private Connection conecta;
    public UfDAO(){
        this.conecta = new ConectionFactory().conecta();
    }
    public int buscarEstado(String sigla){
        try{

            String Sql= "select iduf from UF where sigla = ?";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            stmt.setString(1, sigla);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("iduf");
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    public List<Uf>listarEstados(){
        try{
            List<Uf> lista = new ArrayList<Uf>();
            String Sql= "select * from uf";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Uf u = new Uf();
                u.setId(rs.getInt("iduf"));
                u.setSigla(rs.getString("sigla"));
                lista.add(u);
            }
        
        return lista;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        
        
    }
}
