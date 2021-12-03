package com.doc.manage.model.dto.states;

import com.doc.manage.model.entity.Task;
import java.util.ArrayList;
import java.util.List;

public class StatesDto {

    private Integer id;

    private String stateName;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

}
