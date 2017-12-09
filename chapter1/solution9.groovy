/*
    String Rotation: Assume you have a method isSubstring which checks if one word is a substring
    of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
    call to isSubstring ( e.g., "waterbottle" is a rotation of "erbottlewat" )
*/

def str1 = "waterbottle"
def str2 = "lewaterbott"
/*
    This first attempt may not be completely correct. Think I misunderstood the question. We need to find a way to
    determine the answer using a single CALL to isSubstring.
*/
//println isRotation( str1, str2 )
//Second try
println isRotation2( str1, str2 )

def isRotation( str1, str2 ){
    def firstChar = str1.take(1)
    def isRotation = false
    if( str1.size() == str2.size() && str2.contains( firstChar ) ){
        charIndexes = str2.indexOf( firstChar )
        for( index in charIndexes ){
            isRotation = str1 == ( str2.substring( index, str2.size() ) + str2.substring( 0, index ) )
        }
    } else {
        return false
    }

    return isRotation
}

def isRotation2( str1, str2 ){
    def firstChar = str1.take(1)
    if( str1.size() == str2.size() && str2.contains( firstChar ) ){
        def stringToCheck = str1 + str2
        return stringToCheck.contains( str1 )
    } else {
        return false
    }
}
