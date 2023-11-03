package co.th.priorsolution.treanning.kubeapp.reporsitrory.impl;
import co.th.priorsolution.treanning.kubeapp.mapper.ItemMapper;
import co.th.priorsolution.treanning.kubeapp.model.ItemModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.ItemRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private JdbcTemplate jdbcTemplate;

    public ItemRepositoryImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}




    @Override
    public int createItem(ItemModel itemModel) {
        String sql = " INSERT INTO item(name, description, adventure_id) VALUES (?, ?, ?)";
        List<Object> paramList = new ArrayList<>();
        paramList.add(itemModel.getName());
        paramList.add(itemModel.getDescription());
        paramList.add(itemModel.getAdventureId());
       return jdbcTemplate.update(sql,paramList.toArray());

    }
    @Override
    public void updatecIditem(int id, int buyerId){
        String updatecIditemSql = "UPDATE item SET adventure_id = ? WHERE id = (SELECT item_id FROM marketplace WHERE id = ?) AND adventure_id = (SELECT seller_id FROM marketplace WHERE id = ?)";
        List<Object> paramUpdateitemId = new ArrayList<>();
        paramUpdateitemId.add(buyerId);
        paramUpdateitemId.add(id);
        paramUpdateitemId.add(id);
        jdbcTemplate.update(updatecIditemSql,paramUpdateitemId.toArray());



    }


    @Override
    public List<ItemModel> findAllItem() {
//        String sql = "SELECT * FROM item";
        String sql = "SELECT i.id , i.name, i.description, i.create_date,i.updated_at, a.id as adventure_id, a.name as adventure  from item i inner join adventure a on(i.adventure_id = a.id) WHERE 1=1 ORDER BY i.updated_at DESC";
        return jdbcTemplate.query(sql, new ItemMapper());

    }

@Override
    public List<ItemModel> findByAdventureId(int adventureId) {

        String sql = "SELECT i.id, i.name, i.description, i.create_date, i.updated_at, a.id as adventure_id, a.name as adventure from item i inner join adventure a on (i.adventure_id = a.id) WHERE i.adventure_id = ? ORDER BY i.updated_at DESC";
        return jdbcTemplate.query(sql, new Object[]{adventureId}, new ItemMapper());
    }
}
