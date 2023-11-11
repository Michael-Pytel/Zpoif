package tutorials.bendarz;

// A simple interface that can be implemented the "standard way", by creating a class and implementing this interface
// or anonymously or by using the lambda expression
// We are allowed to implement it using lambda because it only has only one method
// if it has more we can do it anonymously or implementing into a class

@FunctionalInterface
public interface SurfaceCalculator {
	int calculateSurfaceAreaOfARectangle(int a, int b);
}
