import grails.util.Environment
import personalbandhistory.DefaultDataService

class BootStrap {
    DefaultDataService defaultDataService
    
    
    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            defaultDataService.loadDefaultDevData()
        }
    }
    def destroy = {
    }
}
