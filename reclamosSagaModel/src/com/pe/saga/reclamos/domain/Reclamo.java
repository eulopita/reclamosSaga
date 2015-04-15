package com.pe.saga.reclamos.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the RECLAMOS database table.
 * 
 */
@Entity
@Table(name="RECLAMOS", schema ="RECLAMOS" )
@NamedQuery(name="Reclamo.findAll", query="SELECT r FROM Reclamo r")
public class Reclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_entity_seq_reclamo")
	@SequenceGenerator(name="my_entity_seq_reclamo",sequenceName="SEQ_RECLAMOS", allocationSize = 1,schema="RECLAMOS")
	@Column(name="ID_RECLAMO")
	private long idReclamo;

	@Column(name="AP_MATERNO")
	private String apMaterno;

	@Column(name="AP_MATERNO_APODERADO")
	private String apMaternoApoderado;

	private String apellidos;

	@Column(name="APELLIDOS_APODERADO")
	private String apellidosApoderado;

	@Column(name="DESCRIPCION_PRODUCTO")
	private String descripcionProducto;

	@Column(name="DETALLE_RECLAMO")
	private String detalleReclamo;

	private String direccion;

	private String documento;

	@Column(name="DOCUMENTO_APODERADO")
	private String documentoApoderado;

	private String email;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_RECLAMO")
	private Date fechaReclamo;

	@Column(name="ID_TIENDA")
	private long idTienda;

	@Column(name="MENOR_EDAD")
	private int menorEdad;

	private String nombres;

	@Column(name="NOMBRES_APODERADO")
	private String nombresApoderado;

	@Column(name="REC_IMPORTE")
	private BigDecimal recImporte;

	@Column(name="REC_PEDIDO")
	private String recPedido;

	private String telefono;

	@Column(name="TIPO_DOC_APODERADO")
	private int tipoDocApoderado;

	@Column(name="TIPO_DOCUMENTO")
	private int tipoDocumento;

	@Column(name="TIPO_RECLAMO")
	private int tipoReclamo;

	@Column(name="TIPO_REGISTRO")
	private int tipoRegistro;

	@Column(name="TIPO_RESPUESTA")
	private int tipoRespuesta;

	private String ubigeo;

	public Reclamo() {
	}

	public long getIdReclamo() {
		return this.idReclamo;
	}

	public void setIdReclamo(long idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getApMaterno() {
		return this.apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getApMaternoApoderado() {
		return this.apMaternoApoderado;
	}

	public void setApMaternoApoderado(String apMaternoApoderado) {
		this.apMaternoApoderado = apMaternoApoderado;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getApellidosApoderado() {
		return this.apellidosApoderado;
	}

	public void setApellidosApoderado(String apellidosApoderado) {
		this.apellidosApoderado = apellidosApoderado;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getDetalleReclamo() {
		return this.detalleReclamo;
	}

	public void setDetalleReclamo(String detalleReclamo) {
		this.detalleReclamo = detalleReclamo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDocumentoApoderado() {
		return this.documentoApoderado;
	}

	public void setDocumentoApoderado(String documentoApoderado) {
		this.documentoApoderado = documentoApoderado;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaReclamo() {
		return this.fechaReclamo;
	}

	public void setFechaReclamo(Date fechaReclamo) {
		this.fechaReclamo = fechaReclamo;
	}

	public long getIdTienda() {
		return this.idTienda;
	}

	public void setIdTienda(long idTienda) {
		this.idTienda = idTienda;
	}

	public int getMenorEdad() {
		return this.menorEdad;
	}

	public void setMenorEdad(int menorEdad) {
		this.menorEdad = menorEdad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombresApoderado() {
		return this.nombresApoderado;
	}

	public void setNombresApoderado(String nombresApoderado) {
		this.nombresApoderado = nombresApoderado;
	}

	public BigDecimal getRecImporte() {
		return this.recImporte;
	}

	public void setRecImporte(BigDecimal recImporte) {
		this.recImporte = recImporte;
	}

	public String getRecPedido() {
		return this.recPedido;
	}

	public void setRecPedido(String recPedido) {
		this.recPedido = recPedido;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTipoDocApoderado() {
		return this.tipoDocApoderado;
	}

	public void setTipoDocApoderado(int tipoDocApoderado) {
		this.tipoDocApoderado = tipoDocApoderado;
	}

	public int getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getTipoReclamo() {
		return this.tipoReclamo;
	}

	public void setTipoReclamo(int tipoReclamo) {
		this.tipoReclamo = tipoReclamo;
	}

	public int getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(int tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public int getTipoRespuesta() {
		return this.tipoRespuesta;
	}

	public void setTipoRespuesta(int tipoRespuesta) {
		this.tipoRespuesta = tipoRespuesta;
	}

	public String getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

}