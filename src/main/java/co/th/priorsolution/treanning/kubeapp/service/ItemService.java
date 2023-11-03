package co.th.priorsolution.treanning.kubeapp.service;
import co.th.priorsolution.treanning.kubeapp.model.ItemModel;
import co.th.priorsolution.treanning.kubeapp.model.ResponseModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.impl.ItemRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    private  final ItemRepositoryImpl itemRepository;

    public ItemService(ItemRepositoryImpl itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ResponseModel<String> createItem(ItemModel itemModel) {
        ResponseModel<String> responseModel = new ResponseModel<>();
        responseModel.setStatus(201);
        responseModel.setDescription("created Item successfully");
        try {
            // Validate sellerModel and perform necessary business logic
            itemRepository.createItem(itemModel);

        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while creating Item: " + e.getMessage());
        }
        return responseModel;
    }
    public ResponseModel<List<ItemModel>> getAllItem() {
        ResponseModel<List<ItemModel>> responseModel = new ResponseModel<>();
        responseModel.setStatus(200);
        responseModel.setDescription("OK");

        try {
            List<ItemModel> itemModels = itemRepository.findAllItem();
            responseModel.setData(itemModels);
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while fetching Adventure: " + e.getMessage());
        }
        return responseModel;

    }

    public ResponseModel<List<ItemModel>> getItemsByAdventureId(int adventureId) {


        ResponseModel<List<ItemModel>> responseModel = new ResponseModel<>();
        try {
            List<ItemModel> items = itemRepository.findByAdventureId(adventureId);
            responseModel.setStatus(200);
            responseModel.setData(items);
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while fetching items: " + e.getMessage());
        }
        return responseModel;
    }
}
