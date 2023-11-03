package co.th.priorsolution.treanning.kubeapp.service;
import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import co.th.priorsolution.treanning.kubeapp.model.GetPriceModel;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.model.ResponseModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketplaceService {
    private final MarketplaceRepository marketplaceRepository;
    private final AdventureRepository adventureRepository;
    private final ItemRepository itemRepository;
    private final NotificationRepository notificationRepository;
    private final HistoryRepository historyRepository;

    public MarketplaceService(MarketplaceRepository marketplaceRepository, AdventureRepository adventureRepository, ItemRepository itemRepository, NotificationRepository notificationRepository, HistoryRepository historyRepository) {
        this.marketplaceRepository = marketplaceRepository;
        this.adventureRepository = adventureRepository;
        this.itemRepository = itemRepository;
        this.notificationRepository = notificationRepository;
        this.historyRepository = historyRepository;
    }



    public ResponseModel<Void> postItem(MarketplaceModel marketplaceModel) {
        ResponseModel<Void> responseModel = new ResponseModel<>();
        responseModel.setStatus(201);
        responseModel.setDescription("Item posted in the marketplace successfully");

        try {
            marketplaceRepository.postItemToMarket(marketplaceModel);
           // kafkaProducerComponent.sendNotification(marketplaceModel);
            notificationRepository.insertNoti(marketplaceModel);
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while posting item: " + e.getMessage());
        }

        return responseModel;
    }

    public ResponseModel<List<MarketplaceModel>> getAllItem() {
        ResponseModel<List<MarketplaceModel>> responseModel = new ResponseModel<>();
        responseModel.setStatus(200);
        responseModel.setDescription("ok");

        try {
            List<MarketplaceModel> marketplaceItemModels = marketplaceRepository.getAllItem();
            responseModel.setData(marketplaceItemModels);
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while fetching buyers: " + e.getMessage());
        }
        return responseModel;

    }

    public ResponseModel<List<MarketplaceModel>> getHistoryItem() {
        ResponseModel<List<MarketplaceModel>> responseModel = new ResponseModel<>();
        responseModel.setStatus(200);
        responseModel.setDescription("ok");

        try {
            List<MarketplaceModel> marketplaceItemModels = marketplaceRepository.getHistoryItem();
            responseModel.setData(marketplaceItemModels);
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while fetching buyers: " + e.getMessage());
        }
        return responseModel;
    }

    public ResponseModel<Void> buyItem(MarketplaceModel marketplaceModel) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        GetPriceModel item = marketplaceRepository.getItemById(marketplaceModel.getId());
        AdventureModel buyer = adventureRepository.getBuyerById(marketplaceModel.getBuyerId());

        if (item == null) {
            responseModel.setStatus(404);
            responseModel.setDescription("Item not found in the marketplace");
            return responseModel;
        }
        if (buyer == null) {
            responseModel.setStatus(404);
            responseModel.setDescription("Buyer not found");
            return responseModel;
        }
        if (buyer.getBalance() < item.getPrice()) {
            responseModel.setStatus(400);
            responseModel.setDescription("Insufficient credit to buy the item");
            return responseModel;
        }
        try {
            marketplaceRepository.buyItem(marketplaceModel.getId(), buyer.getId());
            adventureRepository.updateBalance(marketplaceModel.getId(), buyer.getId());
            adventureRepository.updatecrediy(marketplaceModel.getId(), buyer.getId());
            itemRepository.updatecIditem(marketplaceModel.getId(), buyer.getId());
            notificationRepository.updateNoti(marketplaceModel.getId(), buyer.getId());
            historyRepository.insertHistory(marketplaceModel.getId(), buyer.getId());
            responseModel.setStatus(200);
            responseModel.setDescription("Item buy successfully");
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while processing the transaction: " + e.getMessage());
        }

        return responseModel;
    }



    public ResponseModel<List<MarketplaceModel>> getSoldItemsByAdventureId(int adventureId) {
        ResponseModel<List<MarketplaceModel>> responseModel = new ResponseModel<>();
        responseModel.setStatus(200);
        responseModel.setDescription("ok");

        try {
            List<MarketplaceModel> marketplaceItemModels = marketplaceRepository.getSoldItemsByAdventureId(adventureId);
            responseModel.setData(marketplaceItemModels);
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while fetching buyers: " + e.getMessage());
        }
        return responseModel;
    }
}

