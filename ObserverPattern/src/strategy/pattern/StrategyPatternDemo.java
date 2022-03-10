package strategy.pattern;

public class StrategyPatternDemo {

	StrategyService service;

	StrategyPatternDemo(StrategyService service) {
		this.service = service;
	}

	public float calculaion(float a, float b) {
		return service.calculation(a, b);
	}

	public static void main(String[] args) {
		StrategyPatternDemo context = new StrategyPatternDemo(new Addition());
		System.out.println(context.calculaion(5, 9));
		context = new StrategyPatternDemo(new Substraction());
		System.out.println(context.calculaion(5, 9));
		context = new StrategyPatternDemo(new Multiplication());
		System.out.println(context.calculaion(5, 9));
	}
}
