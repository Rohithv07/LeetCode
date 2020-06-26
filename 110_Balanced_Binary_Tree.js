var isBalanced = function(root) {
    function recursive(node){
        if(!node)
            return true;
        const left = recursive(node.left)
        const right = recursive(node.right)
        if(!left || !right || Math.abs(left - right) > 1)
            return false
        return Math.max(left, right) + 1
    }
    return recursive(root);
};
