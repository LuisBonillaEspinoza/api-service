package com.bicimoto.app.repository;

import com.bicimoto.app.dto.ArticuloStockDto;
import com.bicimoto.app.entity.Tblstarticulo;
import com.bicimoto.app.entity.TblstarticuloPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticuloStRepository extends JpaRepository<Tblstarticulo, TblstarticuloPK> {

    @Query(value = "select s.codarti as codArti, a.Nombre as nombre, s.codalm as codAlm, s.ruc as rucEmpresa, s.Stock as stock from tblstarticulo s, tblarticulos a " +
            "where s.CodArti = a.CodArt and s.CodAlm = a.Almacen and s.Ruc = a.RucEmpresa and " +
            "s.CodArti =?1 and s.CodAlm =?2 and s.Ruc =?3", nativeQuery = true)
    ArticuloStockDto findArticuloStock(String codigo, String almacen, String empresa);
}
