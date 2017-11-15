package pizzaordersystem.exception;

import java.util.Arrays;

public class InputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InputException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InputException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InputException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InputException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InputException [getMessage()=" + getMessage() + ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + ", toString()=" + super.toString() + ", fillInStackTrace()="
				+ fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ "]";
	}

}
