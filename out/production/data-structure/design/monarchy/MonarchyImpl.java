package design.monarchy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MonarchyImpl implements Monarchy {
   private Map<String, Person> persons = new HashMap();
   private Person king;

   public MonarchyImpl(String king) {
      this.king = new Person(king);
      this.persons.put(king, this.king);
   }

   public void birth(String childName, String parentName) {
      Person parentObject = (Person)this.persons.get(parentName);
      Person child = new Person(childName);
      parentObject.getChildren().add(child);
      this.persons.put(childName, child);
   }

   public void death(String name) {
      Person person = (Person)this.persons.get(name);
      if (person != null) {
         person.setAlive(false);
      }
   }

   public List<String> getOrderOfSuccession() {
      List<String> succession = new ArrayList();
      this.dfs(this.king, succession);
      return succession;
   }

   private void dfs(Person currPerson, List<String> succession) {
      if (currPerson.isAlive()) {
         succession.add(currPerson.getName());
      }

      for(int i = 0; i < currPerson.getChildren().size(); ++i) {
         this.dfs((Person)currPerson.getChildren().get(i), succession);
      }

   }

   public static void main(String[] args) {
      MonarchyImpl monarchy = new MonarchyImpl("Jake");
      monarchy.birth("Catherine", "Jake");
      monarchy.birth("Tom", "Jake");
      monarchy.birth("Celine", "Jake");
      monarchy.birth("Jane", "Catherine");
      monarchy.birth("Mark", "Catherine");
      monarchy.birth("Farah", "Jane");
      monarchy.birth("Peter", "Celine");
      List<String> order = monarchy.getOrderOfSuccession();
      Stream var10000 = order.stream();
      PrintStream var10001 = System.out;
      var10000.forEach(var10001::println);
   }
}
