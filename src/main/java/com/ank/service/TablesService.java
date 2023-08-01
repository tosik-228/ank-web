package com.ank.service;

import com.ank.model.tables.SV_GORY_Model;
import com.ank.repo.SvGoriRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TablesService {

    private final SvGoriRepositoryJPA svGoriRepositoryJPA;

    public TablesService(SvGoriRepositoryJPA svGoriRepositoryJPA) {
        this.svGoriRepositoryJPA = svGoriRepositoryJPA;
    }

    public List<SV_GORY_Model> listAll() {

        return (List<SV_GORY_Model>) svGoriRepositoryJPA.findAll();
    }

    public void save(SV_GORY_Model sv) {
        svGoriRepositoryJPA.save(sv);
    }

    public SV_GORY_Model get(Integer id) throws Exception {
        Optional<SV_GORY_Model> result = svGoriRepositoryJPA.findById(id);
        throw new Exception("Could not find any users with ID " + id);
    }

    public void delete(Integer id) throws Exception {
        Long count = svGoriRepositoryJPA.countById(id);
        if (count == null || count == 0) {
            throw new Exception("Could not find any users with ID " + id);
        }
        svGoriRepositoryJPA.deleteById(id);
    }
}
