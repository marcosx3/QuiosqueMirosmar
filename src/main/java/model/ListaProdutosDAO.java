package model;

import DB.Conexao;
import com.sistemas.quiosque.Classes.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListaProdutosDAO {

    List<Produtos> produto =new ArrayList<Produtos>();
    public List<Produtos> getLista(){
        Connection con = Conexao.getConexao();
        String sql = "SELECT * FROM produtos";
       try {
           PreparedStatement stmt = con.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           while(rs.next()){
                produto.add(new Produtos(rs.getInt("id"),rs.getString("nome"), rs.getString("preco"),rs.getString("tipo")));
           }
           stmt.close();
           rs.close();
           con.close();
       } catch (SQLException e ){
           e.printStackTrace();
           System.out.println("Lista nao retornada");
           return  null;
       }
        return produto;
    }
}
