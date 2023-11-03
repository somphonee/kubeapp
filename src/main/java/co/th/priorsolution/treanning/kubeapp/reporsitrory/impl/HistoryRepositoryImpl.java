package co.th.priorsolution.treanning.kubeapp.reporsitrory.impl;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.HistoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {
    private JdbcTemplate jdbcTemplate;

    public HistoryRepositoryImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
    @Override
    public int insertHistory(int id, int buyerId){

        String insertHistorySql = "INSERT INTO history (item_id, seller_id, buyers_id, marketplace_id) VALUES ((SELECT item_id FROM marketplace WHERE id = ?), (SELECT seller_id FROM marketplace WHERE id = ?), ?, ?)";
        List<Object> paramInsertTransaction = new ArrayList<>();
        paramInsertTransaction.add(id);
        paramInsertTransaction.add(id);
        paramInsertTransaction.add(buyerId);
        paramInsertTransaction.add(id);
       return jdbcTemplate.update(insertHistorySql,paramInsertTransaction.toArray());
    }


}
