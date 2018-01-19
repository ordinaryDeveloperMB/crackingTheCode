
Node number1 = createLinkedList( [ 9,7,8 ] )
Node number2 = createLinkedList( [ 6,8,5 ] )

def addedList = addListsForward( number1, number2 )

print addedList
/*
print printList( addListsBackward( number1, number2 ) )
*/

def addListsForward( Node number1, Node number2 ){
    def n1Size = countList( number1 )
    def n2Size = countList( number2 )

    if( n1Size > n2Size ){
        number2 = padList( number2, ( n1Size - n2size ) )
    } else if( n2Size > n1Size ){
        number1 = padLIst( number1, ( n2Size - n1size ) )
    }

    sumPackage = listAdder( number1, number2 )
    def head = sumPackage.node

    if( sumPackage.carryover ){
        head = addBeforeNode( sumPackage.node, 1 )
    }

    head
}

def listAdder( Node number1, Node number2 ){

    if( !number1 && !number2 ) {
        return new SumPackage()
    }

    SumPackage pkg = listAdder( number1.next, number2.next )
    sum = number1.data + number2.data + pkg.carryover

    pkg.carryover = ( sum > 10 ) ? 1 : 0
    pkg.node = addBeforeNode( pkg.node, ( sum % 10 ) )

   pkg
}

def addBeforeNode( Node n, Integer data ){
    def head = new Node( data )
    head.next = n
    return head
}

def addListsBackward( Node number1, Node number2, Integer carryover = 0 ){

    sum = ( number1?.data ?: 0 ) + ( number2?.data ?: 0 ) + carryover
    Node n = new Node( sum % 10 )

    if( number1?.next || number2?.next || sum > 10 ) {
        carryover = (sum > 10) ? 1 : 0
        n.next = addListsBackward(number1?.next, number2?.next, carryover)
    }

    n
}

def padList( Node n, Integer padding ){
    padding.times {
        def head = new Node(0)
        head.next = n
        n = head
    }

    n
}

def countList( Node n ){
    def counter = 0
    while( n ){
        counter+=1
        n = n.next
    }

    counter
}

/*def addListsBackward( Node number1, Node number2 ){
    def sumArray = []
    def carryover = 0
    def remainder = 0

    while( number1 || number2 ){
        def sum = ( number1?.data ?: 0 ) + ( number2?.data?: 0 ) + carryover
        remainder = sum % 10
        carryover = ( sum > 10 ) ? 1 : 0
        sumArray << remainder
        number1 = number1?.next
        number2 = number2?.next
    }

    createLinkedList( sumArray )
}*/

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

    @Override
    String toString() {
        def list = ''

        list += data
        def n = next
        while( n ){
            list += '->' + n.data
            n = n.next
        }

        list
    }
}

class SumPackage{
    Node node = null
    Integer carryover = 0
}
