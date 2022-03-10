package strategy.pattern;

public class Multiplication implements StrategyService {

	@Override
	public float calculation(float a, float b) {
		return a * b;
	}

}
