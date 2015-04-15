package com.pe.saga.reclamos.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.pe.saga.reclamos.domain.AdmUbigeo;
import com.pe.saga.reclamos.domain.Reclamo;
import com.pe.saga.reclamos.service.ReclamosSesionBeanLocal;


/**
 * Managed bean for the ReclamosSesionBeanLocal session bean.
 * @generated DT_ID=none */

public class ReclamoController implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
    private ReclamosSesionBeanLocal ejbSesion;  
    
    private Integer tipoDoc;
    private String numDoc;
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private Integer tipoRespuesta;
    private String direccion;   
    private String telefono;
    private String email;
    private Integer tipoRegistro;//bien o servicio
    private BigDecimal montoReclamado;
    private String descproducto;
    private Integer tipoReclamo;
    private String descReclamo;
    private String descPedido;
    private boolean menorEdad;
   //apoderado
    private Integer tipoDocApod;
    private String numDocApod;
    private String nombresApod;
    private String apellidoPatApod;
    private String apellidoMatApod; 
    
    private List<SelectItem> listaDpto= new ArrayList<SelectItem>();	
	private String codDepto;    
    
    private List<SelectItem> listaProv= new ArrayList<SelectItem>();    
    private String codProvincia;    
    
    private List<SelectItem> listaDistrito= new ArrayList<SelectItem>();
    private String codDistrito;

    private String flagMenorEdad;
    
    
    @PostConstruct
    public void init(){
    	listaDpto.clear(); 
    	flagMenorEdad = "0";
    	try {
    		List<AdmUbigeo> listaD = ejbSesion.listarDepartamentos();
    		for (AdmUbigeo a : listaD) {		
        		listaDpto.add(new SelectItem(a.getCodUbigeo(), a.getNomUbigeo()));	
    		}    		
		} catch (Exception e) {
			e.printStackTrace();
			
		}    	
    }
    
   
    
    public void selectProvincia(ValueChangeEvent event){
    	listaProv.clear();
    	listaDistrito.clear();
    	try {    		
    		codDepto = event.getNewValue().toString();
    		System.out.println("Codigo departamento seleccionado:  "+codDepto);
    		if(codDepto!=null && codDepto.length()>0){
    			String cad3 = codDepto.substring(0,3);  
    			System.out.println("cod a enviar depto:  "+cad3); 
    			List<AdmUbigeo> listaPro = ejbSesion.listarProvincias(cad3);
    			System.out.println("Tamaño de la lista:   "+listaPro.size()); 
        		for (AdmUbigeo a : listaPro) {		
            		listaProv.add(new SelectItem(a.getCodUbigeo(), a.getNomUbigeo()));	
        		}  	
    		}   		
		} catch (Exception e) {
			e.printStackTrace();
		}    		
    }
    
    
    
    public void selectDistrito(ValueChangeEvent event){
    	listaDistrito.clear();
    	try {
    		codProvincia = event.getNewValue().toString();
    		System.out.println("Codigo provincia seleccionado:  "+codProvincia);
    		if(codProvincia!=null && codProvincia.length()>0){
    			String cad4 = codProvincia.substring(0,4);  
    			System.out.println("cod a enviar prov:  "+cad4); 
    			List<AdmUbigeo> listaDist = ejbSesion.listarDistritos(cad4);
        		for (AdmUbigeo a : listaDist) {		
        			listaDistrito.add(new SelectItem(a.getCodUbigeo(), a.getNomUbigeo()));	
        		}  	
    		}   		
		} catch (Exception e) {
			e.printStackTrace();
		}    		
    }
    
    public void selectMenorEdad(ValueChangeEvent event){      	
    	this.nombresApod="";
    	this.apellidoPatApod="";
    	this.apellidoMatApod="";
    	this.numDocApod="";
    	try {      		
    		menorEdad = (Boolean)event.getNewValue(); 
    		System.out.println("valor del menor de edad:  "+menorEdad);  
    		if(menorEdad){
    			flagMenorEdad = "1";	
    		}else{
    			flagMenorEdad = "0";	
    		}   
    		System.out.println("Valor del numero de documeto apodrado:  "+numDocApod); 
		} catch (Exception e) {
			e.printStackTrace();
		}    		
    }
    

   
    public String updateReclamo() {
       /* if (getSelectedReclamo() != null) {
            setSelectedReclamo(getSessionFacade().mergeReclamo(getSelectedReclamo()));
            return "commit";
        }*/
        return null;
    }

    public String createReclamo() {
    	boolean validador = true;
    	FacesMessage msg = null;
    	System.out.println("Ingreando a insertar");
    	System.out.println("Ingreando a insertar cod depato sin seleccionar:  "+codDepto);
    	
    	if(numDoc.length()==0){
    		msg = new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Por favor ingrese el número de Documento.",
			         null);
    		validador = false;
    	}else if(nombres.length()==0){
    		msg = new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Por favor ingrese sus Nombres.",
			         null);
    		validador = false;
    	}else if(apellidoPat.length()==0){
    		msg = new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Por favor ingrese su Apellido Paterno.",
			         null);
    		validador = false;
    	}else if(codDepto==null){
    		msg = new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Por favor Seleccione un Depto.",
			         null);
    		validador = false;
    	} else if(codProvincia==null){
    		msg = new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Por favor Seleccione una Provincia.",
			         null);
    		validador = false;
    	} else if(codDistrito==null){
    		msg = new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Por favor Seleccione un Distrito.",
			         null);
    		validador = false;
    	}	  	
    	
    	if(validador){
    		try {		
        		Reclamo r = new Reclamo();
        		System.out.println("empesando a setear datos");
        		r.setTipoDocumento(tipoDoc); 
        		r.setDocumento(numDoc);
        		r.setNombres(nombres);
        		r.setApellidos(apellidoPat);
        		r.setApMaterno(apellidoMat);
        		r.setTipoRespuesta(tipoRespuesta);
        		r.setDireccion(direccion);
        		System.out.println("codigo de distrito: "+codDistrito);
        		r.setUbigeo(codDistrito); 
        		r.setTelefono(telefono);
        		r.setEmail(email);
        		r.setTipoRegistro(tipoRegistro);
        		r.setDescripcionProducto(descproducto);
        		r.setTipoReclamo(tipoReclamo);
        		r.setDetalleReclamo(descReclamo);
        		r.setRecPedido(descPedido);
        		r.setEstado("R");    		
        		r.setFechaReclamo(new Date()); 
        		if(menorEdad){
        			r.setMenorEdad(1);
        			r.setTipoDocApoderado(tipoDocApod);
        			r.setDocumentoApoderado(numDocApod); 
        			r.setNombresApoderado(nombresApod);
        			r.setApellidosApoderado(apellidoPatApod);
        			r.setApMaternoApoderado(apellidoMatApod); 
        		}else{
        			r.setMenorEdad(0);
        		}
        		System.out.println("Dato 1 :  "+r.getMenorEdad());
        		System.out.println("Dato 2 :  "+r.getUbigeo());
        		ejbSesion.persistReclamo(r);
        		//limpiamos los campos
        		limpiarCampos();     
        		msg = new FacesMessage(
    					FacesMessage.SEVERITY_INFO,
    					"Su Reclamo se registró satisfactoriamente.",
    			         null);
        		FacesContext.getCurrentInstance().addMessage(null, msg);
    		} catch (Exception e) {
    			msg = new FacesMessage(
    					FacesMessage.SEVERITY_ERROR,
    					"Ocurrio un error al registrar su reclamo, vuelva a intentarlo mas tarde.",
    			         null);
        		FacesContext.getCurrentInstance().addMessage(null, msg);
        		e.printStackTrace();
    			 return null;	
    		} 
    		return "";
    	}//fin del validador 
    	else{
    		FacesContext.getCurrentInstance().addMessage(null, msg);
        	return null;
    	}    	
    }

    /**
     * @generated DT_ID=none
     */
    public String deleteReclamo() {
       /* if (getSelectedReclamo() != null) {
            getSessionFacade().removeReclamo(getSelectedReclamo());
            return "commit";
        }*/
    	
        return null;
    }

  
    private void limpiarCampos(){
    	this.apellidoMat = "";
    	this.apellidoMatApod = "";
    	this.apellidoPat= "";
    	this.apellidoPatApod= "";
    	this.descPedido="";
    	this.descproducto="";
    	this.descReclamo="";
    	this.direccion="";
    	this.email="";
    	this.montoReclamado=new BigDecimal(0.0);
    	this.nombres="";
    	this.nombresApod= "";
    	this.numDoc="";
    	this.numDocApod= "";
    	this.telefono= ""; 
    	this.codDepto="";
    	this.codDistrito="";
    	this.codProvincia="";
    }
    
    
    
    public List<Reclamo> getReclamoFindAll() {
    	System.out.println("HOLA MUNDO ");
        return ejbSesion.getReclamoFindAll();
    }  
    
    
    
    /***GET y SET**/       
    
	public ReclamosSesionBeanLocal getEjbSesion() {
		return ejbSesion;
	}

	public void setEjbSesion(ReclamosSesionBeanLocal ejbSesion) {
		this.ejbSesion = ejbSesion;
	}

	public Integer getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(Integer tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public Integer getTipoRespuesta() {
		return tipoRespuesta;
	}

	public void setTipoRespuesta(Integer tipoRespuesta) {
		this.tipoRespuesta = tipoRespuesta;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodDepto() {
		return codDepto;
	}

	public void setCodDepto(String codDepto) {
		this.codDepto = codDepto;
	}

	public String getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public String getCodDistrito() {
		return codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public BigDecimal getMontoReclamado() {
		return montoReclamado;
	}

	public void setMontoReclamado(BigDecimal montoReclamado) {
		this.montoReclamado = montoReclamado;
	}

	public String getDescproducto() {
		return descproducto;
	}

	public void setDescproducto(String descproducto) {
		this.descproducto = descproducto;
	}

	public Integer getTipoReclamo() {
		return tipoReclamo;
	}

	public void setTipoReclamo(Integer tipoReclamo) {
		this.tipoReclamo = tipoReclamo;
	}

	public String getDescReclamo() {
		return descReclamo;
	}

	public void setDescReclamo(String descReclamo) {
		this.descReclamo = descReclamo;
	}

	public String getDescPedido() {
		return descPedido;
	}

	public void setDescPedido(String descPedido) {
		this.descPedido = descPedido;
	}
	
	public Integer getTipoDocApod() {
		return tipoDocApod;
	}

	public void setTipoDocApod(Integer tipoDocApod) {
		this.tipoDocApod = tipoDocApod;
	}

	public String getNumDocApod() {
		return numDocApod;
	}

	public void setNumDocApod(String numDocApod) {
		this.numDocApod = numDocApod;
	}

	public String getNombresApod() {
		return nombresApod;
	}

	public void setNombresApod(String nombresApod) {
		this.nombresApod = nombresApod;
	}

	public String getApellidoPatApod() {
		return apellidoPatApod;
	}

	public void setApellidoPatApod(String apellidoPatApod) {
		this.apellidoPatApod = apellidoPatApod;
	}

	public String getApellidoMatApod() {
		return apellidoMatApod;
	}

	public void setApellidoMatApod(String apellidoMatApod) {
		this.apellidoMatApod = apellidoMatApod;
	}
	
	public List<SelectItem> getListaDpto() {		
		return listaDpto;
	}

	public void setListaDpto(List<SelectItem> listaDpto) {
		this.listaDpto = listaDpto;
	}
	
	public List<SelectItem> getListaProv() {		
		return listaProv;
	}

	public void setListaProv(List<SelectItem> listaProv) {
		this.listaProv = listaProv;
	}


	public List<SelectItem> getListaDistrito() {
		return listaDistrito;
	}


	public void setListaDistrito(List<SelectItem> listaDistrito) {
		this.listaDistrito = listaDistrito;
	}


	public String getFlagMenorEdad() {
		return flagMenorEdad;
	}


	public void setFlagMenorEdad(String flagMenorEdad) {
		this.flagMenorEdad = flagMenorEdad;
	}


	public boolean isMenorEdad() {
		return menorEdad;
	}


	public void setMenorEdad(boolean menorEdad) {
		this.menorEdad = menorEdad;
	}  	
	
}
