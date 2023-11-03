package co.th.priorsolution.treanning.kubeapp.controller.rest;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.model.ResponseModel;
import co.th.priorsolution.treanning.kubeapp.service.MarketplaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarketplaceRestController {

private final MarketplaceService marketplaceService;

    public MarketplaceRestController(MarketplaceService marketplaceService) {
        this.marketplaceService = marketplaceService;
    }


    @PostMapping("/itemSell")
    public ResponseModel<Void> postItemToMarket(@RequestBody MarketplaceModel marketplaceModel){
        return this.marketplaceService.postItem(marketplaceModel);
    }

    @GetMapping("/getAllItem")
    public  ResponseModel<List<MarketplaceModel>>getAllItem(){
        return  this.marketplaceService.getAllItem();
    }
    @GetMapping("/getHistoryItem")
    public  ResponseModel<List<MarketplaceModel>>getHistoryItem(){
        return  this.marketplaceService.getHistoryItem();
    }
    @GetMapping("/getHistoryItem/{adventureId}")
    public  ResponseModel<List<MarketplaceModel>>getSoldItemsByAdventureId(@PathVariable int adventureId){
        return  this.marketplaceService.getSoldItemsByAdventureId(adventureId);
    }

    @PostMapping("/buyItems")
    public ResponseModel<Void> buyItem(@RequestBody MarketplaceModel marketplaceModel ){
        return  this.marketplaceService.buyItem(marketplaceModel);
    }





}
