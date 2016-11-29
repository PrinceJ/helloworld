<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta name="layout" content="main"/>
    <title>Genre List</title>
</head>

<body>
    <h1>Online Store</h1>
    <h2>Genre: ${genre.encodeAsHTML()}</h2>
    <table border="0" class="albumsTable">
        <tr>
            <th>Artist</th>
            <th>Album</th>
            <th>Year</th>
        </tr>
        <g:each var="album" in="${albums}">
            <tr>
                <td>${album.artist.name}</td>
                <td><g:link action="show"
                            controller="album"
                            id="${album.id}">${album.title}</g:link>
                </td>
                <td>${album.year}</td>
            </tr>
        </g:each>
    </table>
    <div class="paginateButtons">
        <g:paginate controller="hello"
                action="genre"
                params="[name:genre]"
                total="${totalAlbums}" />
</div>
</body>
</html>
