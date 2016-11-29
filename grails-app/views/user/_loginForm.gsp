<p class="text-success text-darken-2">Login to your gTunes account</p>
<g:form class="input-group form form-input" name="loginForm" url="[controller: 'user', action: 'login']">
    <div class="input-field" >
        <g:textField required="true"
                     placeholder="Username"
                     name="login"
                     class="input-field"
                     value="${fieldValue(bean: loginCmd, field: 'login')}"/>
        <g:hasErrors bean="${loginCmd}" field="login">
            <p class="error">
                <g:fieldError bean="${loginCmd}" field="login"/>
            </p>
        </g:hasErrors>
    </div>

    <div class="input-group">
        <g:passwordField required="true"
                         placeholder="Password"
                         class="text-input"
                         name="password"/>
        <g:hasErrors bean="${loginCmd}" field="password">
            <p class="error">
                <g:fieldError bean="${loginCmd}" field="password"/>
            </p>
        </g:hasErrors>
    </div>

    <div class="submit">
        <input type="submit" value="Login" class="btn waves-effect waves-ripple shake shades-text"/>
    </div>
</g:form>
<g:renderErrors bean="${loginCmd}"></g:renderErrors>