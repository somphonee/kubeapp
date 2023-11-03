package co.th.priorsolution.treanning.kubeapp.reporsitrory.impl;
import co.th.priorsolution.treanning.kubeapp.mapper.AdventureMapper;
import co.th.priorsolution.treanning.kubeapp.model.AdventureModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.AdventureRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdventureRepositoryImpl implements AdventureRepository {
    private JdbcTemplate jdbcTemplate;

  public AdventureRepositoryImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int createAdventure(AdventureModel adventureModel) {
        String sql = " INSERT INTO adventure(name, email, balance) VALUES (?, ?, ?)";
        List<Object> paramList = new ArrayList<>();
        paramList.add(adventureModel.getName());
        paramList.add(adventureModel.getEmail());
        paramList.add(adventureModel.getBalance());
        return  this.jdbcTemplate.update(sql,paramList.toArray());

    }

    @Override
    public void updateBalance(int id, int buyerId){

        String updateBalanceSql = "UPDATE adventure SET balance = balance + (SELECT price FROM marketplace WHERE id = ?) WHERE id = (SELECT seller_id FROM marketplace WHERE id = ?)";
        List<Object> paramUpdate = new ArrayList<>();
        paramUpdate.add(id);
        paramUpdate.add(id);
        jdbcTemplate.update(updateBalanceSql,paramUpdate.toArray());
    }

    @Override
    public  void  updatecrediy(int id, int buyerId){
      String updatecrediySql = "UPDATE adventure SET  balance = balance - (SELECT price FROM marketplace WHERE id = ?) WHERE id = ? ";
    List<Object> paramcreditUpdate = new ArrayList<>();
    paramcreditUpdate.add(id);
    paramcreditUpdate.add(buyerId);
    jdbcTemplate.update(updatecrediySql,paramcreditUpdate.toArray());
    }

@Override
    public List<AdventureModel> findAllAdventure() {
      String sql = "SELECT * FROM adventure ORDER BY updated_at DESC";

      return jdbcTemplate.query(sql, new AdventureMapper());

    }
@Override
public void updateAdventureBalance(int id, int balance) {
    String sql = "UPDATE adventure SET balance = balance + ? WHERE id = ?";
    jdbcTemplate.update(sql, balance, id);
}

    @Override
    public AdventureModel getBuyerById(int id) {

        String sql = "SELECT * FROM adventure WHERE id =? ";
        List<Object> param = new ArrayList<>();
        param.add(id);
        return jdbcTemplate.queryForObject(sql, new AdventureMapper(), param.toArray());
    }
}



