class Solution {
        // Time Complexity --O(nlogn)
            // space Complexity ---O(nlogn)
                public int[] beautifulArray(int n) {
                       ArrayList<Integer> list=new ArrayList<>();
                              solve(n,list);

                                      // Convert ArrayList to int[]
                                              int[] ans = new int[n];

                                                      for (int i = 0; i < n; i++) {
                                                                  ans[i] = list.get(i);
                                                                          }

                                                                                  return ans;

                                                                                      }


                                                                                          public static void solve(int n ,ArrayList<Integer>list){

                                                                                                  // Base case
                                                                                                          if (n == 1) {
                                                                                                                      list.add(1);
                                                                                                                                  return;
                                                                                                                                          }

                                                                                                                                                  // Divide
                                                                                                                                                          ArrayList<Integer> small = new ArrayList<>();

                                                                                                                                                                  solve((n + 1) / 2, small);

                                                                                                                                                                           // Odd numbers
                                                                                                                                                                                   for (int x : small) {
                                                                                                                                                                                               int odd = 2 * x - 1;

                                                                                                                                                                                                           if (odd <= n) {
                                                                                                                                                                                                                           list.add(odd);
                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                               }

                                                                                                                                                                                                                                                       // Even numbers
                                                                                                                                                                                                                                                               for (int x : small) {
                                                                                                                                                                                                                                                                           int even = 2 * x;

                                                                                                                                                                                                                                                                                       if (even <= n) {
                                                                                                                                                                                                                                                                                                       list.add(even);
                                                                                                                                                                                                                                                                                                                   }
                                                                                                                                                                                                                                                                                                                           }

                                                                                                                                                                                                                                                                                                                               }
                                                                                                                                                                                                                                                                                                                               }
