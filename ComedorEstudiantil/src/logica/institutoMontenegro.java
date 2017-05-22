package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class institutoMontenegro {

	private List<Estudiante> estudiantes;
	private Administrador administrador;
	private dataConnection dataconnection;
	private Date fecha = new Date();

	Connection cn;
	PreparedStatement pst;
	ResultSet rst;

	public institutoMontenegro(List<Estudiante> estudiantes, Administrador administrador, dataConnection dataconnection,
			Date fecha) {
		super();
		this.estudiantes = estudiantes;
		this.administrador = administrador;
		this.dataconnection = dataconnection;
		this.fecha = fecha;
	}

	public institutoMontenegro() {
		super();
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public dataConnection getDataconnection() {
		return dataconnection;
	}

	public void setDataconnection(dataConnection dataconnection) {
		this.dataconnection = dataconnection;
	}

	public java.sql.Date fechaHoy() throws ParseException {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		fecha = cal.getTime();

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = format1.format(cal.getTime());
		fecha = java.sql.Date.valueOf(date1);

		return (java.sql.Date) fecha;

	}

	public void insertarRegistro(int documento, Date fecha, Date ultimoIngreso) throws SQLException, ParseException {

		cn = dataConnection.conexion();

		pst = cn.prepareStatement(
				"insert into instituto_montenegro (documentoEstudiante,fechaIngreso,ultimoIngreso) values(?,?,?);");

		pst.setInt(1, documento);
		pst.setDate(2, (java.sql.Date) fecha);
		pst.setDate(3, (java.sql.Date) ultimoIngreso);

		int res = pst.executeUpdate();
		if (res > 0) {
			System.out.println("El registro se ingreso con exito");

		} else {
			System.out.println("ups...ocurrio un problema");
		}
		cn.close();

	}

	public boolean validarFechas(java.sql.Date fechaHoy, java.sql.Date ultimoIngresoFecha) {

		if (ultimoIngresoFecha.compareTo(fechaHoy) == 0) {
			return true;
		} else

			return false;
	}

	public Date ultimaFechaIngreso(int documento) {
		Date ultimoIngreso = null;
		cn = dataConnection.conexion();
		try {
			pst = cn.prepareStatement("select ultimoIngreso from instituto_montenegro WHERE documentoEstudiante=?;");
			pst.setInt(1, documento);
			rst = pst.executeQuery();
			if (rst.next()) {
				ultimoIngreso = rst.getDate(1);

			} else {
				System.out.println("error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(ultimoIngreso);
		return ultimoIngreso;
	}

	public void actualizarUltimoIngreso(Date fechaHoy, int documento) {

		cn = dataconnection.conexion();
		try {
			pst = cn.prepareStatement("update instituto_montenegro set ultimoIngreso=? WHERE documentoEstudiante=?");
			pst.setDate(1, (java.sql.Date) fechaHoy);
			pst.setInt(2, documento);
			int rst = pst.executeUpdate();
			if (rst > 0) {
				System.out.println("correcto");
			} else {
				System.out.println("error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
