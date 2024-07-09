package com.certus.spring.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Size(max = 1000, message = "La descripción no puede exceder los 1000 caracteres")
    @Column(length = 1000)
    private String descripcion;

    private int cantidadPersonas;
    private int duracionDias;
    private int duracionNoches;
    private String categoria;
    private double precioOferta;
    private double precioRegular;
    private double descuento;
    private int diaVencimiento;
    private int mesVencimiento;
    private int anioVencimiento;
    private String codigoEmbebido;
    private String imagenPath;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private Date fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = new Date();
    }

    // Constructor, getters y setters

    public Paquete() {}

    public Paquete(String nombre, String descripcion, int cantidadPersonas, int duracionDias, int duracionNoches,
                   String categoria, double precioOferta, double precioRegular, double descuento, int diaVencimiento,
                   int mesVencimiento, int anioVencimiento, String codigoEmbebido, String imagenPath) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadPersonas = cantidadPersonas;
        this.duracionDias = duracionDias;
        this.duracionNoches = duracionNoches;
        this.categoria = categoria;
        this.precioOferta = precioOferta;
        this.precioRegular = precioRegular;
        this.descuento = descuento;
        this.diaVencimiento = diaVencimiento;
        this.mesVencimiento = mesVencimiento;
        this.anioVencimiento = anioVencimiento;
        this.codigoEmbebido = codigoEmbebido;
        this.imagenPath = imagenPath;
        this.fechaCreacion = new Date(); // Inicializar con la fecha actual
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getDuracionNoches() {
        return duracionNoches;
    }

    public void setDuracionNoches(int duracionNoches) {
        this.duracionNoches = duracionNoches;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    public double getPrecioRegular() {
        return precioRegular;
    }

    public void setPrecioRegular(double precioRegular) {
        this.precioRegular = precioRegular;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getDiaVencimiento() {
        return diaVencimiento;
    }

    public void setDiaVencimiento(int diaVencimiento) {
        this.diaVencimiento = diaVencimiento;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(int mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public int getAnioVencimiento() {
        return anioVencimiento;
    }

    public void setAnioVencimiento(int anioVencimiento) {
        this.anioVencimiento = anioVencimiento;
    }

    public String getCodigoEmbebido() {
        return codigoEmbebido;
    }

    public void setCodigoEmbebido(String codigoEmbebido) {
        this.codigoEmbebido = codigoEmbebido;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}


