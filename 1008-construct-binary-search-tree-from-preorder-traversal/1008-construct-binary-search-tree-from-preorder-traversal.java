class Solution {
        private int i = 0;

            private TreeNode build(int[] preorder, int bound) {

                    // Stop if no values remain or the bound is exceeded
                            if (i >= preorder.length || preorder[i] > bound)
                                        return null;

                                                // Create the root and consume the current value
                                                        TreeNode root = new TreeNode(preorder[i++]);

                                                                // Construct the left subtree
                                                                        root.left = build(preorder, root.val);

                                                                                // Construct the right subtree
                                                                                        root.right = build(preorder, bound);

                                                                                                return root;
                                                                                                    }

                                                                                                        public TreeNode bstFromPreorder(int[] preorder) {
                                                                                                                i = 0;
                                                                                                                        return build(preorder, Integer.MAX_VALUE);
                                                                                                                            }
                                                                                                                            }
