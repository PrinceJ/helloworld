package com.gtunes

class UserController {

    def index() {}

    def register() {
        if(request.method == 'POST') {
            def u = new User()
            u.properties['login', 'password', 'firstName', 'lastName'] = params
            if(u.password != params.confirm) {
                u.errors.rejectValue("password", "user.password.dontmatch")
                return [user:u]
            } else if(u.save()) {
                session.user = u
                redirect controller:"hello"
            } else {
                return [user:u]
            }
        }
    }

    def login(LoginCommand cmd) {
        if (request.method == 'POST') {
            if (!cmd.hasErrors()) {
                session.user = cmd.getUser()
//                redirect controller: 'hello'
                render template: 'welcomeMessage'
            } else {
                render template: 'loginBox', model: [loginCmd: cmd]
            }
        } else {
            render template: 'loginBox'
        }
    }
}


class LoginCommand {
    String login
    String password
    private u

    User getUser() {
        if (!u && login) {
            u = User.findByLogin(login, [fetch: [purchasedSongs: 'join']])
        }
        return u
    }

    static constraints = {
        login blank: false, validator: { val, obj ->
            if (!obj.user)
                return "user.not.found"
        }
        password blank: false, validator: { val, obj ->
            if (obj.user && obj.user.password != val)
                return "user.password.invalid"
        }
    }
}