package logica;

public class Estudiante {
	private String nombres;
	private String apellidos;
	private int documentoIdentidad;
	private String grado;
	private String sexo;
	private String tipoPoblacion;
	private String modeloPedagogico;

	public Estudiante(String nombres, String apellidos, int documentoIdentidad,
			String grado, String sexo, String tipoPoblacion,
			String modeloPedagogico) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.documentoIdentidad = documentoIdentidad;
		this.grado = grado;
		this.sexo = sexo;
		this.tipoPoblacion = tipoPoblacion;
		this.modeloPedagogico = modeloPedagogico;
	}

	public Estudiante() {
		super();
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(int documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoPoblacion() {
		return tipoPoblacion;
	}

	public void setTipoPoblacion(String tipoPoblacion) {
		this.tipoPoblacion = tipoPoblacion;
	}

	public String getModeloPedagogico() {
		return modeloPedagogico;
	}

	public void setModeloPedagogico(String modeloPedagogico) {
		this.modeloPedagogico = modeloPedagogico;
	}

}
