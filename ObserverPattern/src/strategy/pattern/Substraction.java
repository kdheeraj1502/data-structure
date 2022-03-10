package strategy.pattern;

public class Substraction implements StrategyService {

	@Override
	public float calculation(float a, float b) {
		return a - b;
	}

}
