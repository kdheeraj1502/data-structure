package string;

public class BinaryAddition {

	public char[] addBinary(String firstStr, String secondStr) {
		char[] first = firstStr.toCharArray();
		char[] second = secondStr.toCharArray();
		int size1 = first.length;
		int size2 = second.length;
		int totalIndex;
		char[] total;
		if (size1 > size2) {
			total = new char[size1 + 2];
			totalIndex = size1;
		} else {
			total = new char[size2 + 2];
			totalIndex = size2;
		}
		total[totalIndex + 1] = '\0';
		int carry = 0;
		size1--;
		size2--;
		while (size1 >= 0 || size2 >= 0) {
			int firstValue = (size1 < 0) ? 0 : first[size1] - '0';
			int secondValue = (size2 < 0) ? 0 : second[size2] - '0';
			int sum = firstValue + secondValue + carry;
			carry = sum >> 1;
			sum = sum & 1;
			total[totalIndex] = (sum == 0) ? '0' : '1';
			totalIndex--;
			size1--;
			size2--;
		}
		total[totalIndex] = (carry == 0) ? '0' : '1';
		return total;
	}

	public String addBinary_self(String firstStr, String secondStr) {
		StringBuilder sb = new StringBuilder();
		char first[] = firstStr.toCharArray();
		char second[] = secondStr.toCharArray();
		int i = first.length - 1, j = second.length - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if(i >= 0)
				sum += first[i] - '0';
			if(j >= 0)
				sum += second[j] - '0';
			carry = sum >> 1;
			sum = sum & 1;
			sb.append(sum);
			i--;
			j--;
		}
		sb.append((carry != 0) ? "1" : "");
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		BinaryAddition ba = new BinaryAddition();
		System.out.println(ba.addBinary("10", "10"));
		System.out.println(ba.addBinary_self("11", "1"));
	}
}
