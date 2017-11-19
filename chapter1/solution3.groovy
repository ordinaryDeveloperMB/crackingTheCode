
String str = "Mr John Smith    "

println URLify( str )

String URLify( String s ){

    char[] char_array = s.toCharArray()
    def index = s.size() - 1
    for( int i = s.trim().size()-1; i >= 0; i-- ){
        if( char_array[ i ] == " " ){
            char_array[ index ] = "0"
            char_array[ index-1 ] = "2"
            char_array[ index-2 ] = "%"
            index = index - 3
        } else {
            char_array[ index ] = char_array[ i ]
            index--
        }
    }
    return new String( char_array )
}