def string1 = "dgg"
def string2 = "god"

println isPermutation( string1, string2 )

boolean isPermutation( String str1, String str2 ){
    if( str1.size() != str2.size() )
        return false

    return stringSort( str1 ).equals( stringSort(str2) )
}

String stringSort( String s ){
    char[] charArray = s.toCharArray()
    java.util.Arrays.sort( charArray )
    return new String( charArray )
}
