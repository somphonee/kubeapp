package co.th.priorsolution.treanning.kubeapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ItemModel {
    private int id;
    private String name;
    private String description;
    private int adventureId;
    private  String adventureName;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createDate;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updatedDate;
}
