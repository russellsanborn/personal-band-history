package personalbandhistory.page

import geb.Page

class MainPage extends Page {
    static url = ""
    
    static at = {title == "Personal Band History"}
    
    static content = {
        logoutLinkCount {$('a', id:'log_out_nav_bar_link').size()}
    }
}

