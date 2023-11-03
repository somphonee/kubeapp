package co.th.priorsolution.treanning.kubeapp.mapper;
import co.th.priorsolution.treanning.kubeapp.model.ItemModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<ItemModel> {

    @Override
    public ItemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemModel itemModel = new ItemModel();
        itemModel.setId(rs.getInt("id"));
        itemModel.setName(rs.getString("name"));
        itemModel.setDescription(rs.getString("description"));
        itemModel.setAdventureId(rs.getInt("adventure_id"));
        itemModel.setAdventureName(rs.getString("adventure"));
        itemModel.setCreateDate(rs.getTimestamp("create_date"));
        itemModel.setUpdatedDate(rs.getTimestamp("updated_at"));
        return itemModel;
    }
}
