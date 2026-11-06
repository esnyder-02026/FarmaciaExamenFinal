package com.repaso.farmacia.dto;

public class CategoriaDTO {
    private Integer idCategoria;
    private Boolean estado;
    private String nombre;
    private String descripcion;

    public CategoriaDTO() {}

    public CategoriaDTO(Integer idCategoria, Boolean estado, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.estado = estado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }
    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
