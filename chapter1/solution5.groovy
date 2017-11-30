
String master = "pale"
String compare = "bake"

println isOneAway( master, compare )

boolean isOneAway( String str1, String str2 ){

    if( str2.size() > ( str1.size() + 1 ) || str2.size() < ( str1.size() - 1 ) ){
        return false
    }

    char[] master = str1.toCharArray()
    char[] compare = str2.toCharArray()

    for( int i = 0; i < master.size() - 1; i++ ){

        if( master[i] != compare[i] ){
            if( str1.substring( i+1, str1.size() ) != str2.substring( i+1, str2.size() ) && str1.substring( i, str1.size() ) != str2.substring( i+1, str2.size() ) && str2.substring( i, str2.size() ) != str1.substring( i+1, str1.size() ) ){
                return false
            }
        }
    }

    return true
}
