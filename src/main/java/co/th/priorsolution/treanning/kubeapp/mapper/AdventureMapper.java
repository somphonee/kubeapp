package co.th.priorsolution.treanning.kubeapp.mapper;


import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdventureMapper implements RowMapper<AdventureModel> {
    @Override
    public AdventureModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        AdventureModel adventureModel = new AdventureModel();


        adventureModel.setId(rs.getInt("id"));
        adventureModel.setName(rs.getString("name"));
        adventureModel.setEmail(rs.getString("email"));
        adventureModel.setBalance(rs.getInt("balance"));
        adventureModel.setCreateDate(rs.getTimestamp("create_date"));
        adventureModel.setUpdatedDate(rs.getTimestamp("updated_at"));
        return adventureModel;
    }

}
