package personalbandhistory

class UserController {

    def springSecurityService
    
    def scaffold = true
    
    def index () {
        redirect(action: "list")
    }    
    
    def list() {
        [users: User.listOrderByUsername()]
    }
    
    def edit = {
        def authenticatedUser = User.findByUsername(springSecurityService.currentUser.username)
        def userInstance  = User.findById(params.id)

        if (!params.id.equals(authenticatedUser.id.toString()) && 
            !authenticatedUser.getAuthorities().contains(Role.findByAuthority('ROLE_ADMIN')) ||
            !userInstance) {
            flash.errors = "Not authorized".toString()
            redirect(action: "list")
            return
        }
        
        [userInstance:userInstance]        
    }
    
    def save() {
        def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }
        
        UserRole.create(userInstance, Role.findByAuthority('ROLE_USER'), true)
         
        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }
    
    def addUserRole() {
        def userInstance = User.findById(params.id)
        UserRole.create(userInstance, Role.findByAuthority('ROLE_USER'), true)
        
        flash.message = "Added User Role".toString()
        redirect(action: "show", id: userInstance.id)
    }
    
    def addAdminRole() {
        def userInstance = User.findById(params.id)
        UserRole.create(userInstance, Role.findByAuthority('ROLE_ADMIN'), true)
        
        flash.message = "Added Admin Role".toString()
        redirect(action: "show", id: userInstance.id)
    }
    
    def removeUserRole() {
        def userInstance = User.findById(params.id)
        UserRole.remove(userInstance, Role.findByAuthority('ROLE_USER'), true)
        
        flash.message = "Removed User Role".toString()
        redirect(action: "show", id: userInstance.id)
    }
    
    def removeAdminRole() {
        def userInstance = User.findById(params.id)
        UserRole.remove(userInstance, Role.findByAuthority('ROLE_ADMIN'), true)
        
        flash.message = "Removed Admin Role".toString()
        redirect(action: "show", id: userInstance.id)
    }
    
    def update(Long id, Long version) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = "User Not Found".toString()
            redirect(action: "list")
            return
        }
        
        def authenticatedUser = User.findByUsername(springSecurityService.currentUser.username)

        if (!id == authenticatedUser.id && 
            !authenticatedUser.getAuthorities().contains(Role.findByAuthority('ROLE_ADMIN')) ||
            !userInstance) {
            flash.errors = "Not authorized".toString()
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'User.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }
        
        flash.message = "Updated User".toString()
        redirect(action: "edit", id: userInstance.id)
    }
}
