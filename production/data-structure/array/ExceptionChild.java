package array;

public class ExceptionChild extends ExceptionParent {
   public void display() {
      System.out.println("In child");
   }

   public static void main(String[] args) {
      new ExceptionChild();
   }
}
