/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if(!head)
        return head;
    let current = head
    while(current != null && current.next != null) {
        if(current.val === current.next.val){
            current.next = current.next.next
          
        }
        else{
            current = current.next
        }
    }
    return head
};
