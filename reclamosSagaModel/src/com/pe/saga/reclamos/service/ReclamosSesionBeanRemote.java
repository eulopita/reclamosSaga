package com.pe.saga.reclamos.service;

import com.pe.saga.reclamos.domain.AdmUbigeo;
import com.pe.saga.reclamos.domain.Reclamo;

import java.util.List;

import javax.ejb.Remote;


/**
 * @generated DT_ID=none
 */
@Remote
public interface ReclamosSesionBeanRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Reclamo persistReclamo(Reclamo reclamo);

    /**
     * @generated DT_ID=none
     */
    public Reclamo mergeReclamo(Reclamo reclamo);

    /**
     * @generated DT_ID=none
     */
    public void removeReclamo(Reclamo reclamo);

    /**
     * @generated DT_ID=none
     */
    public List<Reclamo> getReclamoFindAll();
    
    
    public List<AdmUbigeo> listarDepartamentos();
    
    
    public List<AdmUbigeo> listarProvincias(String codDepartamento);
    
    
    public List<AdmUbigeo> listarDistritos(String codProvincia); 
    

}
