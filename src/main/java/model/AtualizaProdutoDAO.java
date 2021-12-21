package model;

import DB.Conexao;
import com.sistemas.quiosque.Classes.Produtos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class AtualizaProdutoDAO {
    // buscar produto no BD
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
    // atualizar produto
       public void atualizaProduto(int iD,Produtos produto) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE produtos SET nome = ? ,preco = ? ,tipo = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());
            stmt.setString(3, produto.getTipo());
            stmt.setInt(4,iD);
            stmt.executeUpdate();
            con.close();
            stmt.close();
        }



}
