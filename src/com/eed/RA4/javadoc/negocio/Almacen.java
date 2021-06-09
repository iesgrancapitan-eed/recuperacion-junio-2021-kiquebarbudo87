package com.eed.RA4.javadoc.negocio;

import java.util.ArrayList;

import com.eed.RA4.javadoc.excepciones.ArticuloNoExisteException;
import com.eed.RA4.javadoc.excepciones.PrecioNegativoException;
import com.eed.RA4.javadoc.excepciones.UnidadNegativaException; 


/**Clase Almacén que realice el alta, baja, modificación, entrada de mercancía 
 * (incrementa unidades), salida de mercancía (decrementa unidades).El estado será un 
 * ArrayList de artículos. Esta clase es un envoltorio de un ArrayList.
 * Su comportamiento será: añadir artículos (no puede haber dos artículos iguales), 
 * eliminar artículos, incrementar las existencias de un artículo (se delega en la clase Artículo),  
 * decrementar las existencias de un artículo (nunca por debajo de cero, se delega en la clase Artículo),
 * devolver un artículo (para mostrarlo). Para  listar el almacén podría devolverse una cadena con todos
 * los artículos del almacén (toString).
 *   
 *   
 *   
 *   @author ebarbudo

 */


public class Almacen {
	/**
	 * Crea el almacén con la serie de artículos guardados en un arraylist.	
	 */
	  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();
	  
	
	  /**
	   * Añade un artículo a la clase almacén
	   * 
	   * @param descripción
	   *        Descripción de un artículo.
	   *        
	   * @param precioCompra
	   *        Precio al que compramos un artículo.
	   *        
	   * @param precioVenta
	   *        Precio al que vendemos un artículo.
	   *        
	   * @param numUnidades
	   *        Cantidad totales de unidades de un artículo.
	   * 
	   * @throws UnidadNegativaException
	   *         Si no se ha podido añadir el artículo al almacén
	   *         porque la cantidad a introducir es negativa.
	   * 
	   * @throws PrecioNegativoException
	   *         Si no se ha podido añadir el artículo al almacén
	   *         porque el precio es 0 o menor.
	   *            
	   * 
	   */
	  
	  public void addArticle (String descripcion, double precioCompra, double precioVenta, int numUnidades) throws
	  UnidadNegativaException, PrecioNegativoException{
	    almacen.add(new Articulo(descripcion, precioCompra, precioVenta, numUnidades));
	  }
	  
	  
	  /**
	   * Elimina articulos.
	   * 
	   * @param codigo
	   *        Código del artículo a eliminar.
	   *        
	   * @return true si se ha eliminado. false en caso contrario
	   * 
	   * 
	   */
	  
	  public boolean deleteArticle (int codigo) {
	    return almacen.remove(new Articulo (codigo));
	  } 
	  
	  
	  /**
	   * Incrementa articulos.(delegado en la clase Articulo).
	   * @param codigo
	   *        código a buscar.
	   *        
	   * @param cantidad
	   *        número de articulos a añadir.
	   *        
	   * @throws ArticuloNoExisteException
	   *         Si el articulo no existe en el almacén.
	   *          
	   * @throws UnidadNegativaException
	   *         Si la cantidad es 0 o menor.
	   */
	  void incrementa (int codigo, int cantidad) throws ArticuloNoExisteException, UnidadNegativaException{
	    get(codigo).addStock(cantidad);
	  }
	  
	  
	  /**
	   * 
	   * Devuelve el articulo del almacén indicado por el codigo
	   * 
	   * @param codigo
	   *        Código a buscar.
	   *        
	   * @return Artículo contenido en el almacén. null si no existe.
	   * 
	   * @throws ArticuloNoExisteException
	   *          Si el articulo no existe en el almacén.
	   */
	  private Articulo get(int codigo) throws ArticuloNoExisteException {
	    try {
	      return almacen.get(almacen.indexOf(new Articulo(codigo)));
	    }catch (RuntimeException e) {
	      throw new ArticuloNoExisteException("El código de el articulo que has introducido no existe");
	    }
	    
	  }
	  
	 
	  /**
	   * Decrementa articulos. (delegado en la clase Articulo).
	   * @param codigo
	   *         Código a buscar.
	   *         
	   * @param cantidad
	   *        número de articulos a eliminar.
	   *        
	   * @throws ArticuloNoExisteException
	   *         Si el articulo no existe en el almacén.
	   *         
	   * @throws UnidadNegativaException
	   *         Si la cantidad es 0 o menor.
	   */
	  public void decrementa (int codigo, int cantidad) throws ArticuloNoExisteException, UnidadNegativaException{
	    get(codigo).deleteStock(cantidad);
	  }
	  
	  
	  //
	  /**
	   * Muestra el almacén como una cadena. 
	   */
	  @Override
	  public String toString() {
	    return "Almacen\n" + almacen;
	  }

	  /**
	   * Comprueba si el ArrayList está vacío o no.
	   * 
	   * @return vacio
	   */
	  public boolean isEmpty() {
	    boolean vacio = almacen.isEmpty();
	    return vacio;
	  }
	  /**
	   * Muestra los artículos que hay en el almacén
	   */
	  public void getAlmacen() {
	    for (Articulo articulos : almacen) {
	      System.out.println(articulos);
	    }
	    
	  }
	  
	  /**
	   * 
	   * Modifica la descripción del artículo.
	   *   
	   * @param codigo
	   *        Código a buscar.
	   * @param descripcion
	   *        Descripción a modificar.
	   *        
	   * @throws ArticuloNoExisteException
	   *         Si el articulo no existe en el almacén.
	   */
	  public void modDescripcion(int codigo, String descripcion) throws ArticuloNoExisteException{
	    for (int i = 0; i < almacen.size(); i++) {
	      if(almacen.size()==i)
	        throw new ArticuloNoExisteException("El articulo que quieres modificar no existe.");
	      
	    }
	    for (int i = 0; i < almacen.size(); i++) {
	      if(almacen.get(i).generaCodigo()==codigo) {
	        almacen.get(i).setDescripcion(descripcion);
	      }
	      
	    }
	   
	    
	  }
	  
	  /**
	   * Modifica el precio de compra del artículo.
	   * 
	   * @param codigo
	   *        Código a buscar.
	   *        
	   * @param precioCompra
	   *        Precio a modificar.
	   *        
	   * @throws ArticuloNoExisteException
	   *        Si el articulo no existe en el almacén.
	   *        
	   * @throws PrecioNegativoException
	   *        Si el precio es 0 o menor.
	   */
	  public void modPrecioCompra(int codigo, double precioCompra) 
	    throws ArticuloNoExisteException,PrecioNegativoException {
	      for (int i = 0; i < almacen.size(); i++) {
	        if(i==almacen.size())
	          throw new ArticuloNoExisteException("El articulo que quieres modificar no existe");
	      }
	      if (precioCompra < 0) throw new PrecioNegativoException("El precio de compra no puede ser negativo");
	    }

	  /**
	   * Modifica el precio de venta.
	   * 
	   * @param codigo
	   *        Código a buscar.
	   *        
	   * @param precioVenta
	   *        Precio a modificar.
	   *        
	   * @throws ArticuloNoExisteException
	   *        Si el articulo no existe en el almacén.
	   *        
	   * @throws PrecioNegativoException
	   *        Si el precio es 0 o menor.
	   */
	  public void modPrecioVenta(int codigo, double precioVenta) 
	    throws ArticuloNoExisteException, PrecioNegativoException {
	      if (!(almacen.get(codigo - 1).generaCodigo() == codigo))
	        throw new ArticuloNoExisteException("El articulo que quieres modificar no existe");
	      if (precioVenta < 0)
	        throw new PrecioNegativoException(
	            "El precio de venta no puede ser negativo.");
	    
	  }

}
