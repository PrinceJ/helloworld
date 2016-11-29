<ul class="list">
    <g:each in="${artists?}" var="artist">
        <li class="icon">
            <g:link class="nav-pills" controller="artist" action="show" id="${artist?.id}">
                <g:img dir="images/icons" file="artist.png" />
                ${artist?.name}
            </g:link>
        </li>
    </g:each>
</ul>