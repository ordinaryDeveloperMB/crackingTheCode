
def str = "abcdefghijklmnopqrstuvwxyz"
println areAllUnique( str )

static boolean areAllUnique( String str ){
    if ( str.size() > 128 ){
        return false
    }

    boolean[] characters = new boolean[128]
    for( int i = 0; i < str.size(); i++ ){
        int val = str.charAt(i)
        if( characters[val] ){
            return false
        }
        characters[ val ] = true
    }
    return true
}