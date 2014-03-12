package personalbandhistory

import org.joda.time.LocalDate

class Album {
    
    String name
    LocalDate releaseDate
    
    static hasMany = [songs: Song, members: Member]
    
    static belongsTo = [band: Band]

    static constraints = {
        name        (nullable: false, blank: false)
        releaseDate (nullable: true)
    }
    
    String getAlbumDate() {
        String albumDateReturnString

        if (releaseDate) {
            albumDateReturnString = releaseDate.toString("yyyy")
        } 
        else {
            albumDateReturnString = "????"
        }

        return albumDateReturnString
    }
}
