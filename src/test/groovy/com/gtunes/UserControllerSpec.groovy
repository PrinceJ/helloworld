package com.gtunes

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    void "text password does not match"() {
        request.method = 'POST'

        params.login = 'henry'
        params.password = 'password'
        params.confirm = 'wrongPassword'
        params.firstName = 'Henry'
        params.lastName = 'Rollins'
        def model = controller.register()
        def user = model.user

        assert user.hasErrors()
        assert 'user.password.dontmatch' == user.errors['password'].code
    }

    void "test Registration Failed" () {
        request.method = 'POST'
        params.login = ''
        def model = controller.register()
        def user = model.user
        assert user.hasErrors()
        assert session.user == null
        assert 'blank' == user.errors['login'].code
        assert 'nullable' == user.errors['firstName'].code
        assert 'nullable' == user.errors['lastName'].code
    }

    void "test Registration is a Success"() {
        request.method = 'POST'
        params.login = 'henry'
        params.password = 'password'
        params.confirm = 'password'
        params.firstName = 'Henry'
        params.lastName = 'Rollins'
        controller.register()
        assert '/hello' == response.redirectedUrl
        assert session.user != null
    }

    void "testLoginUserNotFound" () {
        request.method = 'POST'
        params.login = 'frank'
        params.password = 'hotrats'
        controller.login()
        def cmd = model.loginCmd
        assert cmd.hasErrors()
        assert 'user.not.found' == cmd.errors['login'].code
        assert session.user == null
        assert '/hello/index' == view
    }

    void testLoginFailurePasswordInvalid() {
        request.method = 'POST'
        def u = new User(login: 'maynard',
                firstName: 'Maynard',
                lastName: 'Keenan',
                password: 'undertow').save()
        assert u != null
        params.login = 'maynard'
        params.password = 'lateralus'
        controller.login()
        def cmd = model.loginCmd
        assert cmd.hasErrors()
        assert 'user.password.invalid' ==
                cmd.errors['password'].code
        assert session.user == null
        assert '/hello/index' == view

    }

    void testLoginSuccess() {
        request.method = 'POST'
        def u = new User(login: 'maynard',
                firstName: 'Maynard',
                lastName: 'Keenan',
                password: 'undertow').save()
        assert u != null
        params.login = 'maynard'
        params.password = 'undertow'
        controller.login()
        assert session.user != null
        assert '/hello' == response.redirectedUrl
    }
}
