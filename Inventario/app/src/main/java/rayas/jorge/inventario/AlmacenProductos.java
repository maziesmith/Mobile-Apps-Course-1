package rayas.jorge.inventario;

import java.util.Vector;

public interface AlmacenProductos {
    public void  guardarProducto(int clave,String nombre,String categoria,float precio,int existencia);
    public Vector<String> listaProducto(int cantidad);
}
