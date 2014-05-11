package personalbandhistory.page

import geb.Page
import personalbandhistory.page.ShowBandPage

class CreateBandPage extends Page {
    static at = {$("meta", name: "pageId").getAttribute("content") == "band.create"}
    
    static content = {
        bandNameField (wait: true) {$("#band_name")}
        createBandButton (wait: true, to: ShowBandPage) {$("#create_band_button")}
    }
    
    ShowBandPage createBand(String bandName) {
        bandNameField.value(bandName)
        createBandButton.click()
        
        return browser.page
    }
}