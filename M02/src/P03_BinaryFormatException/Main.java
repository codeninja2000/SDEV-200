package P03_BinaryFormatException;
import java.util.BinaryFormatException
public class Main {
    public static void main(String[] args) {

    }
    public static int bin2dec(String bin) {
       if (!isValidBinary(bin) {
           throw new BinaryFormatException()
        }
        long num = Long.parseLong(bin, 2);

    }
    public static boolean isValidBinary(String num) {
        for (char c : num.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
}
