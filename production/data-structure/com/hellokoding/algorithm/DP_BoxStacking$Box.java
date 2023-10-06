package com.hellokoding.algorithm;

class DP_BoxStacking$Box {
   int height;
   int width;
   int depth;
   int area;

   DP_BoxStacking$Box(int height, int width, int depth) {
      this.height = height;
      this.width = width;
      this.depth = depth;
      this.area = this.width * this.depth;
   }
}
