package level1;

/*
 * Calculates area and circumference of a circle
 * using the given radius value.
 */

class ComputeCircleArea {

    double radius;

    /* Calculates and prints area and circumference */
    void calculate() {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;

        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
    }

    /* Program entry point */
    public static void main(String[] args) {
        ComputeCircleArea c = new ComputeCircleArea();
        c.radius = 7;
        c.calculate();
    }
}
