
Node ll = createLinkedList( [ 1,5,8,9,4,1,52,65,1,3,4 ] )
println printList(ll)
Node sorted = sortByPartition( ll, 5 )
println printList(sorted)

def sortByPartition( Node n, int partition ){
    Node head = n
    Node tail = n

    while( n ){
        Node next = n.next
        if( n.data < partition ){
            n.next = head
            head = n
        } else {
            tail.next = n
            tail = n
        }
        n = next
    }
    tail.next = null

    head
}

def createLinkedList( valueList ){
    def head = null
    def next = null

    valueList.each{
        if( !head ){
            head = new Node( it )
            next = head
        } else {
            next.next = new Node( it )
            next = next.next
        }
    }

    return head
}

def printList( Node node ){
    def list = ''

    while( node ){
        if( !list ){
            list += node.data
        } else {
            list += '->' + node.data
        }
        node = node.next
    }
    list
}

class Node{
    Node next = null
    def data

    Node( d ){
        data = d
    }
}