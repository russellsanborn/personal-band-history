package personalbandhistory

class Song {
    
    String name
    String lyrics

    static constraints = {
        name    (nullable: false, blank: false)
        lyrics  (nullable: true)
    }
}
