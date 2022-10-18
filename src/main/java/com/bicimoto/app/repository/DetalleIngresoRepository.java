package com.bicimoto.app.repository;

import com.bicimoto.app.entity.Tbldetingreso;
import com.bicimoto.app.entity.TbldetingresoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DetalleIngresoRepository extends JpaRepository<Tbldetingreso, TbldetingresoPK> {
    
    @Transactional
    @Modifying
    @Query(value = "CALL SpDetIngresoElimina(?1,?2,?3);", nativeQuery = true)
    void detIngresoElimina(String id, String empresa, String almacen);

}
