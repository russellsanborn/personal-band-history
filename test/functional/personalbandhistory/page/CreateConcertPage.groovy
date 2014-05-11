package personalbandhistory.page

import geb.Page
import personalbandhistory.page.ShowConcertPage

class CreateConcertPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content") == "concert.create"}
    
    static content = {
        concertTitleField(wait: true) {$("#concert_title")}
        eventDateField(wait: true) {$("#event_date")}
        createConcertButton(wait: true, to: ShowConcertPage) {$("#create_concert_button")}
    }
    
    ShowConcertPage createConcert(String concertTitle, String eventDate) {
        concertTitleField.value(concertTitle)
        eventDateField.value(eventDate)
        createConcertButton.click()
        
        return browser.page
    }
}