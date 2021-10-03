package bit.masking;

public class PositionOfSetBit {

	static int findPosition(int N) {
        int position = 0;
        // 1. CHeck if N is power of 2
        // 2. find the position of set bit with AND operation
        if(N != 0 && ((N & (N - 1)) == 0)){
            while(N > 0){
                if((N & (1 << position)) > 0){
                    return position + 1;
                }
                position++;
            }
        } else{
            return -1;
        }
        return position + 1;
	}

	public static void main(String[] args) {
		System.out.println(findPosition(1));
	}
}
