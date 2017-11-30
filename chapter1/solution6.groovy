String needsCompression = "aaabbbbccccccdd"

println compressString( needsCompression )

String compressString( String str ){
    StringBuilder sb = new StringBuilder()

    for( def i = 0; i < str.size() - 1; i++ ){
        def charCount = 1
        sb.append( str.charAt( i ) )
        while( i != str.size() - 1 && str.charAt( i ) == str.charAt( i+1 ) ){
            charCount++
            i++
        }
        sb.append( charCount )
    }

    String compressed = sb.toString()

    return ( compressed.size() < str.size() ) ? compressed : str
}

