<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="gTunes"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="materialize.min.css"/>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="font-awesome.min.css"/>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="custom.css"/>

    <asset:javascript src="jquery-2.2.0.min.js"/>
    <g:layoutHead/>
</head>

<body>
<script>
    $(function() {
        $('#loginForm').ajaxForm(function(result) {
            $('#loginBox').html(result);
        });
    });
</script>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${createLink(uri: '/')}">
                    <i class="fa grails-icon">
                        <asset:image src="grails-cupsonly-logo-white.svg"/>
                    </i> gTunes
                </a>
            </div>

            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <g:pageProperty name="page.nav"/>
                </ul>
            </div>
        </div>
    </div>

    <div id="content">
        <div class="col-lg-3 pull-right">
            <div>
                <g:if test="${session?.user}">
                    <g:render template="/user/welcomeMessage"/>
                </g:if>
                <g:else>
                    <g:render template="/user/loginBox"/>
                </g:else>
            </div>
        </div>

        <div class="col-lg-9 card-panel">
            <g:layoutBody/>
        </div>

        <div class="footer card"  role="contentinfo">
            © gTunes 2016
        </div>

        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>
    </div>
    <asset:javascript src="application.js"/>
    <asset:javascript src="bootstrap.js"/>
    <asset:javascript src="jquery.min.js"/>
    <asset:javascript src="materialize.min.js"/>

</body>
</html>
