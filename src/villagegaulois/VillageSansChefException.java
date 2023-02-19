package villagegaulois;

public class VillageSansChefException extends IllegalArgumentException {
	
	public static final long serialVersionUID= 1L;

	public VillageSansChefException() {
		// TODO Auto-generated constructor stub
	}
	public VillageSansChefException(String message) {
		super(message);
	}
	public VillageSansChefException(Throwable cause) {
		super(cause);
	}
	public VillageSansChefException(String message,Throwable cause) {
		super(message,cause);
	}

}
