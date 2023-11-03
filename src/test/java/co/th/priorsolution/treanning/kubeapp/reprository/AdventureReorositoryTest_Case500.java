package co.th.priorsolution.treanning.kubeapp.reprository;

import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.AdventureRepository;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.List;

public class AdventureReorositoryTest_Case500 implements AdventureRepository {
    @Override
    public int createAdventure(AdventureModel adventureMode) {
        throw new RuntimeException("SQL Error");
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
        return null;
    }

    @Override
    public void updateAdventureBalance(int id, int balance) {

    }
}
