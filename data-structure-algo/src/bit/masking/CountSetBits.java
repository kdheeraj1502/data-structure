package bit.masking;

public class CountSetBits {

    public static int countSetBits(int n){
        if(n <= 0) return 0;
        
        int power2 = nearestPower2(n);
        int result = (1 << (power2 - 1))*power2 + ((n - (1 << power2)) + 1) 
            + countSetBits(n - (1 << power2));
        return result;
    }
    
    private static int nearestPower2(int val){
        int i = 1;
        int power2 = 1;
        while(power2 <= val){
        	i++;
            power2 = (1 << i);
        }
        return i - 1;
    }
    
    public static void main(String[] args) {
   //	System.out.println(countSetBits(4));
    //	System.out.println(countSetBits(8));
    	
		System.out.println(countSetBits(15));
	}
}
