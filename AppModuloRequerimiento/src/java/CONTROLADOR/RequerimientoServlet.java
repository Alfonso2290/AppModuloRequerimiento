
package CONTROLADOR;

import BEAN.CatalogoBEAN;
import BEAN.CotizacionBEAN;
import BEAN.DepartamentoBEAN;
import BEAN.DetalleCotizacionBEAN;
import BEAN.DistritoBEAN;
import BEAN.ProductoBEAN;
import BEAN.ProveedorBEAN;
import BEAN.ProvinciaBEAN;
import DAO.CatalogoDAO;
import DAO.CotizacionDAO;
import DAO.DepartamentoDAO;
import DAO.DetalleCotizacionDAO;
import DAO.DistritoDAO;
import DAO.ProductoDAO;
import DAO.ProveedorDAO;
import DAO.ProvinciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequerimientoServlet extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String strop=request.getParameter("op");
        int op=Integer.parseInt(strop);
        String pagina="";
        
        switch(op)
        {
            case 1:
            {
                CotizacionDAO reqDAO=new CotizacionDAO();
                ArrayList<CotizacionBEAN> listacot=null; 
                listacot=reqDAO.listarCotizacion();
                if(listacot.size()!=0)
                    request.setAttribute("listacotizacion", listacot);
                else
                    request.setAttribute("mensaje","No se ha encontrado ninguna cotización");
                pagina="/GestionCotizacion/frmCotizaciones.jsp";
                break;
            }
            case 2:
            {                
                ProveedorDAO proDAO=new ProveedorDAO();
                int cantproveedores=proDAO.consultarExistenciaProveedor();
                if(cantproveedores==0)
                {
                    request.setAttribute("codprov", "0001");
                }
                else
                {
                    String codpro=proDAO.capturarCodigoProveedor();
                    int cod=Integer.parseInt(codpro);
                    if(cod<10)
                       request.setAttribute("codprov", "000" + codpro);
                    else if(cod<100)
                       request.setAttribute("codprov", "00" + codpro); 
                    else if(cod<1000)
                        request.setAttribute("codprov", "0" + codpro);
                    else if(cod<1000)
                        request.setAttribute("codprov", codpro);
                    
                }
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                request.setAttribute("listadepartamentos", listadep);
                
                CotizacionDAO cotDAO=new CotizacionDAO();
                int cantcotizaciones=cotDAO.consultarExistenciaCotizacion();
                if(cantcotizaciones==0)
                {
                    request.setAttribute("codcot", "0001");
                }
                else
                {
                    String codcot=cotDAO.capturarCodigoCotizacion();
                    int cod=Integer.parseInt(codcot);
                    if(cod<10)
                       request.setAttribute("codcot", "000" + codcot);
                    else if(cod<100)
                       request.setAttribute("codcot", "00" + codcot); 
                    else if(cod<1000)
                        request.setAttribute("codcot", "0" + codcot);
                    else if(cod<1000)
                        request.setAttribute("codcot", codcot);
                    
                   
                }
                request.setAttribute("est", "Borrador");
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 3:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt");   
                strnumi=request.getParameter("txtNumInt");
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                DepartamentoBEAN depBEAN=new DepartamentoBEAN();
                depBEAN.setCodDepartamento(coddep);
                ProvinciaDAO proDAO=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listaprovi=proDAO.listarProvincias(depBEAN);
                request.setAttribute("listaprovincias", listaprovi);
                request.setAttribute("listadepartamentos", listadep);
                
                
                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);CotizacionDAO cotDAO=new CotizacionDAO();
                int cantcotizaciones=cotDAO.consultarExistenciaCotizacion();
                if(cantcotizaciones==0)
                {
                    request.setAttribute("codcot", "0001");
                }
                else
                {
                    String codcoti=cotDAO.capturarCodigoCotizacion();
                    int cod=Integer.parseInt(codcoti);
                    if(cod<10)
                       request.setAttribute("codcot", "000" + codcot);
                    else if(cod<100)
                       request.setAttribute("codcot", "00" + codcot); 
                    else if(cod<1000)
                        request.setAttribute("codcot", "0" + codcot);
                    else if(cod<1000)
                        request.setAttribute("codcot", codcot);
                }
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 4:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt");   
                strnumi=request.getParameter("txtNumInt");
                
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                DepartamentoBEAN depBEAN=new DepartamentoBEAN();
                depBEAN.setCodDepartamento(coddep);
                ProvinciaDAO proDAO=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listaprovi=proDAO.listarProvincias(depBEAN);
                
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                ProvinciaBEAN proBEAN=new ProvinciaBEAN();
                proBEAN.setCodProvincia(codpro);
                DistritoDAO disDAO=new DistritoDAO();
                ArrayList<DistritoBEAN> listadis=disDAO.listarDistritos(depBEAN, proBEAN);
                
                request.setAttribute("listaprovincias", listaprovi);
                request.setAttribute("listadepartamentos", listadep);
                request.setAttribute("listadistritos", listadis);
                
                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("coddis", coddis);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                CotizacionDAO cotDAO=new CotizacionDAO();
                int cantcotizaciones=cotDAO.consultarExistenciaCotizacion();
                if(cantcotizaciones==0)
                {
                    request.setAttribute("codcot", "0001");
                }
                else
                {
                    String codcot=cotDAO.capturarCodigoCotizacion();
                    int cod=Integer.parseInt(codcot);
                    if(cod<10)
                       request.setAttribute("codcot", "000" + codcot);
                    else if(cod<100)
                       request.setAttribute("codcot", "00" + codcot); 
                    else if(cod<1000)
                        request.setAttribute("codcot", "0" + codcot);
                    else if(cod<1000)
                        request.setAttribute("codcot", codcot);
                }
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 5:
            {
                CotizacionDAO reqDAO=new CotizacionDAO();
                ArrayList<CotizacionBEAN> listacot=null; 
                listacot=reqDAO.listarCotizacion();
                if(listacot.size()!=0)
                    request.setAttribute("listacotizacion", listacot);
                else
                    request.setAttribute("mensaje","No se ha encontrado ninguna cotización");
                pagina="/GestionCotizacion/frmCotizaciones.jsp";
                break;
            }
            case 6:
            {
                pagina="/index.jsp";
                break;
            }
            case 7:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                provDAO.agregarProveedor(prov);
                
                request.setAttribute("objeto", prov);
                
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                DepartamentoBEAN depBEAN=new DepartamentoBEAN();
                depBEAN.setCodDepartamento(coddep);
                ProvinciaDAO proDAO=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listaprovi=proDAO.listarProvincias(depBEAN);
                
        
                ProvinciaBEAN proBEAN=new ProvinciaBEAN();
                proBEAN.setCodProvincia(codpro);
                DistritoDAO disDAO=new DistritoDAO();
                ArrayList<DistritoBEAN> listadis=disDAO.listarDistritos(depBEAN, proBEAN);
                
                request.setAttribute("listaprovincias", listaprovi);
                request.setAttribute("listadepartamentos", listadep);
                request.setAttribute("listadistritos", listadis);
                
                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("coddis", coddis);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                CotizacionDAO cotDAO=new CotizacionDAO();
                int cantcotizaciones=cotDAO.consultarExistenciaCotizacion();
                if(cantcotizaciones==0)
                {
                    request.setAttribute("codcot", "0001");
                }
                else
                {
                    String codcot=cotDAO.capturarCodigoCotizacion();
                    int cod=Integer.parseInt(codcot);
                    if(cod<10)
                       request.setAttribute("codcot", "000" + codcot);
                    else if(cod<100)
                       request.setAttribute("codcot", "00" + codcot); 
                    else if(cod<1000)
                        request.setAttribute("codcot", "0" + codcot);
                    else if(cod<1000)
                        request.setAttribute("codcot", codcot);
                }
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String nomprov=provDAO.NombreProveedor(codprov);
                request.setAttribute("nomprov", nomprov);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 8:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                                
                request.setAttribute("objeto", prov);
                
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                DepartamentoBEAN depBEAN=new DepartamentoBEAN();
                depBEAN.setCodDepartamento(coddep);
                ProvinciaDAO proDAO=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listaprovi=proDAO.listarProvincias(depBEAN);
                
        
                ProvinciaBEAN proBEAN=new ProvinciaBEAN();
                proBEAN.setCodProvincia(codpro);
                DistritoDAO disDAO=new DistritoDAO();
                ArrayList<DistritoBEAN> listadis=disDAO.listarDistritos(depBEAN, proBEAN);
                
                request.setAttribute("listaprovincias", listaprovi);
                request.setAttribute("listadepartamentos", listadep);
                request.setAttribute("listadistritos", listadis);
                
                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("coddis", coddis);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                String nomprov=provDAO.NombreProveedor(codprov);
                request.setAttribute("nomprov", nomprov);
                
                String fechae,fechal;
                fechae=request.getParameter("txtFechaE");
                fechal=request.getParameter("txtFechaL");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                CotizacionDAO cotDAO=new CotizacionDAO();
                cotDAO.agregarCotizacion(cot);
                
                request.setAttribute("objetoCot", cot);
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                
                double it=cotDAO.RetornarImporteTotal(coti);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 9:
            {
                String codprov=request.getParameter("cbProveedor");
                request.setAttribute("codprov", codprov);
                CotizacionDAO cotDAO=new CotizacionDAO();
                int cantcotizaciones=cotDAO.consultarExistenciaCotizacion();
                if(cantcotizaciones==0)
                {
                    request.setAttribute("codcot", "0001");
                }
                else
                {
                    String codcot=cotDAO.capturarCodigoCotizacion();
                    int cod=Integer.parseInt(codcot);
                    if(cod<10)
                       request.setAttribute("codcot", "000" + codcot);
                    else if(cod<100)
                       request.setAttribute("codcot", "00" + codcot); 
                    else if(cod<1000)
                        request.setAttribute("codcot", "0" + codcot);
                    else if(cod<1000)
                        request.setAttribute("codcot", codcot);
                }
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                ArrayList<ProveedorBEAN> listaprov=provDAO.listarProveedor();
                request.setAttribute("listaproveedor", listaprov);
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 10:
            {
                ProveedorDAO proDAO=new ProveedorDAO();
                int cantproveedores=proDAO.consultarExistenciaProveedor();
                if(cantproveedores==0)
                {
                    request.setAttribute("codprov", "0001");
                }
                else
                {
                    String codpro=proDAO.capturarCodigoProveedor();
                    int cod=Integer.parseInt(codpro);
                    if(cod<10)
                       request.setAttribute("codprov", "000" + codpro);
                    else if(cod<100)
                       request.setAttribute("codprov", "00" + codpro); 
                    else if(cod<1000)
                        request.setAttribute("codprov", "0" + codpro);
                    else if(cod<1000)
                        request.setAttribute("codprov", codpro);
                    
                }
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                request.setAttribute("listadepartamentos", listadep);
                
                CotizacionDAO cotDAO=new CotizacionDAO();
                int cantcotizaciones=cotDAO.consultarExistenciaCotizacion();
                if(cantcotizaciones==0)
                {
                    request.setAttribute("codcot", "0001");
                }
                else
                {
                    String codcot=cotDAO.capturarCodigoCotizacion();
                    int cod=Integer.parseInt(codcot);
                    if(cod<10)
                       request.setAttribute("codcot", "000" + codcot);
                    else if(cod<100)
                       request.setAttribute("codcot", "00" + codcot); 
                    else if(cod<1000)
                        request.setAttribute("codcot", "0" + codcot);
                    else if(cod<1000)
                        request.setAttribute("codcot", codcot);
                    
                   
                }
                request.setAttribute("est", "Borrador");
                
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 11:
            {
                String codprov=request.getParameter("cbProveedor");
                request.setAttribute("codprov", codprov);
                CotizacionDAO cotDAO=new CotizacionDAO();
                int cantcotizaciones=cotDAO.consultarExistenciaCotizacion();
                if(cantcotizaciones==0)
                {
                    request.setAttribute("codcot", "0001");
                }
                else
                {
                    String codcot=cotDAO.capturarCodigoCotizacion();
                    int cod=Integer.parseInt(codcot);
                    if(cod<10)
                       request.setAttribute("codcot", "000" + codcot);
                    else if(cod<100)
                       request.setAttribute("codcot", "00" + codcot); 
                    else if(cod<1000)
                        request.setAttribute("codcot", "0" + codcot);
                    else if(cod<1000)
                        request.setAttribute("codcot", codcot); 
                }
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                ArrayList<ProveedorBEAN> listaprov=provDAO.listarProveedor();
                
                
                ProveedorBEAN prov=null;
                prov=provDAO.listarRegistroProveedor(codprov);
                if(prov!=null)
                    request.setAttribute("objetoProv", prov);
                request.setAttribute("listaproveedor", listaprov);
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 12:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                String fechae,fechal;
                fechae=request.getParameter("txtFechaE");
                fechal=request.getParameter("txtFechaL");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                
                
                ProductoDAO proDAO=new ProductoDAO();
                int cantproductos=proDAO.consultarExistenciaProducto();
                if(cantproductos==0)
                {
                    request.setAttribute("codprod", "0001");
                }
                else
                {
                    String codprod=proDAO.capturarCodigoProducto();
                    int cod=Integer.parseInt(codprod);
                    if(cod<10)
                       request.setAttribute("codprod", "000" + codprod);
                    else if(cod<100)
                       request.setAttribute("codprod", "00" + codprod); 
                    else if(cod<1000)
                        request.setAttribute("codprod", "0" + codprod);
                    else if(cod<1000)
                        request.setAttribute("codprod", codprod); 
                }
                
                CatalogoDAO catDAO=new CatalogoDAO();
                int cantcatalogos=catDAO.consultarExistenciaCatalogo();
                if(cantcatalogos==0)
                {
                    request.setAttribute("numcat", "0001");
                }
                else
                {
                    String numcat=catDAO.capturarCodigoCatalogo();
                    int cod=Integer.parseInt(numcat);
                    if(cod<10)
                       request.setAttribute("numcat", "000" + numcat);
                    else if(cod<100)
                       request.setAttribute("numcat", "00" + numcat); 
                    else if(cod<1000)
                        request.setAttribute("numcat", "0" + numcat);
                    else if(cod<1000)
                        request.setAttribute("numcat", numcat); 
                }
                
                pagina="/GestionCotizacion/frmAgregarProductoCotizacion.jsp";
                break;
            }
            case 13:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                                
                request.setAttribute("objeto", prov);
                
                String fechae,fechal;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                request.setAttribute("objetoCot", cot);
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 14:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                               
                request.setAttribute("objeto", prov);
                
                String fechae,fechal;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                request.setAttribute("objetoCot", cot);
                
                String codprod,numcat,nomp,strpre,unid,strcant,feca;
                int cant;
                double ip,pre;
                
                codprod=request.getParameter("codprod");
                numcat=request.getParameter("numcat");
                nomp=request.getParameter("txtNom");
                strcant=request.getParameter("txtCantidad");
                cant=Integer.parseInt(strcant);
                unid=request.getParameter("cbUnidad");
                strpre=request.getParameter("txtPrecio");
                pre=Double.parseDouble(strpre);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                feca=detDAO.fechaActual();
                ip=cant*pre;
                
                ProductoBEAN prod=new ProductoBEAN();
                prod.setCodProducto(codprod);
                prod.setNombre(nomp);
                
                DetalleCotizacionBEAN det=new DetalleCotizacionBEAN();
                det.setCantidad(cant);
                det.setCodCotizacion(codcot);
                det.setCodProducto(codprod);
                det.setImporteParcial(ip);
                det.setNomProducto(nomp);
                det.setPrecioUnitario(pre);
                det.setUnidadMedida(unid);
                
                CatalogoBEAN cat=new CatalogoBEAN();
                cat.setCodProducto(codprod);
                cat.setCodProveedor(codprov);
                cat.setCostoUnitario(pre);
                cat.setFechaRegistro(fechae);
                cat.setNumCatalogo(numcat);
                cat.setUnidadMedida(unid);
                
                ProductoDAO prodDAO=new ProductoDAO();
                prodDAO.agregarProductoRequerido(prod);
                
                DetalleCotizacionDAO detalDAO=new DetalleCotizacionDAO();
                detalDAO.agregarDetalleCotizacion(det);
                
                CatalogoDAO catDAO=new CatalogoDAO();
                catDAO.agregarCatalogo(cat);
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detaDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detaDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 15:
            {
                String codcot=request.getParameter("codcot");
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                String est="Enviado";
                
                CotizacionBEAN cotBEAN=new CotizacionBEAN();
                cotBEAN.setCodCotizacion(codcot);
                cotBEAN.setImporteTotal(it);
                cotBEAN.setEstado(est);
                
                CotizacionDAO cotiDAO=new CotizacionDAO();
                cotiDAO.actualizarCotizacionEnviada(cotBEAN);
                
                CotizacionDAO reqDAO=new CotizacionDAO();
                ArrayList<CotizacionBEAN> listacot=null; 
                listacot=reqDAO.listarCotizacion();
                if(listacot.size()!=0)
                    request.setAttribute("listacotizacion", listacot);
                else
                    request.setAttribute("mensaje","No se ha encontrado ninguna cotización");
                pagina="/GestionCotizacion/frmCotizaciones.jsp";
                break;
            }
            case 16:
            {
                String codcot=request.getParameter("sel");
                CotizacionDAO cotDAO=new CotizacionDAO();
                String codprov=cotDAO.capturarCodigoProveedor(codcot);
                
                CotizacionBEAN cot=null; 
                cot=cotDAO.listarRegistroCotizacion(codcot);
                request.setAttribute("cot", cot);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                ProveedorBEAN prov=null;
                prov=provDAO.listarRegistroProveedor(codprov);
                request.setAttribute("prov", prov);
                
                CotizacionBEAN cotBEAN=new CotizacionBEAN();
                cotBEAN.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadet=null; 
                listadet=detDAO.listarDetalleCotizacion(cotBEAN);
                if(listadet.size()!=0)
                    request.setAttribute("listadet", listadet);
                else
                    request.setAttribute("mensaje","No se ha encontrado ningún producto");

                pagina="/GestionCotizacion/frmDetalleCotizacion.jsp";
                break;
            }
            case 17:
            {
                CotizacionDAO reqDAO=new CotizacionDAO();
                ArrayList<CotizacionBEAN> listacot=null; 
                listacot=reqDAO.listarCotizacion();
                if(listacot.size()!=0)
                    request.setAttribute("listacotizacion", listacot);
                else
                    request.setAttribute("mensaje","No se ha encontrado ninguna cotización");
                pagina="/GestionCotizacion/frmCotizaciones.jsp";
                break;
            }
            case 18:
            {
                String codprod=request.getParameter("cbProducto");
                request.setAttribute("codprod", codprod);
                
                ProductoDAO prodDAO=new ProductoDAO();
                ArrayList<ProductoBEAN> listaprod=prodDAO.listarProductoComboBox();
                request.setAttribute("listaproducto", listaprod);
                
                String unid,cant,pre;
                unid=request.getParameter("cbUnidad");
                cant=request.getParameter("txtCantidad");
                pre=request.getParameter("txtPrecio");
                
                request.setAttribute("unid",unid );
                request.setAttribute("cant",cant );
                request.setAttribute("pre",pre );
                
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                dir=request.getParameter("dir");
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                
                String fechae,fechal,numcat;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                numcat=request.getParameter("numcat");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                request.setAttribute("numcat",numcat );
                
                pagina="/GestionCotizacion/frmAgregarProductoCotizacion.jsp";
                break;
            }
            case 19:
            {
                String codprod=request.getParameter("cbProducto");
                request.setAttribute("codprod", codprod);
                
                ProductoDAO prodDAO=new ProductoDAO();
                ArrayList<ProductoBEAN> listaprod=prodDAO.listarProductoComboBox();
                request.setAttribute("listaproducto", listaprod);

                ProductoBEAN prodBEAN=null;
                prodBEAN=prodDAO.listarRegistroProducto(codprod);
                if(prodBEAN!=null)
                    request.setAttribute("objetoProd", prodBEAN);
                
                String unid,cant,pre;
                unid=request.getParameter("cbUnidad");
                cant=request.getParameter("txtCantidad");
                pre=request.getParameter("txtPrecio");
                
                request.setAttribute("unid",unid );
                request.setAttribute("cant",cant );
                request.setAttribute("pre",pre );
                
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                dir=request.getParameter("dir");
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                
                String fechae,fechal,numcat;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                numcat=request.getParameter("numcat");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                request.setAttribute("numcat",numcat );
                
                pagina="/GestionCotizacion/frmAgregarProductoCotizacion.jsp";
                break;
                
            }
            case 20:
            {
                ProductoDAO proDAO=new ProductoDAO();
                int cantproductos=proDAO.consultarExistenciaProducto();
                if(cantproductos==0)
                {
                    request.setAttribute("codprod", "0001");
                }
                else
                {
                    String codprod=proDAO.capturarCodigoProducto();
                    int cod=Integer.parseInt(codprod);
                    if(cod<10)
                       request.setAttribute("codprod", "000" + codprod);
                    else if(cod<100)
                       request.setAttribute("codprod", "00" + codprod); 
                    else if(cod<1000)
                        request.setAttribute("codprod", "0" + codprod);
                    else if(cod<1000)
                        request.setAttribute("codprod", codprod); 
                }

                
                
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                dir=request.getParameter("dir");
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                
                String fechae,fechal,numcat;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                numcat=request.getParameter("numcat");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                request.setAttribute("numcat",numcat );
                
                pagina="/GestionCotizacion/frmAgregarProductoCotizacion.jsp";
                break;
            }
            case 21:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                                
                request.setAttribute("objeto", prov);

                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("coddis", coddis);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                String nomprov=provDAO.NombreProveedor(codprov);
                request.setAttribute("nomprov", nomprov);
                
                String fechae,fechal;
                fechae=request.getParameter("txtFechaE");
                fechal=request.getParameter("txtFechaL");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);

                request.setAttribute("objetoCot", cot);
                //
                String codprod=request.getParameter("sel");
                DetalleCotizacionBEAN det=new DetalleCotizacionBEAN();
                det.setCodCotizacion(codcot);
                det.setCodProducto(codprod);
                DetalleCotizacionDAO detaDAO=new DetalleCotizacionDAO();
                detaDAO.eliminarDetalleCotizacion(det);
                
                CatalogoBEAN catBEAN=new CatalogoBEAN();
                catBEAN.setCodProveedor(codprov);
                catBEAN.setCodProducto(codprod);
                CatalogoDAO catDAO=new CatalogoDAO();
                catDAO.eliminarCatalogo(catBEAN);
                //
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(coti);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 22:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                String fechae,fechal;
                fechae=request.getParameter("txtFechaE");
                fechal=request.getParameter("txtFechaL");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                
                String codprod=request.getParameter("sel");
                
                DetalleCotizacionBEAN detBEAN=new DetalleCotizacionBEAN();
                detBEAN.setCodProducto(codprod);
                detBEAN.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                DetalleCotizacionBEAN objdet=detDAO.retornarObjeto(detBEAN);
                request.setAttribute("objetodetalle", objdet);/////
                
                CatalogoBEAN catBEAN=new CatalogoBEAN();
                catBEAN.setCodProveedor(codprov);
                catBEAN.setCodProducto(codprod);
                CatalogoDAO cataDAO=new CatalogoDAO();
                String numcat=cataDAO.retornarNumeroCatalogo(catBEAN);
                
                request.setAttribute("codprod", codprod);
                request.setAttribute("numcat", numcat);

                pagina="/GestionCotizacion/frmModificarProductoCotizacion.jsp";
                break;
            }
            case 23:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                                
                request.setAttribute("objeto", prov);
                
                String fechae,fechal;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                request.setAttribute("objetoCot", cot);
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 24:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                               
                request.setAttribute("objeto", prov);
                
                String fechae,fechal;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                request.setAttribute("objetoCot", cot);
                //
                String codprod,numcat,nomp,strpre,unid,strcant,feca;
                int cant;
                double ip,pre;
                
                codprod=request.getParameter("codprod");
                numcat=request.getParameter("numcat");
                nomp=request.getParameter("txtNom");
                strcant=request.getParameter("txtCantidad");
                cant=Integer.parseInt(strcant);
                unid=request.getParameter("cbUnidad");
                strpre=request.getParameter("txtPrecio");
                pre=Double.parseDouble(strpre);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                feca=detDAO.fechaActual();
                ip=cant*pre;
                
                DetalleCotizacionBEAN det=new DetalleCotizacionBEAN();
                det.setCantidad(cant);
                det.setCodCotizacion(codcot);
                det.setCodProducto(codprod);
                det.setImporteParcial(ip);
                det.setNomProducto(nomp);
                det.setPrecioUnitario(pre);
                det.setUnidadMedida(unid);
                
                CatalogoBEAN cat=new CatalogoBEAN();
                cat.setCodProducto(codprod);
                cat.setCodProveedor(codprov);
                cat.setCostoUnitario(pre);
                cat.setFechaRegistro(fechae);
                cat.setNumCatalogo(numcat);
                cat.setUnidadMedida(unid);

                
                DetalleCotizacionDAO detalDAO=new DetalleCotizacionDAO();
                detalDAO.modificarDetalleCotizacion(det);
                
                CatalogoDAO catDAO=new CatalogoDAO();
                catDAO.modificarCatalogo(cat);
                ////
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detaDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detaDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmAgregarCotizacion.jsp";
                break;
            }
            case 25:
            {
                String codcot=request.getParameter("codcotizacion");
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                CotizacionDAO reqDAO=new CotizacionDAO();
                int i=reqDAO.eliminarCotizacion(cot);
                if(i==0)
                    request.setAttribute("mensaje", "Usted no tiene permitido eliminar este registro");
                
                ArrayList<CotizacionBEAN> listacot=null; 
                listacot=reqDAO.listarCotizacion();
                if(listacot.size()!=0)
                    request.setAttribute("listacotizacion", listacot);
                else
                    request.setAttribute("mensaje","No se ha encontrado ninguna cotización");
                pagina="/GestionCotizacion/frmCotizaciones.jsp";
                break;
            }
            case 26:
            {
                String codcot=request.getParameter("codcotizacion");
                String codprov=request.getParameter("codproveedor");
                String est=request.getParameter("estado");
                request.setAttribute("codprov", codprov);
                request.setAttribute("codcot", codcot);
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                ProveedorBEAN prov=provDAO.listarRegistroProveedor(codprov);
                
                request.setAttribute("nom", prov.getNombre());
                request.setAttribute("ruc", prov.getRuc());
                request.setAttribute("email", prov.getEmail());
                request.setAttribute("calle", prov.getCalle());
                request.setAttribute("nume", prov.getNumExterno() + "");
                request.setAttribute("numi", prov.getNumInterno() + "");
                request.setAttribute("tel", prov.getTelefono());
                
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                request.setAttribute("listadepartamentos", listadep);

                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 27:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt");   
                strnumi=request.getParameter("txtNumInt");
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                DepartamentoBEAN depBEAN=new DepartamentoBEAN();
                depBEAN.setCodDepartamento(coddep);
                ProvinciaDAO proDAO=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listaprovi=proDAO.listarProvincias(depBEAN);
                request.setAttribute("listaprovincias", listaprovi);
                request.setAttribute("listadepartamentos", listadep);
                
                
                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 28:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt");   
                strnumi=request.getParameter("txtNumInt");
                
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                DepartamentoBEAN depBEAN=new DepartamentoBEAN();
                depBEAN.setCodDepartamento(coddep);
                ProvinciaDAO proDAO=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listaprovi=proDAO.listarProvincias(depBEAN);
                
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                ProvinciaBEAN proBEAN=new ProvinciaBEAN();
                proBEAN.setCodProvincia(codpro);
                DistritoDAO disDAO=new DistritoDAO();
                ArrayList<DistritoBEAN> listadis=disDAO.listarDistritos(depBEAN, proBEAN);
                
                request.setAttribute("listaprovincias", listaprovi);
                request.setAttribute("listadepartamentos", listadep);
                request.setAttribute("listadistritos", listadis);
                
                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("coddis", coddis);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 29:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                provDAO.modificarProveedor(prov);
                
                request.setAttribute("objeto", prov);
                
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                DepartamentoBEAN depBEAN=new DepartamentoBEAN();
                depBEAN.setCodDepartamento(coddep);
                ProvinciaDAO proDAO=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listaprovi=proDAO.listarProvincias(depBEAN);
                
        
                ProvinciaBEAN proBEAN=new ProvinciaBEAN();
                proBEAN.setCodProvincia(codpro);
                DistritoDAO disDAO=new DistritoDAO();
                ArrayList<DistritoBEAN> listadis=disDAO.listarDistritos(depBEAN, proBEAN);
                
                request.setAttribute("listaprovincias", listaprovi);
                request.setAttribute("listadepartamentos", listadep);
                request.setAttribute("listadistritos", listadis);
                
                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("coddis", coddis);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String nomprov=provDAO.NombreProveedor(codprov);
                request.setAttribute("nomprov", nomprov);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 30:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                                
                request.setAttribute("objeto", prov);
                
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                
                
                DepartamentoBEAN depBEAN=new DepartamentoBEAN();
                depBEAN.setCodDepartamento(coddep);
                ProvinciaDAO proDAO=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listaprovi=proDAO.listarProvincias(depBEAN);
                
        
                ProvinciaBEAN proBEAN=new ProvinciaBEAN();
                proBEAN.setCodProvincia(codpro);
                DistritoDAO disDAO=new DistritoDAO();
                ArrayList<DistritoBEAN> listadis=disDAO.listarDistritos(depBEAN, proBEAN);
                
                request.setAttribute("listaprovincias", listaprovi);
                request.setAttribute("listadepartamentos", listadep);
                request.setAttribute("listadistritos", listadis);
                
                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("coddis", coddis);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("cbEstado");
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                String nomprov=provDAO.NombreProveedor(codprov);
                request.setAttribute("nomprov", nomprov);
                
                String fechae,fechal;
                fechae=request.getParameter("txtFechaE");
                fechal=request.getParameter("txtFechaL");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                CotizacionDAO cotDAO=new CotizacionDAO();
                cotDAO.modificarCotizacion(cot);
                
                request.setAttribute("objetoCot", cot);
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                
                double it=cotDAO.RetornarImporteTotal(coti);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 31:
            {
                String codprov=request.getParameter("cbProveedor");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                ArrayList<ProveedorBEAN> listaprov=provDAO.listarProveedor();
                request.setAttribute("listaproveedor", listaprov);
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 32:
            {
                /*ProveedorDAO proDAO=new ProveedorDAO();
                int cantproveedores=proDAO.consultarExistenciaProveedor();
                if(cantproveedores==0)
                {
                    request.setAttribute("codprov", "0001");
                }
                else
                {
                    String codpro=proDAO.capturarCodigoProveedor();
                    int cod=Integer.parseInt(codpro);
                    if(cod<10)
                       request.setAttribute("codprov", "000" + codpro);
                    else if(cod<100)
                       request.setAttribute("codprov", "00" + codpro); 
                    else if(cod<1000)
                        request.setAttribute("codprov", "0" + codpro);
                    else if(cod<1000)
                        request.setAttribute("codprov", codpro);
                    
                }*/
                String codprov=request.getParameter("cbProveedor");
                request.setAttribute("codprov", codprov);
                DepartamentoDAO depDAO=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> listadep=depDAO.listarDepartamentos();
                request.setAttribute("listadepartamentos", listadep);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 33:
            {
                String codprov=request.getParameter("cbProveedor");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                ArrayList<ProveedorBEAN> listaprov=provDAO.listarProveedor();
                
                
                ProveedorBEAN prov=null;
                prov=provDAO.listarRegistroProveedor(codprov);
                if(prov!=null)
                    request.setAttribute("objetoProv", prov);
                request.setAttribute("listaproveedor", listaprov);
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 34:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                String fechae,fechal;
                fechae=request.getParameter("txtFechaE");
                fechal=request.getParameter("txtFechaL");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                
                
                ProductoDAO proDAO=new ProductoDAO();
                int cantproductos=proDAO.consultarExistenciaProducto();
                if(cantproductos==0)
                {
                    request.setAttribute("codprod", "0001");
                }
                else
                {
                    String codprod=proDAO.capturarCodigoProducto();
                    int cod=Integer.parseInt(codprod);
                    if(cod<10)
                       request.setAttribute("codprod", "000" + codprod);
                    else if(cod<100)
                       request.setAttribute("codprod", "00" + codprod); 
                    else if(cod<1000)
                        request.setAttribute("codprod", "0" + codprod);
                    else if(cod<1000)
                        request.setAttribute("codprod", codprod); 
                }
                
                CatalogoDAO catDAO=new CatalogoDAO();
                int cantcatalogos=catDAO.consultarExistenciaCatalogo();
                if(cantcatalogos==0)
                {
                    request.setAttribute("numcat", "0001");
                }
                else
                {
                    String numcat=catDAO.capturarCodigoCatalogo();
                    int cod=Integer.parseInt(numcat);
                    if(cod<10)
                       request.setAttribute("numcat", "000" + numcat);
                    else if(cod<100)
                       request.setAttribute("numcat", "00" + numcat); 
                    else if(cod<1000)
                        request.setAttribute("numcat", "0" + numcat);
                    else if(cod<1000)
                        request.setAttribute("numcat", numcat); 
                }
                
                pagina="/GestionCotizacion/frmAgregarProductoCotizacionModificada.jsp";
                break;
            }
            case 35:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                                
                request.setAttribute("objeto", prov);
                
                String fechae,fechal;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                request.setAttribute("objetoCot", cot);
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 36:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                               
                request.setAttribute("objeto", prov);
                
                String fechae,fechal;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                request.setAttribute("objetoCot", cot);
                
                String codprod,numcat,nomp,strpre,unid,strcant,feca;
                int cant;
                double ip,pre;
                
                codprod=request.getParameter("codprod");
                numcat=request.getParameter("numcat");
                nomp=request.getParameter("txtNom");
                strcant=request.getParameter("txtCantidad");
                cant=Integer.parseInt(strcant);
                unid=request.getParameter("cbUnidad");
                strpre=request.getParameter("txtPrecio");
                pre=Double.parseDouble(strpre);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                feca=detDAO.fechaActual();
                ip=cant*pre;
                
                ProductoBEAN prod=new ProductoBEAN();
                prod.setCodProducto(codprod);
                prod.setNombre(nomp);
                
                DetalleCotizacionBEAN det=new DetalleCotizacionBEAN();
                det.setCantidad(cant);
                det.setCodCotizacion(codcot);
                det.setCodProducto(codprod);
                det.setImporteParcial(ip);
                det.setNomProducto(nomp);
                det.setPrecioUnitario(pre);
                det.setUnidadMedida(unid);
                
                CatalogoBEAN cat=new CatalogoBEAN();
                cat.setCodProducto(codprod);
                cat.setCodProveedor(codprov);
                cat.setCostoUnitario(pre);
                cat.setFechaRegistro(fechae);
                cat.setNumCatalogo(numcat);
                cat.setUnidadMedida(unid);
                
                ProductoDAO prodDAO=new ProductoDAO();
                prodDAO.agregarProductoRequerido(prod);
                
                DetalleCotizacionDAO detalDAO=new DetalleCotizacionDAO();
                detalDAO.agregarDetalleCotizacion(det);
                
                CatalogoDAO catDAO=new CatalogoDAO();
                catDAO.agregarCatalogo(cat);
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detaDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detaDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 37:
            {
                String codprod=request.getParameter("cbProducto");
                request.setAttribute("codprod", codprod);
                
                ProductoDAO prodDAO=new ProductoDAO();
                ArrayList<ProductoBEAN> listaprod=prodDAO.listarProductoComboBox();
                request.setAttribute("listaproducto", listaprod);
                
                String unid,cant,pre;
                unid=request.getParameter("cbUnidad");
                cant=request.getParameter("txtCantidad");
                pre=request.getParameter("txtPrecio");
                
                request.setAttribute("unid",unid );
                request.setAttribute("cant",cant );
                request.setAttribute("pre",pre );
                
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                dir=request.getParameter("dir");
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                
                String fechae,fechal,numcat;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                numcat=request.getParameter("numcat");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                request.setAttribute("numcat",numcat );
                
                pagina="/GestionCotizacion/frmAgregarProductoCotizacionModificada.jsp";
                break;
            }
            case 38:
            {
                String codprod=request.getParameter("cbProducto");
                request.setAttribute("codprod", codprod);
                
                ProductoDAO prodDAO=new ProductoDAO();
                ArrayList<ProductoBEAN> listaprod=prodDAO.listarProductoComboBox();
                request.setAttribute("listaproducto", listaprod);

                ProductoBEAN prodBEAN=null;
                prodBEAN=prodDAO.listarRegistroProducto(codprod);
                if(prodBEAN!=null)
                    request.setAttribute("objetoProd", prodBEAN);
                
                String unid,cant,pre;
                unid=request.getParameter("cbUnidad");
                cant=request.getParameter("txtCantidad");
                pre=request.getParameter("txtPrecio");
                
                request.setAttribute("unid",unid );
                request.setAttribute("cant",cant );
                request.setAttribute("pre",pre );
                
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                dir=request.getParameter("dir");
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                
                String fechae,fechal,numcat;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                numcat=request.getParameter("numcat");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                request.setAttribute("numcat",numcat );
                
                pagina="/GestionCotizacion/frmAgregarProductoCotizacionModificada.jsp";
                break;
                
            }
            case 39:
            {
                ProductoDAO proDAO=new ProductoDAO();
                int cantproductos=proDAO.consultarExistenciaProducto();
                if(cantproductos==0)
                {
                    request.setAttribute("codprod", "0001");
                }
                else
                {
                    String codprod=proDAO.capturarCodigoProducto();
                    int cod=Integer.parseInt(codprod);
                    if(cod<10)
                       request.setAttribute("codprod", "000" + codprod);
                    else if(cod<100)
                       request.setAttribute("codprod", "00" + codprod); 
                    else if(cod<1000)
                        request.setAttribute("codprod", "0" + codprod);
                    else if(cod<1000)
                        request.setAttribute("codprod", codprod); 
                }

                
                
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                dir=request.getParameter("dir");
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                
                String fechae,fechal,numcat;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                numcat=request.getParameter("numcat");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                request.setAttribute("numcat",numcat );
                
                pagina="/GestionCotizacion/frmAgregarProductoCotizacionModificada.jsp";
                break;
            }
            case 40:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                                
                request.setAttribute("objeto", prov);

                request.setAttribute("nume", strnume);
                request.setAttribute("numi", strnumi);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro", codpro);
                request.setAttribute("coddis", coddis);
                request.setAttribute("calle", calle);
                request.setAttribute("tel", tel);
                request.setAttribute("ruc", ruc);
                request.setAttribute("nom", nom);
                request.setAttribute("email", email);
                
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                ProveedorDAO provDAO=new ProveedorDAO();
                String nomprov=provDAO.NombreProveedor(codprov);
                request.setAttribute("nomprov", nomprov);
                
                String fechae,fechal;
                fechae=request.getParameter("txtFechaE");
                fechal=request.getParameter("txtFechaL");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);

                request.setAttribute("objetoCot", cot);
                //
                String codprod=request.getParameter("sel");
                DetalleCotizacionBEAN det=new DetalleCotizacionBEAN();
                det.setCodCotizacion(codcot);
                det.setCodProducto(codprod);
                DetalleCotizacionDAO detaDAO=new DetalleCotizacionDAO();
                detaDAO.eliminarDetalleCotizacion(det);
                
                CatalogoBEAN catBEAN=new CatalogoBEAN();
                catBEAN.setCodProveedor(codprov);
                catBEAN.setCodProducto(codprod);
                CatalogoDAO catDAO=new CatalogoDAO();
                catDAO.eliminarCatalogo(catBEAN);
                //
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(coti);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 41:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("cbDepartamento");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("txtNom");
                strcodpro=request.getParameter("cbProvincia");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("txtRuc");
                email=request.getParameter("txtEmail");
                calle=request.getParameter("txtCalle");
                tel=request.getParameter("txtTel");
                strnume=request.getParameter("txtNumExt"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("txtNumInt");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("cbDistrito");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                String fechae,fechal;
                fechae=request.getParameter("txtFechaE");
                fechal=request.getParameter("txtFechaL");
                
                request.setAttribute("dir",dir );
                request.setAttribute("nom",nom );
                request.setAttribute("ruc",ruc );
                request.setAttribute("tel",tel );
                request.setAttribute("email", email);
                request.setAttribute("calle", calle);
                request.setAttribute("coddep", coddep);
                request.setAttribute("codpro",codpro );
                request.setAttribute("coddis",coddis );
                request.setAttribute("nume", nume);
                request.setAttribute("numi", numi);
                request.setAttribute("fechae", fechae);
                request.setAttribute("fechal",fechal );
                
                String codprod=request.getParameter("sel");
                
                DetalleCotizacionBEAN detBEAN=new DetalleCotizacionBEAN();
                detBEAN.setCodProducto(codprod);
                detBEAN.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                DetalleCotizacionBEAN objdet=detDAO.retornarObjeto(detBEAN);
                request.setAttribute("objetodetalle", objdet);/////
                
                CatalogoBEAN catBEAN=new CatalogoBEAN();
                catBEAN.setCodProveedor(codprov);
                catBEAN.setCodProducto(codprod);
                CatalogoDAO cataDAO=new CatalogoDAO();
                String numcat=cataDAO.retornarNumeroCatalogo(catBEAN);
                
                request.setAttribute("codprod", codprod);
                request.setAttribute("numcat", numcat);

                pagina="/GestionCotizacion/frmModificarProductoCotizacionModificada.jsp";
                break;
            }
            case 42:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                                
                request.setAttribute("objeto", prov);
                
                String fechae,fechal;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                request.setAttribute("objetoCot", cot);
                
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 43:
            {
                String codprov=request.getParameter("codprov");
                request.setAttribute("codprov", codprov);
                String codcot=request.getParameter("codcot");
                request.setAttribute("codcot", codcot);
                String est=request.getParameter("est");
                request.setAttribute("est", est);
                
                String dir,nom,ruc,tel,email,strcoddep,strcodpro,strcoddis,calle,strnume,strnumi;
                int coddep,codpro,coddis,nume,numi;
                strcoddep=request.getParameter("coddep");
                coddep=Integer.parseInt(strcoddep);
                nom=request.getParameter("nom");
                strcodpro=request.getParameter("codpro");
                codpro=Integer.parseInt(strcodpro);
                ruc=request.getParameter("ruc");
                email=request.getParameter("email");
                calle=request.getParameter("calle");
                tel=request.getParameter("tel");
                strnume=request.getParameter("nume"); 
                nume=Integer.parseInt(strnume);
                strnumi=request.getParameter("numi");
                numi=Integer.parseInt(strnumi);
                strcoddis=request.getParameter("coddis");
                coddis=Integer.parseInt(strcoddis);
                dir=calle+ " " +nume+numi;
                
                ProveedorBEAN prov=new ProveedorBEAN();
                prov.setCalle(calle);
                prov.setCodDepartamento(coddep);
                prov.setCodDistrito(coddis);
                prov.setCodProveedor(codprov);
                prov.setCodProvincia(codpro);
                prov.setDireccion(dir);
                prov.setEmail(email);
                prov.setNombre(nom);
                prov.setNumExterno(nume);
                prov.setNumInterno(numi);
                prov.setRuc(ruc);
                prov.setTelefono(tel);
                               
                request.setAttribute("objeto", prov);
                
                String fechae,fechal;
                fechae=request.getParameter("fechae");
                fechal=request.getParameter("fechal");
                
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setCodProveedor(codprov);
                cot.setEstado(est);
                cot.setFechaLimite(fechal);
                cot.setFechaRegistro(fechae);
                
                request.setAttribute("objetoCot", cot);
                //
                String codprod,numcat,nomp,strpre,unid,strcant,feca;
                int cant;
                double ip,pre;
                
                codprod=request.getParameter("codprod");
                numcat=request.getParameter("numcat");
                nomp=request.getParameter("txtNom");
                strcant=request.getParameter("txtCantidad");
                cant=Integer.parseInt(strcant);
                unid=request.getParameter("cbUnidad");
                strpre=request.getParameter("txtPrecio");
                pre=Double.parseDouble(strpre);
                DetalleCotizacionDAO detDAO=new DetalleCotizacionDAO();
                feca=detDAO.fechaActual();
                ip=cant*pre;
                
                DetalleCotizacionBEAN det=new DetalleCotizacionBEAN();
                det.setCantidad(cant);
                det.setCodCotizacion(codcot);
                det.setCodProducto(codprod);
                det.setImporteParcial(ip);
                det.setNomProducto(nomp);
                det.setPrecioUnitario(pre);
                det.setUnidadMedida(unid);
                
                CatalogoBEAN cat=new CatalogoBEAN();
                cat.setCodProducto(codprod);
                cat.setCodProveedor(codprov);
                cat.setCostoUnitario(pre);
                cat.setFechaRegistro(fechae);
                cat.setNumCatalogo(numcat);
                cat.setUnidadMedida(unid);

                
                DetalleCotizacionDAO detalDAO=new DetalleCotizacionDAO();
                detalDAO.modificarDetalleCotizacion(det);
                
                CatalogoDAO catDAO=new CatalogoDAO();
                catDAO.modificarCatalogo(cat);
                ////
                CotizacionBEAN coti=new CotizacionBEAN();
                coti.setCodCotizacion(codcot);
                DetalleCotizacionDAO detaDAO=new DetalleCotizacionDAO();
                ArrayList<DetalleCotizacionBEAN> listadetalle=null;
                listadetalle=detaDAO.listarDetalleCotizacion(coti);
                if(listadetalle.size()!=0)
                    request.setAttribute("listadetalle", listadetalle);
                CotizacionDAO cotDAO=new CotizacionDAO();
                double it=cotDAO.RetornarImporteTotal(cot);
                request.setAttribute("importeTotal", it);
                
                pagina="/GestionCotizacion/frmModificarCotizacion.jsp";
                break;
            }
            case 44:
            {
                String estado=request.getParameter("cbEstado");
                String codcot=request.getParameter("sel");
                CotizacionBEAN cot=new CotizacionBEAN();
                cot.setCodCotizacion(codcot);
                cot.setEstado(estado);
                CotizacionDAO cotDAO=new CotizacionDAO();
                cotDAO.actualizarEstado(cot);
                
                
                CotizacionDAO reqDAO=new CotizacionDAO();
                ArrayList<CotizacionBEAN> listacot=null; 
                listacot=reqDAO.listarCotizacion();
                if(listacot.size()!=0)
                    request.setAttribute("listacotizacion", listacot);
                else
                    request.setAttribute("mensaje","No se ha encontrado ninguna cotización");
                pagina="/GestionCotizacion/frmCotizaciones.jsp";
                break;
            }
            
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
