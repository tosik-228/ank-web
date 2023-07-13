package com.ank.model.tables;

import lombok.Data;

import java.util.List;

@Data
public class SvGoriDTO {

    private List<SvGoriEl> svGoriEls;

    public SvGoriDTO(List<SvGoriEl> lists) {

    }

    public void addList(SvGoriEl svGoriEl) {
        this.svGoriEls.add(svGoriEl);
    }

    public SvGoriDTO() {

    }

}
