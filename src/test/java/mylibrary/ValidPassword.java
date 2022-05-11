package mylibrary;

public class ValidPassword {
    public static void main(String[] args) {
        for (int password = 1; password <= 6; password++) {
            for (int b = 1; b <= password; b++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
