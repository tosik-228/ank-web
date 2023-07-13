package com.ank.repo;

import com.ank.model.tables.SvGoriEl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SvGoriRepositoryJPA extends JpaRepository<SvGoriEl, String> {

    SvGoriEl findById(int id);

    SvGoriEl findBySchetchik(int chetchik);

    @Query("SELECT sv_gori_elektrichestvo.id FROM SvGoriEl sv_gori_elektrichestvo")
    List<Long> findAllId();

}