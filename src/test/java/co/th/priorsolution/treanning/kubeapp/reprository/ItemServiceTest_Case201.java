package co.th.priorsolution.treanning.kubeapp.reprository;

import co.th.priorsolution.treanning.kubeapp.model.ItemModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.ItemRepository;

import java.util.List;

public class ItemServiceTest_Case201 implements ItemRepository {
    @Override
    public int createItem(ItemModel itemModel) {
        return 1;
    }

    @Override
    public List<ItemModel> findAllItem() {
        return null;
    }

    @Override
    public void updatecIditem(int id, int buyerId) {

    }

    @Override
    public List<ItemModel> findByAdventureId(int adventureId) {
        return null;
    }
}
