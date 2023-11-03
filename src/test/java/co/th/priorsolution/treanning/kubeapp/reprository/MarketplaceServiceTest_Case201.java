package co.th.priorsolution.treanning.kubeapp.reprository;

import co.th.priorsolution.treanning.kubeapp.model.GetPriceModel;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.MarketplaceRepository;

import java.util.List;

public class MarketplaceServiceTest_Case201 implements MarketplaceRepository {

    @Override
    public int postItemToMarket(MarketplaceModel marketplaceModel) {
        return 1;
    }

    @Override
    public List<MarketplaceModel> getAllItem() {
        return null;
    }

    @Override
    public int buyItem(int itemId, int buyerId) {
        return 1;
    }

    @Override
    public GetPriceModel getItemById(int id) {
        GetPriceModel getPriceModel = new GetPriceModel();
        getPriceModel.setId(1);
        getPriceModel.setPrice(100);
        return getPriceModel;
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
