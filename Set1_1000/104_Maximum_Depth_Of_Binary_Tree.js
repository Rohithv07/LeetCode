var maxDepth = function(root) {
    if (!root)
        return null;
   let maximumHeight = Math.max(maxDepth(root.left), maxDepth(root.right));
   return maximumHeight + 1
};
