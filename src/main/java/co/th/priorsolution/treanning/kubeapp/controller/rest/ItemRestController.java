package co.th.priorsolution.treanning.kubeapp.controller.rest;
import co.th.priorsolution.treanning.kubeapp.model.ItemModel;
import co.th.priorsolution.treanning.kubeapp.model.ResponseModel;
import co.th.priorsolution.treanning.kubeapp.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemRestController {
    private  final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/item/create")
    public ResponseModel<String> createItem(@RequestBody ItemModel itemModel){
        return itemService.createItem(itemModel);
    }
    @GetMapping("/item/getAll")
    public ResponseModel<List<ItemModel>> getAllItem() {
        return itemService.getAllItem();
    }


    @GetMapping("/items/adventure/{adventureId}")
    public ResponseModel<List<ItemModel>> getItemsByAdventureId(@PathVariable int adventureId) {
        return itemService.getItemsByAdventureId(adventureId);
    }





}
