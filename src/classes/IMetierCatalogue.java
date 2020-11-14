package classes;

import java.util.List;

public interface IMetierCatalogue {
    public List<Produit> getProduitsParMotCle(String mc);
    public void addProduit(Produit p);
}
