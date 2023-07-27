package com.ank.service;

import com.ank.model.tables.SvGoriEl;
import com.ank.repo.SvGoriRepositoryJPA;
import jnr.ffi.annotations.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesService {

    private SvGoriRepositoryJPA svGoriRepositoryJPA;

    public List<SvGoriEl> listAll() {
        return (List<SvGoriEl>) svGoriRepositoryJPA.findAll();
    }
    public void save (SvGoriEl svGoriEl) {
        svGoriRepositoryJPA.save(svGoriEl);
    }

    public SvGoriEl get(Integer id) throws Exception {
        Optional<SvGoriEl> result = svGoriRepositoryJPA.findById(id);


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
