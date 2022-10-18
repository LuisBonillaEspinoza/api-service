package com.bicimoto.app.repository;

import com.bicimoto.app.dto.ProductoDto;
import com.bicimoto.app.entity.Tblarticulo;
import com.bicimoto.app.entity.TblarticuloPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticuloRepository extends JpaRepository<Tblarticulo, TblarticuloPK> {
	
   @Query(value = " select DISTINCT pro.CodArt as CodArt ,pro.Nombre as Nombre," +
            "pro.PCosto as PCosto , pro.PVenta as PVenta ,  pro.StockMin as StockMin ,sto.Stock as Stock " +
            " from tblarticulos pro , tblstarticulo sto where pro.CodArt = sto.CodArti and pro.VentaMin='S' ORDER BY pro.CodArt", nativeQuery = true)
   List<ProductoDto> findProductos();
   
    @Query(value="select  DISTINCT pro.CodArt as CodArt , al.Nombre as NombreAlmacen  , sto.Stock as Stock " +
                " from tblarticulos pro, tblstarticulo sto  , tblalmacen al where pro.CodArt = sto.CodArti and  sto.CodAlm = al.CodAlmacen and pro.CodArt=?1" +
                " ORDER BY al.Nombre  asc" , nativeQuery = true)
    List<ProductoDto> findProductosByID(String codigo);    
}
