package co.th.priorsolution.treanning.kubeapp.reprository;

import co.th.priorsolution.treanning.kubeapp.model.MarketplaceModel;
import co.th.priorsolution.treanning.kubeapp.model.NotificationModel;
import co.th.priorsolution.treanning.kubeapp.reporsitrory.NotificationRepository;

import java.util.List;

public class NotificationServiceTest_Case500 implements NotificationRepository {
    @Override
    public int updateNoti(int id, int buyerId) {
        return 0;
    }

    @Override
    public int insertNoti(MarketplaceModel marketplaceModel) {
        throw new RuntimeException("SQL insertNoti Error");
       // return 1;
    }

    @Override
    public List<NotificationModel> getAllNewNotification() {
        return null;
    }

    @Override
    public void update(int id) {

    }
}
