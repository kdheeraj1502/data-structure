package misclaneous;

public class nooflengthn {
   public static void main(String[] args) {
      int[] arr = new int[]{0, 1, 2, 5};
      int B = 2;
      int C = 21;
      System.out.println(solve(arr, B, C));
   }

   public static int solve(int[] arr, int B, int C) {
      int ans = false;
      int nod = 0;
      int n = C;
      if (arr.length == 0) {
         return 0;
      } else {
         while(n > 0) {
            n /= 10;
            ++nod;
         }

         if (B > nod) {
            return 0;
         } else {
            int ans;
            if (B < nod) {
               if (arr[0] == 0) {
                  ans = (arr.length - 1) * (int)Math.pow((double)arr.length, (double)(B - 1));
               } else {
                  ans = (int)Math.pow((double)arr.length, (double)B);
               }

               if (B == 1 && arr[0] == 0) {
                  ++ans;
               }

               return ans;
            } else {
               int i;
               if (B == 1) {
                  int count = 0;

                  for(i = 0; i < arr.length && arr[i] <= C; ++i) {
                     ++count;
                  }

                  return count;
               } else {
                  int[] temp = new int[nod];
                  n = C;

                  for(i = nod - 1; n > 0 && i >= 0; --i) {
                     temp[i] = n % 10;
                     n /= 10;
                  }

                  int count;
                  for(count = 0; count < temp.length; ++count) {
                     System.out.println(temp[count]);
                  }

                  count = 0;
                  int flag = false;

                  int j;
                  for(j = 0; j < arr.length; ++j) {
                     if (arr[j] != 0) {
                        if (arr[j] == temp[0]) {
                           flag = true;
                        }

                        if (arr[j] > temp[0]) {
                           break;
                        }

                        ++count;
                     }
                  }

                  ans = count * (int)Math.pow((double)arr.length, (double)(B - 1));
                  if (!flag) {
                     return ans;
                  } else {
                     for(j = 1; flag && j <= B - 1; ++j) {
                        flag = false;
                        int countx = 0;

                        for(int k = 0; k < arr.length; ++k) {
                           if (arr[k] > temp[j]) {
                              ++countx;
                           }

                           if (arr[k] == temp[j]) {
                              flag = true;
                           }
                        }

                        ans -= countx * (int)Math.pow((double)arr.length, (double)(B - j - 1));
                     }

                     if (j == B && flag) {
                        --ans;
                     }

                     return ans;
                  }
               }
            }
         }
      }
   }
}
