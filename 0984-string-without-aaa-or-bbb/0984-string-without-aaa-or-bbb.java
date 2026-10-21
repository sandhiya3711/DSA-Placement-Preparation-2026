class Solution {
        public String strWithout3a3b(int a, int b) {
                StringBuilder sb = new StringBuilder();
                        
                                while (a > 0 || b > 0) {
                                            if ((sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'a' && sb.charAt(sb.length() - 2) == 'a')) {
                                                            // Cannot add more 'a', must add 'b'
                                                                            sb.append('b');
                                                                                            b--;
                                                                                                        } else if ((sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'b' && sb.charAt(sb.length() - 2) == 'b')) {
                                                                                                                        // Cannot add more 'b', must add 'a'
                                                                                                                                        sb.append('a');
                                                                                                                                                        a--;
                                                                                                                                                                    } else if (a > b) {
                                                                                                                                                                                    // Prefer to add the character with more remaining count
                                                                                                                                                                                                    sb.append('a');
                                                                                                                                                                                                                    a--;
                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                sb.append('b');
                                                                                                                                                                                                                                                                b--;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                    return sb.toString();
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        }
