package strategy.pattern;

public class Addition implements StrategyService {

	@Override
	public float calculation(float a, float b) {
		return a + b;
	}
}
