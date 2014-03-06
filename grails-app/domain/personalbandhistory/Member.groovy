package personalbandhistory

import org.joda.time.LocalDate

class Member {
    
    String instrument
    String name
    LocalDate startDate
    LocalDate endDate

    static constraints = {
        instrument  (nullable: true)
        name        (nullable: false, blank: false)
        startDate   (nullable: true)
        endDate     (nullable: true)
    }
}
