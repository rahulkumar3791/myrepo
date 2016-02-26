package backup;

public class FileLoadException extends Exception {


	private static final long serialVersionUID = 1L;

	public FileLoadException() {
		super();
	}

	public FileLoadException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileLoadException(String message) {
		super(message);
	}

	public FileLoadException(Throwable cause) {
		super(cause);
	}
	

}
