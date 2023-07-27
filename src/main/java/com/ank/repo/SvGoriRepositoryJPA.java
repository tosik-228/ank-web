package com.ank.repo;

import com.ank.model.tables.SvGoriEl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SvGoriRepositoryJPA extends JpaRepository<SvGoriEl, Integer> {

    Optional<SvGoriEl> findById(Integer id);

    SvGoriEl findBySchetchik(int chetchik);

    public Long countById(Integer id);



    @Query("SELECT sv_gori_elektrichestvo.id FROM SvGoriEl sv_gori_elektrichestvo")
    List<Long> findAllId();

}