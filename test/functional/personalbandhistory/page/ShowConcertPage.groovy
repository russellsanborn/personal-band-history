package personalbandhistory.page

import geb.Page

class ShowConcertPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content") == "concert.show"}
    
    static content = {
        concertName(wait: true) {$("#concert_name")}
    }
}

