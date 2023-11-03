package co.th.priorsolution.treanning.kubeapp.reporsitrory;
import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.model.NotificationModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository {

    public  int updateNoti(int id, int buyerId);
    public int insertNoti (MarketplaceModel marketplaceModel);
    public List<NotificationModel> getAllNewNotification();
    public  void update(int id);
}
