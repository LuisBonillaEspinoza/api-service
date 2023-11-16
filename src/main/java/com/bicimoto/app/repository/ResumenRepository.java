package com.bicimoto.app.repository;

import com.bicimoto.app.dto.DetResumenDTO;
import com.bicimoto.app.dto.ResumenDTO;
import com.bicimoto.app.entity.Tblresumen;
import com.bicimoto.app.entity.TblresumenPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResumenRepository extends JpaRepository<Tblresumen, TblresumenPK> {
    @Query(value = "SELECT distinct e.Razon, e.NombreLegal, e.Ubigeo, e.Direccion, e.Urbanizacion , e.Telefono , e.Celular , e.Representante , e.Email , e.Telefono2 , " +
                    "(SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV ='00' and u.CODDIST='00') as NombreRegion, " +
                    "(SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV = e.Provincia  and u.CODDIST='00') as NombreProvincia, " +
                    "(SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV = e.Provincia  and u.CODDIST= e.Distrito) as NombreDistrito, " +
                    "res.Fecha, res.Id, res.NDocResumen, res.ArchXml, res.NomArchXml " +
                    "FROM tblventa v INNER JOIN tblempresa e ON v.Empresa = e.Ruc " +
                    "inner join tbldetresumen detres on v.IdVenta = detres.IdComp " +
                    "inner join tblresumen res on res.NDocResumen  = detres.NDocResumen WHERE " +
                    "e.ruc = ?1 AND v.Serie  = ?2 and v.Numero = ?3 and v.Doc = ?4 AND v.Almacen = ?5 and res.Id = ?6 and res.NDocResumen = ?7 " +
                    "GROUP BY e.Razon, e.NombreLegal, e.Ubigeo, e.Direccion, e.Urbanizacion, e.Telefono, e.Celular, e.Representante, e.Email, e.Telefono2, " +
                    "NombreRegion, NombreProvincia, NombreDistrito, res.NDocResumen, res.ArchXml, res.NomArchXml, res.Ticket",nativeQuery = true)
    ResumenDTO BuscarResumen(String ruc, String serie, String numero, String doc, String almacen,String id,String ndoc);

    @Query(value = "select distinct detres.NumId, detres.Serie, detres.Inicio, v.Cliente, v.Total, v.TBruto, v.TInafecta, v.TGratuita, v.Dcto, detres.EstadoItem, " +
                    "(select ser.PrefijoSerie from tblserie ser inner join tbldocumento doc on doc.Codigo = ser.Doc where doc.Codigo = v.Doc and doc.Modulo = 'VEN' and doc.Est = 'A' and ser.Serie = v.Serie) as PrefijoSerie, " +
                    "(select CodDetCat from tbldetcatalogo where CodCatalogo = '018' and CodDetCat = v.TipDocCli  and est = 'A') as CodDetCat, " +
                    "(select CodDetCat from tbldetcatalogo where CodCatalogo = '001' and CodDetCat = v.TMoneda  and est = 'A') as Moneda " +
                    "from tbldetresumen detres " +
                    "inner join tblventa v on " +
                    "detres.IdComp = v.IdVenta " +
                    "where detres.NDocResumen = ?2 and detres.RucEmpresa = ?1 and detres.Id = ?3",nativeQuery = true)
    List<DetResumenDTO> BuscarDetResumen(String ruc, String ndoc,String id);
}
