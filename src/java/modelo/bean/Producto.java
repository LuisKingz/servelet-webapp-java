package modelo.bean;

import javax.servlet.http.HttpServletRequest;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
    private Categoria categoria;

    public Producto(HttpServletRequest request) {
        this.nombre = request.getParameter("nombre");
        this.descripcion = request.getParameter("descripcion");
        this.cantidad = Integer.parseInt(request.getParameter("cantidad"));
        this.precio = Integer.parseInt(request.getParameter("precio"));        
        Categoria c = new Categoria(Integer.parseInt(request.getParameter("categoria")));        
        this.categoria = c;
    }

    public Producto(int id, String nombre, String descripcion, int cantidad, double precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto() {
        
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
