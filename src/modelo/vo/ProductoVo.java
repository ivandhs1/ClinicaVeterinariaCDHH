package modelo.vo;

public class ProductoVo {
	
	private Long idProducto;
	private String nombreProducto;
	private Double precioProducto;
	private Long idPersona;
	
	public ProductoVo() {
		
	}

	public ProductoVo(Long idProducto, String nombreProducto, Double precioProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	@Override
	public String toString() {
		return "ProductoVo [idProducto=" + idProducto + ", "
				+ "nombreProducto=" + nombreProducto + ", "
				+ "precioProducto="+ precioProducto + "]";
	}
	
	
}
