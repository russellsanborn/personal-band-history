import grails.util.Environment
import personalbandhistory.DefaultDataService

import personalbandhistory.Role
import personalbandhistory.User
import personalbandhistory.UserRole

class BootStrap {
    DefaultDataService defaultDataService
    
    
    def init = { servletContext ->
        if (User.count() <= 0)
        {
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true) 
            def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
            def testAdminUser = new User(username: 'admin', enabled: true, password: 'enteranewpasswordyo') 

            testAdminUser.save(flush: true)
            UserRole.create(testAdminUser, adminRole, true)
        }
        
        if (Environment.current == Environment.DEVELOPMENT) {
            defaultDataService.loadDefaultDevData()
        }
    }
    def destroy = {
    }
}
