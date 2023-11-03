package co.th.priorsolution.treanning.kubeapp.reporsitrory;
import co.th.priorsolution.treanning.kubeapp.model.ItemModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository {
    public int createItem(ItemModel itemModel);
    public List<ItemModel> findAllItem();
    public void updatecIditem(int id, int buyerId);
    public List<ItemModel> findByAdventureId(int adventureId);
}
