package com.bicimoto.app.repository;

import com.bicimoto.app.entity.Tblarticulo;
import com.bicimoto.app.entity.TblarticuloPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Tblarticulo, TblarticuloPK> {

}
