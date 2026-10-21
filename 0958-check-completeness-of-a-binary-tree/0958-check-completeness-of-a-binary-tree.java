class Solution {
        public boolean isCompleteTree(TreeNode root) {
                if (root == null) return true;

                        Queue<TreeNode> q = new LinkedList<>();
                                q.add(root);

                                        boolean past = false;

                                                while (!q.isEmpty()) {
                                                            TreeNode curr = q.poll();

                                                                        if (curr == null) {
                                                                                        past = true;
                                                                                                    } else {
                                                                                                                    if (past) return false;

                                                                                                                                    q.add(curr.left);
                                                                                                                                                    q.add(curr.right);
                                                                                                                                                                }
                                                                                                                                                                        }

                                                                                                                                                                                return true;
                                                                                                                                                                                    }
                                                                                                                                                                                    }
