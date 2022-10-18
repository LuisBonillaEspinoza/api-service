package com.bicimoto.app.repository;

import com.bicimoto.app.dto.ArticuloStockDto;
import com.bicimoto.app.entity.Tblstarticulo;
import com.bicimoto.app.entity.TblstarticuloPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ArticuloStRepository extends JpaRepository<Tblstarticulo, TblstarticuloPK> {

    @Query(value = "select s.codarti as codArti, a.Nombre as nombre, s.codalm as codAlm," +
            " (Select Nombre from TblAlmacen where codAlmacen = s.codalm) as nomAlm, s.ruc as rucEmpresa, s.Stock as stock from tblstarticulo s, tblarticulos a " +
            "where s.CodArti = a.CodArt and s.CodAlm = a.Almacen and s.Ruc = a.RucEmpresa and " +
            "s.CodArti =?1 and s.CodAlm =?2 and s.Ruc =?3", nativeQuery = true)
    ArticuloStockDto findArticuloStock(String codigo, String almacen, String empresa);

    @Transactional
    @Modifying
    @Query(value = "CALL SpStArticuloIngStock(?1,?2,?3,?4,?5);", nativeQuery = true)
    void updateIngStock(String empresa, String almacen, String codigo, Double cantidad, String usuario);

    @Transactional
    @Modifying
    @Query(value = "CALL SpDevolverStock(?1,?2,?3,?4);", nativeQuery = true)
    void devolverStock(String id, String tipo, String empresa,String almacen);

}
