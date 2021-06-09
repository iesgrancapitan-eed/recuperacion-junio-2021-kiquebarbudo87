package com.eed.RA4.javadoc.negocio;

import com.eed.RA4.javadoc.excepciones.PrecioNegativoException;
import com.eed.RA4.javadoc.excepciones.UnidadNegativaException;

/**Clase Art�culo que representa a los art�culos del almac�n.
 * Su estado ser�: c�digo, descripci�n, precio de compra, precio de venta, n�mero de unidades (nunca negativas),
 * stock de seguridad y stock m�ximo.
 * Como comportamiento: Consideramos que el c�digo va a generarse de forma autom�tica en el constructor, as� no 
 * puede haber dos art�culos con el mismo c�digo. Esto implica que no puede modificarse el c�digo de un art�culo,
 * s� el resto de las propiedades. Podremos mostrar el art�culo, por lo que necesito una representaci�n del art�culo 
 * en forma de cadena (toString).
 * 
 *@author ebarbudo
 *
 **/ 


public class Articulo {
  /**
   * C�digo del art�culo
   */
  private int codigo;
  /**
   * Descripci�n del art�culo
   */
  private String descripcion;
  /**
   * Precio al que se compra el art�culo
   */
  private double precioCompra;
  /**
   * Precio al que se vende el art�culo
   */
  private double precioVenta;
  /**
   * N�mero total de unidades de un art�culo
   */
  private int numUnidades;
  /**
   * Sirve para incrementar el codigo del articulo
   */
  private static int siguienteCodigo = 1;
  
  
  // Constructor de la clase
  /**
   * Crea un nuevo art�culo con los par�metros indicados
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
  
  public Articulo (String descripcion, double precioCompra, double precioVenta, int numUnidades) 
      throws PrecioNegativoException, UnidadNegativaException {
    
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setNumUnidades(numUnidades);
    this.codigo = generaCodigo();

  }
  
  // Constructor para identificacion por c�digo de un articulo
  /**
   * Crea un c�digo nuevo para cada art�culo
   * @param codigo
   *        C�digo a buscar
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
   *        n�mero de unidades a asignar
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
   * Asigna la descripci�n del art�culo
   * 
   * @param descripcion
   *        descripci�n a asignar
   *        
   */
  void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * Asigna el precio de compra de un art�culo
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
    * M�todo para incrementar el codigo cuando creamos un articulo nuevo
    * @return siguientecodigo
    */
   
   public int generaCodigo() {
     return siguienteCodigo++;
   }

  /** 
   * Muestra el resultado del art�culo como una cadena.
   * 
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
   * Almacena la instancia de la clase.
   */
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  /**
   * Compara dos art�culos.
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
   * M�todo para incrementar existencias de un articulo (delegado de la clase almac�n)
   * 
   * @param cantidad
   *        cantidad a incrementar
   *        
   * @throws UnidadNegativaException
   *         Si el n�mero de unidades es 0 o menor
   */
  
  void addStock (int cantidad) throws UnidadNegativaException {
    if (cantidad < 0)
      throw new UnidadNegativaException ("El n�mero de articulos a introducir no puede ser negativo");
    setNumUnidades(getNumUnidades() + cantidad);
  }
  
  /**
   * M�todo para decrementar existencias de un articulo (delegado de la clase almac�n)
   * 
   * @param cantidad
   *        cantidad a decrementar
   *        
   * @throws UnidadNegativaException
   *         Si el n�mero de unidades es 0 o menor
   */
  
  void deleteStock (int cantidad) throws UnidadNegativaException {
    if (cantidad < 0)
      throw new UnidadNegativaException ("El n�mero de articulos a disminuir no puede ser negativo");
    setNumUnidades(getNumUnidades() - cantidad);
  }
  
  
   
}