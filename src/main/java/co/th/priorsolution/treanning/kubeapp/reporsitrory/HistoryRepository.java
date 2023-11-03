package co.th.priorsolution.treanning.kubeapp.reporsitrory;

import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository {
    public int insertHistory(int id, int buyerId);
}
