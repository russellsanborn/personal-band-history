package personalbandhistory

import org.joda.time.LocalDate

class Band {

    String bio
    String name
    String location
    LocalDate startDate
    LocalDate endDate
    
    static hasMany = [members: Member, albums: Album]
    
    static constraints = {
        bio         (nullable: true)
        name        (nullable: false, blank: false)
        location    (nullable: true)
        startDate   (nullable: true)
        endDate     (nullable: true)
    }
}
