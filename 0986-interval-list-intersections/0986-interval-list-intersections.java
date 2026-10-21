class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
                int n = firstList.length, m = secondList.length;
                        int i = 0, j = 0;
                                List<int[]> ans = new ArrayList<>();
                                        while (i < n && j < m) {
                                                    if (firstList[i][1] < secondList[j][0]) {
                                                                    i++;
                                                                                } else if (secondList[j][1] < firstList[i][0]) {
                                                                                                j++;
                                                                                                            } else {
                                                                                                                            ans.add(new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])});
                                                                                                                                            if (firstList[i][1] <= secondList[j][1]) i++;
                                                                                                                                                            else j++;
                                                                                                                                                                        }
                                                                                                                                                                                }
                                                                                                                                                                                        return ans.toArray(new int[0][]);
                                                                                                                                                                                            }
                                                                                                                                                                                            }
