package arraysClasesExtendidas;

public class Persona {
	String nombre;
	String dni;
	int edad;
	
	public Persona(String nombre, String dni, int edad){
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}
	
	public Persona(){
		
	}
	
	public void setNewEdad(int edad){
		this.edad = edad;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public String getDNI(){
		return dni;
	}
	
	public String getNombre(){
		return nombre;
	}
	
}
