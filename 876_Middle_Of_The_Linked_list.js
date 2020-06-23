var middleNode = function(head) {
    let lower = head;
    let higher = head;
    while(higher && higher.next){
        lower = lower.next;
        higher = higher.next.next
    }
    return lower
};
