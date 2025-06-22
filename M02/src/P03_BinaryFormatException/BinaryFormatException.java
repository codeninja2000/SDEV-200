package P03_BinaryFormatException;

/**
 * Thrown to indicate that the application attempted to convert a binary string to a numeric type, but the string
 * does not have the appropriate format.
 */
public class BinaryFormatException extends NumberFormatException {
  public BinaryFormatException(String message) {
    super(message);
  }

}
