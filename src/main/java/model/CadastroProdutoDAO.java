package model;
import DB.Conexao;
import com.sistemas.quiosque.Classes.Produtos;

import java.sql.*;

public class  CadastroProdutoDAO {
    Produtos produto = new Produtos();

     public void cadastroProduto(Produtos produto) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "INSERT INTO produtos (nome,preco,tipo) values(?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getPreco());
        stmt.setString(3, produto.getTipo());
        stmt.executeUpdate();
        con.close();
        stmt.close();
    }

    // recupera ID do ultimo produto cadastrado
    public int recuperarID() throws SQLException {
         Connection con = Conexao.getConexao();
        String sql = " select * from produtos order by id desc limit 1";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();
         while(res.next()){
              return res.getInt(1) ;
          }
         return 0;
    }

}
