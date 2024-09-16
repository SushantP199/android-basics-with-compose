fun main() {
    val instagramBio: String? = "Growth"
    
    if(instagramBio != null) {
        println(instagramBio.toUpperCase())
    }
    
    println(instagramBio?.toUpperCase())
}