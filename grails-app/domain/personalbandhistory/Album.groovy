package personalbandhistory

import org.joda.time.LocalDate

class Album {
    
    String name
    LocalDate releaseDate
    
    static hasMany = [songs: Song, members: Member]

    static constraints = {
        name        (nullable: false, blank: false)
        releaseDate (nullable: true)
    }
}
