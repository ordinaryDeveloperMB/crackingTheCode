/*
    Remove Dups: Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed
 */


LinkedList ll = createLinkedList( [ 'a','b','c','a','d','e','f','d','f','g','f','h','h' ] )
println ll
println ll.deleteDupsFollowUp()

def createLinkedList( valueList ){
    def ll = new LinkedList()
    for( x in 0..valueList.size() - 1 ){
        ll.addNode( valueList[ x ] )
    }

    return ll
}

class LinkedList{
    Node first = null

    def addNode( d ){
        if( first == null ){
            first = new Node( d )
        } else {
            appendToTail( d )
        }
    }

    void appendToTail( d ){
        Node end = new Node( d )
        Node n = first
        while( n.next != null ){
            n = n.next
        }
        n.next = end
    }

    def deleteDups(){

        if( !first ){
            return this
        }

        def valueArray = []
        def cur = first

        valueArray << first.data
        while( cur.next != null ){
            if( valueArray.contains( cur.next.data ) ){
                cur.next = cur.next.next
            } else{
                valueArray << cur.next.data
                cur = cur.next
            }
        }
        return this
    }

    def deleteDupsFollowUp(){
        if( !first ){
            return this
        }

        def slow = first

        while( slow ){
            def fast = slow
            while( fast.next ){
                if( slow.data == fast.next.data ){
                    fast.next = fast.next.next
                } else {
                    fast = fast.next
                }
            }
            slow = slow.next
        }
        return this
    }

    @Override
    String toString() {
        def n = first
        def listString = n.data

        while( n.next != null ){
            n = n.next
            listString += "->$n.data"
        }
        return listString
    }


}

class Node{
    Node next = null
    def data

    Node( d ){
        data = d
    }
}
