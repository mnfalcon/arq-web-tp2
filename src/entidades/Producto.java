package entidades;

public class Producto {

	private int id;
    private String name;
    private String email;
    
    public Producto (int idCliente, String name, String email) {
    	this.id=idCliente;
    	this.name=name;
    	this.email=email;
    }
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	
}
