<div id="album${album.id}" class="album" style="display: none;">
    <div class="albumDetails">
        <div class="artistName"> ${artist.name}</div>
        <div class="albumTitle"> ${album.title}</div>
        <div class="albumInfo">
            Genre: ${album.genre ?: "Other"}<br>
            Year: ${album.year}
        </div>
    </div>
    <div class="albumTracks">
        <ol>
            <g:each in="${album.songs}" var="song">
                <li>${song.title}</li>
            </g:each>
        </ol>
    </div>
    <div class="albumLinks">
    </div>
</div>

    <g:javascript>
        $('#album${album.id}').fadeIn('slow');
    </g:javascript>