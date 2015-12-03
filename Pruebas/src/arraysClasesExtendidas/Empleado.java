package arraysClasesExtendidas;

public class Empleado extends Persona{
	int numSegSocial;
	int salario;
	String puesto;

	public Empleado(String nombre, String dni, int edad, String puesto, int numSegSocial, int salario) {
		super(nombre, dni, edad);
		this.numSegSocial = numSegSocial;
		this.salario = salario;
		this.puesto = puesto;
	}
	
	public Empleado(){
		
	}
	
	public int getSalario(){
		return salario;
	}

	public int getNumSegSocial(){
		return numSegSocial;
	}
	
	public String getPuesto(){
		return puesto;
	}
}
