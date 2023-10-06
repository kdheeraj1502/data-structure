package com.hellokoding.datastructure;

public class MyHashtable$Entry<K, V> {
   K key;
   V value;
   MyHashtable$Entry<K, V> next;

   MyHashtable$Entry(K key, V value) {
      this.key = key;
      this.value = value;
   }
}
