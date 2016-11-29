<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'artist.label', default: 'Artist')}" />
    <title>Welcome to Shop</title>
</head>
<body>
    <h1 class="text-center text-primary" style="font-size: 2em">Your online music store and storage service!</h1>
    <p class="text-center" style="font-size: 1.2em; font-style: italic; padding-top: .5em">
        Manage your own library, browse music and purchase new tracks as they become available
    </p>

    <g:link class="label-success" action="showTime" elementId="timeLink">Show the time!</g:link>
    <div id="time">
    </div>

    <script>
        $('#timeLink').click(function() {
            $('#time').load(this.href); return false;
        });
    </script>

</body>
</html>