package com.ank.repo;

import com.ank.model.tables.Arrears;
import com.ank.model.tables.SV_GORY_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrearsRepository extends JpaRepository<Arrears, Long> {

    Arrears findById(long id);
}
