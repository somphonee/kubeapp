package co.th.priorsolution.treanning.kubeapp.controller.rest;
import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import co.th.priorsolution.treanning.kubeapp.model.ResponseModel;
import co.th.priorsolution.treanning.kubeapp.service.AdventureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api")
public class AdventureRestController {
    private  final AdventureService adventureService;

    public AdventureRestController(AdventureService adventureService) {
        this.adventureService = adventureService;
    }


    @PostMapping("/adventure/create")
    public ResponseModel<Void> createAdventure(@RequestBody AdventureModel adventureModel){
        return this.adventureService.createAdventure(adventureModel);
    }
    @GetMapping("/adventure/getAll")
    public ResponseModel<List<AdventureModel>> getAllAdventure() {
        ResponseModel<List<AdventureModel>> responseModel = adventureService.getAllAdventure();

        log.info("<<<<<<<<{}>>>>>>>>>>", responseModel);
        return responseModel;


    }

    @PutMapping("/updateBalance/{id}")
    public ResponseModel<String> updateAdventureBalance(@PathVariable int id, @RequestBody Map<String, Integer> requestBody) {
        int balance = requestBody.get("balance");
        return adventureService.updateAdventureBalance(id, balance);
    }

}
