package personalbandhistory

import org.joda.time.LocalDate

class Concert {
    
    LocalDate eventDate
    String title
    String venueName
    String location

    static hasMany = [bands: String]
    
    static constraints = {
        eventDate   (nullable: false)
        title       (nullable: true, blank: true)
        venueName   (nullable: true, blank: true)
        location    (nullable: true, blank: true)
    }
}
