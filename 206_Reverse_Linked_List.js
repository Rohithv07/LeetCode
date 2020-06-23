var reverseList = function(head) {
    if (!head){
        return head
    }
    let first = head;
    let second = first.next;
    while(second){
        let temp = second.next;
        second.next = first;
        first = second;
        second = temp;
    }
    head.next = null
    head = first
    return head
};
