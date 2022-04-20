package com.bicimoto.app.repository;

import com.bicimoto.app.entity.Tblalmacen;
import com.bicimoto.app.entity.TblalmacenPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Tblalmacen, TblalmacenPK> {

}
