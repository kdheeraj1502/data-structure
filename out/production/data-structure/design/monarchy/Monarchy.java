package design.monarchy;

import java.util.List;

public interface Monarchy {
   void birth(String var1, String var2);

   void death(String var1);

   List<String> getOrderOfSuccession();
}
