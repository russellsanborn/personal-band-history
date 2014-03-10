package personalbandhistory

class Song {
    
    String name
    String lyrics
    Integer trackNum

    static constraints = {
        name    (nullable: false, blank: false)
        lyrics  (nullable: true, blank: true)
        trackNum(nullable: true)
    }
}
