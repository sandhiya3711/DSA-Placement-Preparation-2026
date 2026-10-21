/**
 * Definition for a binary tree node.
  * public class TreeNode {
   *     int val;
    *     TreeNode left;
     *     TreeNode right;
      *     TreeNode() {}
       *     TreeNode(int val) { this.val = val; }
        *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
          *         this.left = left;
           *         this.right = right;
            *     }
             * }
              */
              class CBTInserter {
              
                  Queue<TreeNode> q;
                      TreeNode root;
                      
                          public CBTInserter(TreeNode root) {
                                  this.q = new LinkedList<>();
                                          this.root = root;
                                                  Queue<TreeNode> bfs = new LinkedList<>();
                                                          bfs.add(root);
                                                          
                                                                  while (!bfs.isEmpty()) {
                                                                              TreeNode curr = bfs.poll();
                                                                                          if (curr.left == null || curr.right == null) {
                                                                                                          q.add(curr);
                                                                                                                      }
                                                                                                                                  if (curr.left != null) bfs.add(curr.left);
                                                                                                                                              if (curr.right != null) bfs.add(curr.right);
                                                                                                                                                      }
                                                                                                                                                          }
                                                                                                                                                              
                                                                                                                                                                  public int insert(int val) {
                                                                                                                                                                          TreeNode newNode = new TreeNode(val);
                                                                                                                                                                                  TreeNode curr = q.peek();
                                                                                                                                                                                  
                                                                                                                                                                                          if (curr.left == null) {
                                                                                                                                                                                                      curr.left = newNode;
                                                                                                                                                                                                              } else {
                                                                                                                                                                                                                          curr.right = newNode;
                                                                                                                                                                                                                                      q.poll();
                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                              
                                                                                                                                                                                                                                                      q.add(newNode);
                                                                                                                                                                                                                                                              return curr.val;
                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                          public TreeNode get_root() {
                                                                                                                                                                                                                                                                                  return root;
                                                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                      /**
                                                                                                                                                                                                                                                                                       * Your CBTInserter object will be instantiated and called as such:
                                                                                                                                                                                                                                                                                        * CBTInserter obj = new CBTInserter(root);
                                                                                                                                                                                                                                                                                         * int param_1 = obj.insert(val);
                                                                                                                                                                                                                                                                                          * TreeNode param_2 = obj.get_root();
                                                                                                                                                                                                                                                                                           */ 