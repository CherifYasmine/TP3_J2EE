package classes;

import ConnexionBD.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetierCatalogue {

    @Override
    public List<Produit> getProduitsParMotCle(String mc) {
        List<Produit> prods = new ArrayList<Produit>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from produit where nom_produit LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setIdProduit(rs.getLong("id_produit"));
                p.setNomProduit(rs.getString("nom_produit"));
                p.setPrix(rs.getDouble("prix"));
                prods.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prods;
    }

    @Override
    public void addProduit(Produit p) {

    }
}
