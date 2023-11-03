package co.th.priorsolution.treanning.kubeapp.reporsitrory.impl;
import co.th.priorsolution.treanning.kubeapp.mapper.NotificationMapper;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.model.NotificationModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {
    private JdbcTemplate jdbcTemplate;

    public NotificationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public  int updateNoti(int id, int buyerId){
        log.info(">>>>>>>>>>>>>>{}>>>>>>>>>>>>>>>>>",id,buyerId);
        String updateNotiSql = "UPDATE notifications SET titel = 'item is sell out', status = 'SOLD' WHERE id = ?";
        List<Object> paramSql = new ArrayList<>();
        paramSql.add(id);
        return jdbcTemplate.update(updateNotiSql, paramSql.toArray());
    }
    @Override
    public int  insertNoti (MarketplaceModel marketplaceModel){
        String sqlNotification = "INSERT INTO notifications (item_id, seller_id) VALUES (?, ?)";
        List<Object> paramListNoti = new ArrayList<>();
        paramListNoti.add(marketplaceModel.getItemId());
        paramListNoti.add(marketplaceModel.getSellerId());
        return jdbcTemplate.update(sqlNotification, paramListNoti.toArray());
    }
    @Override
    public List<NotificationModel> getAllNewNotification() {
        String sql = "SELECT  n.id, n.titel, n.status, i.id as itemId, i.name  as itemName, i.description, a.id as sellerId, a.name as sellerName, n.create_date, n.updated_at from notifications n inner join item i on (n.item_id = i.id) inner join adventure a on (n.seller_id = a.id) where n.status = 'NewnNotification' ORDER BY n.updated_at DESC";
        List<NotificationModel> notificationModels =  jdbcTemplate.query(sql, new NotificationMapper());
        return notificationModels;
    }

    @Override
    public  void update(int id){
//        log.info(">>>>>>>>>>>>>>>>>>>> read id Notification {}<<<<<<<<<<<<<<<<<<<<<<<<",id);
        String updateSql = "UPDATE notifications SET titel = 'item is read ', status = 'Already read' where id =? " ;
        List<Object> paramList = new ArrayList<>();
        paramList.add(id);
        this.jdbcTemplate.update(updateSql,paramList.toArray());
    }
    public List<NotificationModel> getAllNotifications() {
        String sql = "SELECT n.id, n.titel, n.status, i.id as itemId, i.name as itemName, i.description, a.id as sellerId, a.name as sellerName, n.create_date, n.updated_at from notifications n inner join item i on (n.item_id = i.id) inner join adventure a on (n.seller_id = a.id) where 1=1 ORDER BY n.updated_at DESC";
        return jdbcTemplate.query(sql, new NotificationMapper());

    }


}
