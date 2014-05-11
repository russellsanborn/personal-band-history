package personalbandhistory.page

import geb.Page

class LoginPage extends Page {
    static url = "login"
    
    static at = {title == "Login"}
    
    static content = {
        usernameField(wait: true) {$('input', id:'username')}
        passwordField(wait: true) {$('input', id:'password')}
        submitButton  {$('input', id:'submit')}
    }
    
    def login(String username, String password) {
        usernameField.value(username)
        passwordField.value(password)
        
        submitButton.click()
    }
}

