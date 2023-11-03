package co.th.priorsolution.treanning.kubeapp.reporsitrory.impl;
import co.th.priorsolution.treanning.kubeapp.mapper.MarketplaceMapper;
import co.th.priorsolution.treanning.kubeapp.model.GetPriceModel;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.MarketplaceRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MarketplaceRepositoryImpl implements MarketplaceRepository {

    private JdbcTemplate jdbcTemplate;

    public MarketplaceRepositoryImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

     @Override
    public int postItemToMarket(MarketplaceModel marketplaceModel){
        String sql = "INSERT INTO marketplacegi (item_id, price, seller_id) VALUES (?, ?, ?)";
        List<Object> paramList = new ArrayList<>();
        paramList.add(marketplaceModel.getItemId());
        paramList.add(marketplaceModel.getPrice());
        paramList.add(marketplaceModel.getSellerId());
        return jdbcTemplate.update(sql, paramList.toArray());


    }

    @Override
    public List<MarketplaceModel> getAllItem() {

        String sql = "SELECT  m.id ,i.id as itemId, i.name as itemName, m.price, m.status, a.id as sellId,a.name as adventureSell,a2.id as buyerId, a2.name as adventureBuyer,m.create_date,m.updated_at from marketplace m  join item i on (m.item_id = i.id) inner join adventure a on (m.seller_id = a.id ) left join adventure a2 on (m.buyer_id=a2.id) where m.status = 'New Item For sell' ORDER BY m.updated_at DESC";
        return  jdbcTemplate.query(sql,new MarketplaceMapper());

    }

    @Override
    public List<MarketplaceModel> getHistoryItem() {

        String sql = "SELECT  m.id ,i.id as itemId, i.name as itemName, m.price, m.status, a.id as sellId,a.name as adventureSell,a2.id as buyerId, a2.name as adventureBuyer,m.create_date,m.updated_at from marketplace m  join item i on (m.item_id = i.id) inner join adventure a on (m.seller_id = a.id ) left join adventure a2 on (m.buyer_id=a2.id) where 1=1 ORDER BY m.updated_at DESC";
        return  jdbcTemplate.query(sql,new MarketplaceMapper());

    }

@Override
    public int buyItem(int id, int buyerId) {
        String buySql = "UPDATE marketplace SET buyer_id = ?, status = 'SOLD' WHERE id = ?";
        List<Object> paramUySql = new ArrayList<>();
        paramUySql.add(buyerId);
        paramUySql.add(id);
        return jdbcTemplate.update(buySql, paramUySql.toArray());

    }




@Override
    public GetPriceModel getItemById(int id) {

        String sql = "SELECT * FROM marketplace WHERE id = ?";

        return  jdbcTemplate.queryForObject(sql, new RowMapper<GetPriceModel>() {
            @Override
            public GetPriceModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                GetPriceModel getPriceModel =new GetPriceModel();
                getPriceModel.setId(rs.getInt("id"));
                getPriceModel.setPrice(rs.getInt("price"));
                return getPriceModel;
            }
        }, new Object[]{id});

    }

    @Override
    public List<MarketplaceModel> getSoldItemsByAdventureId(int adventureId) {

        String sql = "SELECT m.id, i.id as itemId, i.name as itemName, m.price, m.status,a.id as sellId, a.name as adventureSell, a2.id as buyerId, a2.name as adventureBuyer,m.create_date, m.updated_at FROM marketplace m JOIN item i ON (m.item_id = i.id) LEFT JOIN adventure a ON (m.seller_id = a.id) LEFT JOIN adventure a2 ON (m.buyer_id = a2.id) WHERE (m.buyer_id = ? OR m.seller_id = ?) AND m.status = 'SOLD' ORDER BY m.updated_at DESC";
        return jdbcTemplate.query(sql, new Object[]{adventureId, adventureId}, new MarketplaceMapper());



    }
}
