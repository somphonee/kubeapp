package co.th.priorsolution.treanning.kubeapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AdventureModel {
    private int id;
    private String name;
    private String email;
    private int balance;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createDate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updatedDate;
}
