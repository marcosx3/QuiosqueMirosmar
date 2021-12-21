package model;

import DB.Conexao;
import com.sistemas.quiosque.Classes.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeletarProdutoDAO {
    Produtos produto = new Produtos();
    //busca produto
    public Produtos getProdutos(int ID) throws SQLException {
        Produtos produto = new Produtos();
        Connection con = Conexao.getConexao();
        String sql = "SELECT * FROM produtos WHERE id= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1,ID);
        ResultSet rs  = stmt.executeQuery();
        while(rs.next()){
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getString("preco"));
            produto.setTipo(rs.getString("tipo"));
        }
        con.close();
        stmt.close();
        rs.close();
        return produto;
    }
    public void deletarProduto(int iD) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = " DELETE  FROM produtos where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, iD);
        stmt.executeUpdate();
        con.close();
        stmt.close();
    }

}
