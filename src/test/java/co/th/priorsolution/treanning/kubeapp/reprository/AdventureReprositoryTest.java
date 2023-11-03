package co.th.priorsolution.treanning.kubeapp.reprository;

import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.AdventureRepository;

import java.util.List;

public class AdventureReprositoryTest implements AdventureRepository {


    @Override
    public int createAdventure(AdventureModel adventureMode) {
        return 1;
    }

    @Override
    public void updateBalance(int id, int buyerId) {

    }

    @Override
    public void updatecrediy(int id, int buyerId) {

    }

    @Override
    public List<AdventureModel> findAllAdventure() {
        return null;
    }

    @Override
    public AdventureModel getBuyerById(int id) {
        AdventureModel adventureModel = new AdventureModel();
        adventureModel.setId(1);
        adventureModel.setBalance(5000);
        return adventureModel;
    }

    @Override
    public void updateAdventureBalance(int id, int balance) {

    }
}