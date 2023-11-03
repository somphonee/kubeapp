package co.th.priorsolution.treanning.kubeapp.reporsitrory;

import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventureRepository {
    public int createAdventure(AdventureModel adventureMode);

    public void updateBalance(int id, int buyerId);
    public  void  updatecrediy(int id, int buyerId);
    public List<AdventureModel> findAllAdventure();
    public AdventureModel getBuyerById(int id);
    public void updateAdventureBalance(int id, int balance);

}
