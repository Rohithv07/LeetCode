var isSymmetric = function(root) {
    function recursive(a , b){
    if (a && b){
        return (a.val === b.val) && recursive(a.left, b.right) && recursive(a.right, b.left);
    }
        else if (a || b)
            return false
        return true
    }
    if (!root){
        return true
    }
    return recursive(root.left, root.right)
};
