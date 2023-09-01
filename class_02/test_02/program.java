package test_02;

public class program {
    public static void main(String[] args) {
        double[] intArray = new double[] { 1., 2., 3., 4., 5., 6., 7., 8., 9. };
        int d = 0;// Делитель

        // Если делитель равен нулю.
        if(d == 0)
            throw new IllegalArgumentException("Ошибка. Знаменатель не может равняться 0.");
        
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    }
}
