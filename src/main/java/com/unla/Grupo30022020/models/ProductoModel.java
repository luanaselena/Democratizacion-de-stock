package com.unla.Grupo30022020.models;

public class ProductoModel {

    private long id;
    private boolean status;
    private String descripcion;
    private float precioUnitario;
    private String marca;

    public ProductoModel(){}

    public ProductoModel(long id, String descripcion, float precioUnitario, String marca) {
        this.id = id;
        this.status = true;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.marca = marca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + Float.floatToIntBits(precioUnitario);
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoModel other = (ProductoModel) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (Float.floatToIntBits(precioUnitario) != Float.floatToIntBits(other.precioUnitario))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
    
    
    
}
