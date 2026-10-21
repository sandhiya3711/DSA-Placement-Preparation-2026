
// Intuition:
// We are given a stamp S and a target string T.
// Our task is to find the positions where we must stamp S
// so that we can convert a string of '*' characters into T.
//
// Instead of constructing T from left to right, we work backwards.
//
// Think of T as the final result.
// We repeatedly find portions of T that could have been produced
// by stamping S, replace those portions with '*', and record
// the starting index of each stamp.
//
// If we can turn the entire T into '*', we have found a solution.
//
// Approach:
//
// 1. Convert S and T into character arrays so that we can modify T.
//
// 2. Calculate the number of valid starting positions for S in T.
//    If S has length m and T has length n, there are n - m + 1
//    possible starting positions.
//
// 3. Iterate through every possible starting position in T.
//
// 4. For each position, compare S with the corresponding window
//    in T character by character.
//
//    - If a character in T is '*', skip it because that character
//      has already been erased by a previous reverse stamping operation.
//
//    - If a non-'*' character in T does not match the corresponding
//      character in S, this window cannot be stamped yet.
//
//    - If all non-'*' characters match S, and the window contains
//      at least one character that has not already been erased,
//      this window is valid.
//
// 5. For a valid window:
//    - Replace every character in that window with '*'.
//    - Record its starting index at the beginning of the answer list.
//    - Mark that progress has been made during this iteration.
//
//    We insert each index at the beginning because we are processing
//    the target backwards, while the answer must describe the
//    forward stamping order.
//
// 6. Repeat scanning all possible windows while at least one valid
//    window is found. Each successful pass erases more characters.
//
// 7. After no more progress is possible:
//    - If every character in T is '*', return the recorded indices.
//    - Otherwise, return an empty array because the target cannot
//      be completely erased using this process.
//
// Why do we work backwards?
//
// Forward stamping overwrites existing characters, making it difficult
// to determine which stamp should be applied first.
//
// Backwards, we can identify a window whose remaining characters
// already match S. We erase those characters because they could have
// been written by that stamp in the forward process.
//
// Reversing the order of these erasing operations gives us a valid
// sequence of forward stamping operations.
//
// Example:
//
// S = "abc"
// T = "ababc"
//
// Initially:  ababc
//
// Erase the window starting at index 2:
//              ab***
//
// Erase the window starting at index 0:
//              *****
//
// The reverse erasing order is [2, 0].
// Therefore, the forward stamping order is [0, 2].
//
// Time Complexity:
// O((n - m + 1) * m * n)
//
// In the worst case, each successful iteration erases at least one
// character, so there can be at most n successful iterations.
// Each iteration checks every possible window, comparing up to m
// characters.
//
// Space Complexity:
// O(n + k)
//
// O(n) for the mutable target character array and O(k) for the
// answer list, where k is the number of stamping operations.
//
// Important implementation detail:
// A window must erase at least one non-'*' character. Otherwise,
// the algorithm would repeatedly select an already-erased window
// and could get stuck in an infinite loop.
//
// Also, the sdiff flag in your implementation needs to be reset
// for every window and should indicate that at least one character
// was actually erased. Otherwise, a previous window's value can
// incorrectly affect the current window.

class Solution {
    public int[] movesToStamp(String S, String T) {
            if (S == T) return new int[]{0};

                    char[] SC = S.toCharArray(), TC = T.toCharArray();

                            int slen = SC.length, tlen = TC.length - slen + 1, i, j;

                                    List<Integer> lans = new ArrayList<>();
                                            Boolean tdiff = true, sdiff;

                                                    while (tdiff){
                                                                for (i = 0, tdiff = false; i < tlen; i++) {
                                                                                for (j = 0, sdiff = false; j < slen; j++){
                                                                                                    if (TC[i+j] == '*') continue;
                                                                                                                        else if (TC[i+j] != SC[j]) break;
                                                                                                                                            else sdiff = true;
                                                                                                                                                            }
                                                                                                                                                                            if (j == slen && sdiff) {
                                                                                                                                                                                                for (j = i, tdiff = true; j < slen + i; j++)
                                                                                                                                                                                                                        TC[j] = '*';
                                                                                                                                                                                                                                            lans.add(0, i);
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                        for (i = 0; i < TC.length; i++) if (TC[i] != '*') 
                                                                                                                                                                                                                                                                                                    return new int[]{};
                                                                                                                                                                                                                                                                                                            int[] ans = new int[lans.size()];
                                                                                                                                                                                                                                                                                                                    for (i = 0; i < lans.size(); i++) ans[i] = lans.get(i);
                                                                                                                                                                                                                                                                                                                                return ans;
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                    }