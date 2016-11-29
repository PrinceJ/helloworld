<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta name="layout" content="main"/>
    <title>gTunes shop</title>
    <g:javascript library="jquery"/>
</head>
<body>

<div id="top5Panel" class="top5Panel">

    <div id="searchBox">
        <h1>Instant Search</h1>
        <g:textField id="searchField" name="searchField"/>
        <div id="searchResults" name="musicPanel"></div>
    </div>
    <script>
        $("#searchField").keyup(function() {
        $("#searchResults").load("${createLink(action: 'search')}?q="+this.value);
        });
    </script>
    <div class="">
        <ul id="tabs" class="nav navbar clearfix">
            <li class="selected active nav-tabs col-lg-3"><a href="#albums">Latest Albums</a></li>
            <li class="nav-tabs col-lg-4"><a href="#songs">Latest Songs</a></li>
            <li class="nav-tabs col-lg-3"><a href="#artists">Newest Artists</a></li>
        </ul>
    </div>
    <br/>
    <div class="">
        <div id="albums" class="top5Item nav navbar col-lg-3">
            <g:render template="/album/albumList"
                      model="[albums: top5Albums]"></g:render>
        </div>

        <div id="songs" class="top5Item nav navbar col-lg-4">
            <g:render template="/song/songList"
                      model="[songs: top5Songs]"></g:render>
        </div>
        <div id="artists" class="top5Item nav navbar list col-lg-3">
            <g:render template="/artist/artistList"
                      model="[artists: top5Artists]"></g:render>
        </div>
    </div>
</div>

</body>
</html>