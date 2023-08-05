package com.ank.repo;

import com.ank.model.tables.Arrears;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrearsRepository extends JpaRepository<Arrears, Long> {

    Arrears findById(long id);
    public Long countById(long id);

    Arrears deleteById(long id);
}
