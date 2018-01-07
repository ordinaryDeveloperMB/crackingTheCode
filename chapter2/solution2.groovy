
LinkedList ll = createLinkedList( [ 'a','b','c','a','d','e','f','d','f','g','f','h','h' ] )
println getNthToLastElement( ll.first, 4 ).data

def createLinkedList( valueList ){
    def ll = new LinkedList()
    for( x in 0..valueList.size() - 1 ){
        ll.addNode( valueList[ x ] )
    }

    return ll
}
//BruteForce
/*def getNthToLastElement( Node first, int element ){
    def listSize = 0
    def sizer = first
    while( sizer.next ){
        listSize += 1
        sizer = sizer.next
    }

    def index = listSize - element +1
    Node node = first

    for( def x = 0; x < index; x++ ){
        node = node.next
    }
    node
}*/

def getNthToLastElement( Node first, int element ){
    def slow = first
    def fast = first

    def elementCounter = 1

    while( fast.next ){
        fast = fast.next
        if( elementCounter >= element ){
            slow = slow.next
        }
        elementCounter += 1
    }

    slow
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