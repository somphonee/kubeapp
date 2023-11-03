package co.th.priorsolution.treanning.kubeapp.reporsitrory;
import co.th.priorsolution.treanning.kubeapp.model.GetPriceModel;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketplaceRepository {
    public int postItemToMarket(MarketplaceModel marketplaceModel);
    public List<MarketplaceModel> getAllItem();
    public int buyItem(int itemId, int buyerId);
    public GetPriceModel getItemById(int id);
    public List<MarketplaceModel> getHistoryItem();
    public List<MarketplaceModel> getSoldItemsByAdventureId(int adventureId);
}
