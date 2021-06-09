package com.eed.RA4.javadoc.negocio;

import java.util.ArrayList;

import com.eed.RA4.javadoc.excepciones.ArticuloNoExisteException;
import com.eed.RA4.javadoc.excepciones.PrecioNegativoException;
import com.eed.RA4.javadoc.excepciones.UnidadNegativaException; 


/**Clase Almac�n que realice el alta, baja, modificaci�n, entrada de mercanc�a 
 * (incrementa unidades), salida de mercanc�a (decrementa unidades).El estado ser� un 
 * ArrayList de art�culos. Esta clase es un envoltorio de un ArrayList.
 * Su comportamiento ser�: a�adir art�culos (no puede haber dos art�culos iguales), 
 * eliminar art�culos, incrementar las existencias de un art�culo (se delega en la clase Art�culo),  
 * decrementar las existencias de un art�culo (nunca por debajo de cero, se delega en la clase Art�culo),
 * devolver un art�culo (para mostrarlo). Para  listar el almac�n podr�a devolverse una cadena con todos
 * los art�culos del almac�n (toString).
 *   
 *   
 *   
 *   @author ebarbudo

 */


public class Almacen {
	/**
	 * Crea el almac�n con la serie de art�culos guardados en un arraylist.	
	 */
	  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();
	  
	
	  /**
	   * A�ade un art�culo a la clase almac�n
	   * 
	   * @param descripci�n
	   *        Descripci�n de un art�culo.
	   *        
	   * @param precioCompra
	   *        Precio al que compramos un art�culo.
	   *        
	   * @param precioVenta
	   *        Precio al que vendemos un art�culo.
	   *        
	   * @param numUnidades
	   *        Cantidad totales de unidades de un art�culo.
	   * 
	   * @throws UnidadNegativaException
	   *         Si no se ha podido a�adir el art�culo al almac�n
	   *         porque la cantidad a introducir es negativa.
	   * 
	   * @throws PrecioNegativoException
	   *         Si no se ha podido a�adir el art�culo al almac�n
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
	   *        C�digo del art�culo a eliminar.
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
	   *        c�digo a buscar.
	   *        
	   * @param cantidad
	   *        n�mero de articulos a a�adir.
	   *        
	   * @throws ArticuloNoExisteException
	   *         Si el articulo no existe en el almac�n.
	   *          
	   * @throws UnidadNegativaException
	   *         Si la cantidad es 0 o menor.
	   */
	  void incrementa (int codigo, int cantidad) throws ArticuloNoExisteException, UnidadNegativaException{
	    get(codigo).addStock(cantidad);
	  }
	  
	  
	  /**
	   * 
	   * Devuelve el articulo del almac�n indicado por el codigo
	   * 
	   * @param codigo
	   *        C�digo a buscar.
	   *        
	   * @return Art�culo contenido en el almac�n. null si no existe.
	   * 
	   * @throws ArticuloNoExisteException
	   *          Si el articulo no existe en el almac�n.
	   */
	  private Articulo get(int codigo) throws ArticuloNoExisteException {
	    try {
	      return almacen.get(almacen.indexOf(new Articulo(codigo)));
	    }catch (RuntimeException e) {
	      throw new ArticuloNoExisteException("El c�digo de el articulo que has introducido no existe");
	    }
	    
	  }
	  
	 
	  /**
	   * Decrementa articulos. (delegado en la clase Articulo).
	   * @param codigo
	   *         C�digo a buscar.
	   *         
	   * @param cantidad
	   *        n�mero de articulos a eliminar.
	   *        
	   * @throws ArticuloNoExisteException
	   *         Si el articulo no existe en el almac�n.
	   *         
	   * @throws UnidadNegativaException
	   *         Si la cantidad es 0 o menor.
	   */
	  public void decrementa (int codigo, int cantidad) throws ArticuloNoExisteException, UnidadNegativaException{
	    get(codigo).deleteStock(cantidad);
	  }
	  
	  
	  //
	  /**
	   * Muestra el almac�n como una cadena. 
	   */
	  @Override
	  public String toString() {
	    return "Almacen\n" + almacen;
	  }

	  /**
	   * Comprueba si el ArrayList est� vac�o o no.
	   * 
	   * @return vacio
	   */
	  public boolean isEmpty() {
	    boolean vacio = almacen.isEmpty();
	    return vacio;
	  }
	  /**
	   * Muestra los art�culos que hay en el almac�n
	   */
	  public void getAlmacen() {
	    for (Articulo articulos : almacen) {
	      System.out.println(articulos);
	    }
	    
	  }
	  
	  /**
	   * 
	   * Modifica la descripci�n del art�culo.
	   *   
	   * @param codigo
	   *        C�digo a buscar.
	   * @param descripcion
	   *        Descripci�n a modificar.
	   *        
	   * @throws ArticuloNoExisteException
	   *         Si el articulo no existe en el almac�n.
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
	   * Modifica el precio de compra del art�culo.
	   * 
	   * @param codigo
	   *        C�digo a buscar.
	   *        
	   * @param precioCompra
	   *        Precio a modificar.
	   *        
	   * @throws ArticuloNoExisteException
	   *        Si el articulo no existe en el almac�n.
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
	   *        C�digo a buscar.
	   *        
	   * @param precioVenta
	   *        Precio a modificar.
	   *        
	   * @throws ArticuloNoExisteException
	   *        Si el articulo no existe en el almac�n.
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
