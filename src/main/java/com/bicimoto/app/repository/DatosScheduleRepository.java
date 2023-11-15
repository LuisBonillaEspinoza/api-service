package com.bicimoto.app.repository;

import com.bicimoto.app.dto.DatosScheduleDTO;
import com.bicimoto.app.dto.DetVentaDTO;
import com.bicimoto.app.entity.Tblempresa;
import com.bicimoto.app.entity.TblempresaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DatosScheduleRepository extends JpaRepository<Tblempresa, TblempresaPK> {
    @Query(value = " SELECT e.Razon, e.NombreLegal, e.Ubigeo, e.Direccion, e.Urbanizacion , e.Telefono , e.Celular , e.Representante , e.Email , e.Telefono2 , " +
            " (SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV ='00' and u.CODDIST='00') as NombreRegion, " +
            " (SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV = e.Provincia  and u.CODDIST='00') as NombreProvincia, " +
            " (SELECT u.Nombre FROM tblubigeo u inner join tblempresa e on e.Region = u.CODDPTO  where e.Ruc = ?1 and u.CODPROV = e.Provincia  and u.CODDIST= e.Distrito) as NombreDistrito, " +
            " cli.Nombre AS NombreCliente , cli.Email AS EmailCliente, v.Cliente as CodCliente, (SELECT dt.CodDetCat FROM tbldetcatalogo dt where dt.CodDetCat = v.TMoneda and dt.CodCatalogo = '001') AS TMoneda, " +
            " v.IdVenta, v.Fecha , (SELECT d.Nombre FROM tbldocumento d where d.Codigo = v.Doc and d.Modulo = 'VEN') AS Doc, v.Doc AS CodDoc , " +
            " v.NomArchXml , v.ArchivoXml , v.Usuario , (SELECT dt.CodDetCat FROM tbldetcatalogo dt WHERE dt.CodDetCat = v.TipDocCli AND dt.CodCatalogo = '018') AS TipDocCli, " +
            " (SELECT s.PrefijoSerie from tblserie s inner join tbldocumento dt on dt.codigo = s.doc where dt.Codigo = v.Doc and dt.Modulo = 'VEN' and s.Serie = v.Serie) as PrefijoSerie," +
            " (select dt.CodDetCat from tbldetcatalogo dt where dt.CodDetCat = v.TComp and dt.CodCatalogo = '022') AS TComp ," +
            " (select dt.Descripcion from tbldetcatalogo dt where dt.CodDetCat = v.TVenta and dt.CodCatalogo = '015') TVenta," +
            " v.Dcto, v.TBruto, v.TExonerada, v.TInafecta, v.TGratuita, v.TIgv, v.EGratuita, v.Total, v.Serie, v.Numero, v.TComp as CodTComp" +
            " FROM tblventa v INNER JOIN tblempresa e ON v.Empresa = e.Ruc INNER JOIN tblcliente cli on v.Cliente = cli.RucDni WHERE " +
            " e.ruc = ?1 AND v.Numero = ?2 AND v.Serie = ?3 AND v.TipDocCli = ?4 AND v.Almacen = ?5",nativeQuery = true)
    DatosScheduleDTO BuscarDatosSchedule(String ruc, String numero, String serie, String tipdoccli, String almacen);

    @Query(value = "  SELECT DISTINCT art.CodArt, art.Nombre as Descripcion, detv.PVenta as PUnitario, detv.PVenta as PReferencial, detv.TipPrecio, detv.Dcto, detv.Cantidad," +
                    " detv.Igv, detv.Importe as TotalVenta, detv.TipImpuesto as TipoImpuesto" +
                    " from tbldetventa detv inner join tblarticulos art on art.CodArt = detv.Codigo " +
                    " inner join tblventa ven on detv.IdVenta = ven.IdVenta where ven.IdVenta = ?1 " +
                    " and Ven.Empresa = ?2 and Ven.Almacen = ?3 group by art.CodArt",nativeQuery = true)
    List<DetVentaDTO> BuscarDetVenta(String idventa,String ruc,String almacen);
}
