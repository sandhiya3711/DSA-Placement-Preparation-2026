class Solution {
        public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

                int sum=calculateEvens(nums);

                        int[] result=new int[queries.length];
                                for(int i=0;i<queries.length;i++){
                                            int[] arr=queries[i];
                                                        int value=arr[0];
                                                                    int numIndex=arr[1];
                                                                                if(nums[numIndex]%2==0){
                                                                                              sum-=nums[numIndex];
                                                                                                          }
                                                                                                                      nums[numIndex]+=value;
                                                                                                                                  if(nums[numIndex]%2==0){
                                                                                                                                                   sum+=nums[numIndex];
                                                                                                                                                               }
                                                                                                                                                                           result[i]=sum;
                                                                                                                                                                                       // result[i]=calculateEvens(nums);
                                                                                                                                                                                               }

                                                                                                                                                                                                       return result;

                                                                                                                                                                                                           }

                                                                                                                                                                                                               public static int calculateEvens(int[] arr){
                                                                                                                                                                                                                       int evenSum=0;
                                                                                                                                                                                                                                for(int i=0;i<arr.length;i++){
                                                                                                                                                                                                                                               if(arr[i]%2==0){
                                                                                                                                                                                                                                                                  evenSum+=arr[i];
                                                                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                                   return evenSum;
                                                                                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                                                                                       }
