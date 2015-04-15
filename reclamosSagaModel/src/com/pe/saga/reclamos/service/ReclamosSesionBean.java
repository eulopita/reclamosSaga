package com.pe.saga.reclamos.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pe.saga.reclamos.domain.AdmUbigeo;
import com.pe.saga.reclamos.domain.Reclamo;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "ReclamosSesionBean", mappedName = "reclamosSaga-reclamosSagaModel-ReclamosSesionBean")
public class ReclamosSesionBean
        implements ReclamosSesionBeanLocal, ReclamosSesionBeanRemote
{

    /**
     * @generated DT_ID=none
     */
	@Resource
	SessionContext sessionContext;

    /**
     * @generated DT_ID=none
     */
	    @PersistenceContext(unitName="reclamosSagaModel")
        private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public ReclamosSesionBean() {
    }
    
    

    /**
     * @generated DT_ID=none
     */
   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
   //@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Reclamo persistReclamo(Reclamo reclamo) {    	
        em.persist(reclamo);
        return reclamo;
    }

    /**
     * @generated DT_ID=none
     */
    public Reclamo mergeReclamo(Reclamo reclamo) {
        return em.merge(reclamo);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeReclamo(Reclamo reclamo) {
        reclamo = em.find(Reclamo.class, reclamo.getIdReclamo());
        em.remove(reclamo);
    }

    /**
     * @generated DT_ID=none
     */
    @SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Reclamo> getReclamoFindAll() {
        return em.createNamedQuery("Reclamo.findAll").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AdmUbigeo> listarDepartamentos() {
		List<AdmUbigeo> lst = null;
		try {
			StringBuffer jql = new StringBuffer();
			jql.append(" SELECT a FROM AdmUbigeo a WHERE a.codUbigeo LIKE '%0000' AND a.estado= '1' ORDER BY a.nomUbigeo");
			Query query = em.createQuery(jql.toString());
			lst = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<AdmUbigeo> listarProvincias(String codDepartamento) {
		List<AdmUbigeo> lst = null;
		try {
			StringBuffer jql = new StringBuffer();
			jql.append(" SELECT a FROM AdmUbigeo a WHERE a.codUbigeo LIKE :codDepartamento and a.estado='1' AND a.codUbigeo NOT LIKE '%0000' ORDER BY a.nomUbigeo");
			Query query = em.createQuery(jql.toString());
			query.setParameter("codDepartamento", codDepartamento.concat("%00"));			
			lst = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<AdmUbigeo> listarDistritos(String codProvincia) {
		List<AdmUbigeo> lst = null;
		try {
			StringBuffer jql = new StringBuffer();
			jql.append(" SELECT a FROM AdmUbigeo a WHERE a.codUbigeo LIKE :codProvincia and a.estado='1' AND a.codUbigeo NOT LIKE '%00' ORDER BY a.nomUbigeo");
			Query query = em.createQuery(jql.toString());
			query.setParameter("codProvincia", codProvincia.concat("%"));
			lst = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lst;
	}
    
    

}
