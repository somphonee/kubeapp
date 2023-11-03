package co.th.priorsolution.treanning.kubeapp.model;

import lombok.Data;

@Data
public class ResponseModel<T> {
    private int status;
    private String description;
    private T data;
}
