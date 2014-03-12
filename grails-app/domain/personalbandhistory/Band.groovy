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
        bio         (nullable: true, blank:true)
        name        (nullable: false, blank: false)
        location    (nullable: true)
        startDate   (nullable: true)
        endDate     (nullable: true)
    }
    
    String getDateRange() {
        String startDateReturnString
        String endDateReturnString
        
        if (startDate) {
            startDateReturnString = startDate.toString("yyyy")
        }
        else {
            startDateReturnString = "????"
        }
        
        if (endDate) {
            endDateReturnString = endDate.toString("yyyy")
        }
        else {
            endDateReturnString = "????"
        }

        return startDateReturnString + " - " + endDateReturnString
    }
}
