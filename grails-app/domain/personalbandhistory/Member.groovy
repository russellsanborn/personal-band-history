package personalbandhistory

import org.joda.time.LocalDate

class Member {
    
    String instrument
    String name
    LocalDate startDate
    LocalDate endDate

    static constraints = {
        instrument  (nullable: true, blank: true)
        name        (nullable: false, blank: false)
        startDate   (nullable: true)
        endDate     (nullable: true)
    }
    
    String toString() {
        return name + ": " + getDateRange() + ": " + instrument
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
