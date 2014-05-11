package personalbandhistory.page

import geb.Page

class ShowBandPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content") == "band.show"}
    
    static content = {
        bandName(wait: true) {$("#band_name")}
    }
}

