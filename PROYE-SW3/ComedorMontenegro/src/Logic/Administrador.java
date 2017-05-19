package Logic;

public class Administrador {
	private String nombres;
	private String apellidos;
	private int documento;
	private String nickname;

	public Administrador(String nombres, String apellidos, int documento,
			String nickname) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.documento = documento;
		this.nickname = nickname;
	}

	public Administrador() {
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

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
