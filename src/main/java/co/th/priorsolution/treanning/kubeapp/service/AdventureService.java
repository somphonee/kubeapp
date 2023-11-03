package co.th.priorsolution.treanning.kubeapp.service;
import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import co.th.priorsolution.treanning.kubeapp.model.ResponseModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.AdventureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class AdventureService {

    private  final AdventureRepository adventureRepository;

    public AdventureService(AdventureRepository adventureRepository) {
        this.adventureRepository = adventureRepository;
    }



    @Transactional
    public ResponseModel<Void> createAdventure(AdventureModel adventureModel) {
        ResponseModel<Void> responseModel = new ResponseModel<>();
        responseModel.setStatus(201);
        responseModel.setDescription("created Adventure successfully");
        try {
            // Validate sellerModel and perform necessary business logic
            this.adventureRepository.createAdventure(adventureModel);

        } catch (Exception e) {
            e.printStackTrace();
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while creating Adventure: " + e.getMessage());
        }
        return responseModel;
    }




    public ResponseModel<List<AdventureModel>> getAllAdventure() {
        ResponseModel<List<AdventureModel>> responseModel = new ResponseModel<>();
        responseModel.setStatus(200);
        responseModel.setDescription("OK");


        try {
            List<AdventureModel> adventureModels = adventureRepository.findAllAdventure();
            responseModel.setData(adventureModels);
           log.info("<<<<<{}>>>>>",adventureModels);

        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while fetching Adventure: " + e.getMessage());
        }
        return responseModel;
    }
    public ResponseModel<String> updateAdventureBalance(int id, int balance) {
        ResponseModel<String> responseModel = new ResponseModel<>();
        try {
            adventureRepository.updateAdventureBalance(id, balance);
            responseModel.setStatus(200);
            responseModel.setData("Adventure balance updated successfully.");
        } catch (Exception e) {
            responseModel.setStatus(500);
            responseModel.setDescription("Error occurred while updating adventure balance: " + e.getMessage());
        }
        return responseModel;
    }
}
