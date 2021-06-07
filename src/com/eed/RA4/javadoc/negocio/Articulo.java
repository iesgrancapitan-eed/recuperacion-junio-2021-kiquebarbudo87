package com.eed.RA4.javadoc.negocio;

import com.eed.RA4.javadoc.excepciones.PrecioNegativoException;
import com.eed.RA4.javadoc.excepciones.UnidadNegativaException;

/**Clase Artículo que representa a los artículos del almacén.
 * Su estado será: código, descripción, precio de compra, precio de venta, número de unidades (nunca negativas),
 * stock de seguridad y stock máximo.
 * Como comportamiento: Consideramos que el código va a generarse de forma automática en el constructor, así no 
 * puede haber dos artículos con el mismo código. Esto implica que no puede modificarse el código de un artículo,
 * sí el resto de las propiedades. Podremos mostrar el artículo, por lo que necesito una representación del artículo 
 * en forma de cadena (toString).
 * 
 *@author ebarbudo
 *
 **/ 


public class Articulo {
  /**
   * Código del artículo
   */
  private int codigo;
  /**
   * Descripción del artículo
   */
  private String descripcion;
  /**
   * Precio al que se compra el artículo
   */
  private double precioCompra;
  /**
   * Precio al que se vende el artículo
   */
  private double precioVenta;
  /**
   * Número total de unidades de un articulo
   */
  private int numUnidades;
  /**
   * Sirve para incrementar el codigo del articulo
   */
  private static int siguienteCodigo = 1;
  
  
  // Constructor de la clase
  /**
   * Crea un nuevo artículo con los parámetros indicados
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
  
  public Articulo (String descripcion, double precioCompra, double precioVenta, int numUnidades) 
      throws PrecioNegativoException, UnidadNegativaException {
    
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setNumUnidades(numUnidades);
    this.codigo = generaCodigo();

  }
  
  // Constructor para identificacion por código de un articulo
  /**
   * 
   * @param codigo
   *        Código a buscar
   */
  
  public Articulo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * Obtiene el numero de unidades de un articulo
   * 
   * @return numUnidades
   */
  private int getNumUnidades() {
    return numUnidades;
  }

  /**
   * Asigna el numero de unidades de un articulo
   * 
   * @param numUnidades
   *        numero de unidades a asignar
   * 
   * @throws UnidadNegativaExcecption
   *         Si la unidad es 0 o menor
   */
   void setNumUnidades(int numUnidades) throws UnidadNegativaException {
     if (numUnidades < 0)
       throw new UnidadNegativaException ("Las unidades no pueden ser negativas");
    this.numUnidades = numUnidades;
  }

  /**
   * Asigna la descripción del artículo
   * 
   * @param descripcion
   *        descripción a asignar
   *        
   */
  void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * Asigna el precio de compra de un artículo
   * 
   * @param precioCompra 
   *        precio de compra a asignar
   *        
   * @throws PrecioNegativoException
   *        Si el precio es 0 o menor
   */
   void setPrecioCompra(double precioCompra) throws PrecioNegativoException {
     if (precioCompra < 0)
       throw new PrecioNegativoException("El precio de compra no puede ser negativo");
    this.precioCompra = precioCompra;
  }

  /**
   * Asigna el precio de venta de un articulo
   * @param precioVenta 
   *        precio de venta a asignar
   *        
   * @throws PrecioNegativoException
   *        Si el precio es 0 o menor
   */
   void setPrecioVenta(double precioVenta) throws PrecioNegativoException {
     if (precioVenta < 0)
       throw new PrecioNegativoException("El precio de venta no puede ser negativo");
    this.precioVenta = precioVenta;
  }
  
   
   /**
    * Método para incrementar el codigo cuando creamos un articulo nuevo
    * @return siguientecodigo
    */
   
   public int generaCodigo() {
     return siguienteCodigo++;
   }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "C�DIGO DEL ART�CULO: " + codigo + "\n"+
        "DESCRIPCI�N: " + descripcion + "\n"+
        "PRECIO DE COMPRA: " + precioCompra + "\n"+
        "PRECIO DE VENTA: " + precioVenta + "\n"+
        "N�MERO DE UNIDADES: " + numUnidades + "\n";
  }
  /**
   * 
   */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  /**
   * 
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }
  
  
  /**
   * incrementa existencias de un articulo (delegado de la clase almacén)
   * 
   * @param cantidad
   *        cantidad a incrementar
   *        
   * @throws UnidadNegativaException
   *         Si el número de unidades es 0 o menor
   */
  
  void addStock (int cantidad) throws UnidadNegativaException {
    if (cantidad < 0)
      throw new UnidadNegativaException ("El n�mero de articulos a introducir no puede ser negativo");
    setNumUnidades(getNumUnidades() + cantidad);
  }
  
  /**
   * decrementa existencias de un articulo (delegado de la clase almacén)
   * 
   * @param cantidad
   *        cantidad a decrementar
   *        
   * @throws UnidadNegativaException
   *         Si el número de unidades es 0 o menor
   */
  
  void deleteStock (int cantidad) throws UnidadNegativaException {
    if (cantidad < 0)
      throw new UnidadNegativaException ("El n�mero de articulos a disminuir no puede ser negativo");
    setNumUnidades(getNumUnidades() - cantidad);
  }
  
  
   
}
