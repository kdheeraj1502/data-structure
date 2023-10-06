package com.hellokoding.datastructure;

import java.util.Arrays;
import java.util.Objects;

public class MyHashtable<K, V> {
   private static final int INITIAL_CAPACITY = 16;
   private static final float LOAD_FACTOR = 0.75F;
   private int size = 0;
   Entry<K, V>[] entries;

   public MyHashtable() {
      this.entries = (Entry[])(new Entry[16]);
   }

   public MyHashtable(int capacity) {
      this.entries = (Entry[])(new Entry[capacity]);
   }

   public V put(K key, V value) {
      int index = this.hashFunction(key);
      Entry<K, V> headEntry = this.entries[index];

      for(Entry<K, V> currentEntry = headEntry; Objects.nonNull(currentEntry); currentEntry = currentEntry.next) {
         if (Objects.equals(currentEntry.key, key)) {
            return currentEntry.value;
         }
      }

      Entry<K, V> newEntry = new Entry(key, value);
      newEntry.next = headEntry;
      this.entries[index] = newEntry;
      ++this.size;
      this.resize();
      return null;
   }

   public V get(K key) {
      int index = this.hashFunction(key);

      for(Entry<K, V> currentEntry = this.entries[index]; Objects.nonNull(currentEntry); currentEntry = currentEntry.next) {
         if (Objects.equals(currentEntry.key, key)) {
            return currentEntry.value;
         }
      }

      return null;
   }

   public V remove(K key) {
      int index = this.hashFunction(key);
      Entry<K, V> currentEntry = this.entries[index];

      Entry previousEntry;
      for(previousEntry = null; Objects.nonNull(currentEntry) && !Objects.equals(currentEntry.key, key); currentEntry = currentEntry.next) {
         previousEntry = currentEntry;
      }

      if (Objects.isNull(currentEntry)) {
         return null;
      } else {
         if (Objects.isNull(previousEntry)) {
            this.entries[index] = currentEntry.next;
         } else {
            previousEntry.next = currentEntry.next;
         }

         --this.size;
         return currentEntry.value;
      }
   }

   public int size() {
      return this.size;
   }

   private void resize() {
      if (!((float)this.size <= 0.75F * (float)this.entries.length)) {
         Entry<K, V>[] currentEntries = this.entries;
         this.entries = (Entry[])(new Entry[this.entries.length * 2]);
         this.rehash(currentEntries);
      }
   }

   private void rehash(Entry<K, V>[] entries) {
      this.size = 0;
      Entry[] var2 = entries;
      int var3 = entries.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         for(Entry<K, V> entry = var2[var4]; Objects.nonNull(entry); entry = entry.next) {
            this.put(entry.key, entry.value);
         }
      }

   }

   private int hashFunction(K key) {
      int hashCode = key.hashCode();
      int index = hashCode % this.entries.length;
      return index;
   }

   public static void main(String[] args) {
      MyHashtable<String, Integer> myHashtable = new MyHashtable(2);
      myHashtable.put("k1", 1);
      myHashtable.put("k2", 2);
      myHashtable.put("k2", 2);
      myHashtable.put("k3", 3);
      Arrays.stream(myHashtable.entries).forEach((e) -> {
         if (Objects.nonNull(e)) {
            System.out.printf("%s=%d%s", e.key, e.value, System.lineSeparator());
         }

      });
      System.out.println(myHashtable.size());
      System.out.println(myHashtable.get("k2"));
      System.out.println(myHashtable.remove("k1"));
      System.out.println(myHashtable.get("k1"));
      System.out.println(myHashtable.size());
   }
}
