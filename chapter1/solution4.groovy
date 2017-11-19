
println isPalindromePermutation( "tact coa" )

boolean isPalindromePermutation( String str ){
    str = str.replace( " ", "" ).toLowerCase()

    characterMap = getCharacterMap( str )
    return hasMoreThanOneOdd( characterMap )
}

def hasMoreThanOneOdd( Map characterMap ){
    return characterMap.findAll({ k,v -> v % 2 > 0 }).size() > 1 ? false : true
}

def getCharacterMap(String str ){
    def characterMap = [:]
    for( def item in str.toCharArray() ) {
        if (characterMap[ item ]){
            characterMap[ item ] += 1
        } else {
            characterMap[ item ] = 1
        }
    }
    return characterMap
}
