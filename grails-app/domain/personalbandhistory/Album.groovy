package personalbandhistory

import org.joda.time.LocalDate

class Album {
    
    String name
    LocalDate releaseDate
    byte[] albumImage
    
    static hasMany = [songs: Song, members: Member]
    
    static belongsTo = [band: Band]

    static constraints = {
        name        (nullable: false, blank: false)
        releaseDate (nullable: true)
        albumImage   (nullable: true, maxSize: 5242880)
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
