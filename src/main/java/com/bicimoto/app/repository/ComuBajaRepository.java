package com.bicimoto.app.repository;

import com.bicimoto.app.dto.ComuBajaDTO;
import com.bicimoto.app.dto.DetComuBajaDTO;
import com.bicimoto.app.entity.Tblcomunicabaja;
import com.bicimoto.app.entity.TblcomunicabajaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComuBajaRepository extends JpaRepository<Tblcomunicabaja, TblcomunicabajaPK> {
    @Query(value = "SELECT distinct e.Razon, e.NombreLegal, e.Ubigeo, e.Direccion, e.Urbanizacion , e.Telefono , e.Celular , e.Representante , e.Email , e.Telefono2 , " +
                    "(SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV ='00' and u.CODDIST='00') as NombreRegion, " +
                    "(SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV = e.Provincia  and u.CODDIST='00') as NombreProvincia, " +
                    "(SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV = e.Provincia  and u.CODDIST= e.Distrito) as NombreDistrito, " +
                    "com.Fecha, detcom.Id, com.NDocBaja, com.ArchXml, com.NomArchXml, com.Ticket " +
                    "FROM tblventa v INNER JOIN tblempresa e ON v.Empresa = e.Ruc " +
                    "inner join tbldetcomunicacionbaja detcom on v.IdVenta = detcom.IdVenta " +
                    "inner join tblcomunicabaja com on com.NDocBaja  = detcom.NDocBaja WHERE " +
                    "e.ruc = ?1 AND v.Serie  = ?2 and v.Numero = ?3 and v.Doc = ?4 AND v.Almacen = ?5 and com.Id = ?6 and com.NDocBaja = ?7 " +
                    "GROUP BY e.Razon, e.NombreLegal, e.Ubigeo, e.Direccion, e.Urbanizacion, e.Telefono, e.Celular, e.Representante, e.Email, e.Telefono2, " +
                    "NombreRegion, NombreProvincia, NombreDistrito, com.NDocBaja, com.ArchXml, com.NomArchXml, com.Ticket",nativeQuery = true)
    ComuBajaDTO BuscarComuBaja(String ruc,String serie,String numero,String doc,String almacen,String id,String ndoc);

    @Query(value = "select distinct NumId, TipDoc, Serie, NumDoc, MotivoBaja, " +
                    "(select distinct  PrefijoSerie from tblserie ser inner join tbldetcomunicacionbaja detcom where ser.doc = detcom.TipDoc and ser.serie = detcom.Serie and detcom.RucEmpresa = ?1 and detcom.NDocBaja = ?2) as PrefijoSerie " +
                    "from tbldetcomunicacionbaja where RucEmpresa = ?1 and NDocBaja = ?2 and Id = ?3",nativeQuery = true)
    List<DetComuBajaDTO> BuscarDetComuBaja(String ruc, String ndoc,String id);
}
