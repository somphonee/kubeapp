package co.th.priorsolution.treanning.kubeapp.reprository;

import co.th.priorsolution.treanning.kubeapp.model.GetPriceModel;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.MarketplaceRepository;

import java.util.List;

public class MarketplaceServiceTest_Case500 implements MarketplaceRepository {
    @Override
    public int postItemToMarket(MarketplaceModel marketplaceModel) {
        throw new RuntimeException("SQL postItemToMarket Error");
    }

    @Override
    public List<MarketplaceModel> getAllItem() {
        return null;
    }

    @Override
    public int buyItem(int itemId, int buyerId) {

        throw new RuntimeException("SQL buyItem Error");
    }

    @Override
    public GetPriceModel getItemById(int id) {
        throw new RuntimeException("SQL getItemById Error");
    }

    @Override
    public List<MarketplaceModel> getHistoryItem() {
        return null;
    }

    @Override
    public List<MarketplaceModel> getSoldItemsByAdventureId(int adventureId) {
        return null;
    }
}
