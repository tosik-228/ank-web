package com.ank.repo;

import com.ank.model.tables.SV_GORY_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SvGoriRepositoryJPA extends JpaRepository<SV_GORY_Model, Long> {

    Optional<SV_GORY_Model> findById(long id);

//    SV_GORY_Model findByCounter_el(long counter_el);

    public Long countById(long id);

    SV_GORY_Model deleteById(long id);

    @Query("SELECT sv_gori.id FROM SV_GORY_Model sv_gori")
    List<Long> findAllId();

}