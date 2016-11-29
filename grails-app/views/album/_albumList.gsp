<ul class="list">
    <g:each in="${albums}" var="album">
        <li>
            <g:link update="musicPanel"
                controller="album"
                action="display"
                id="${album.id}"
                elementId="albumLink${album.id}">${album.title}
            </g:link>
        </li>

        <script>
            $('#albumLink${album.id}').click(function () {
                $('#musicPanel').load(this.href);
                return false;
            })
        </script>
    </g:each>
</ul>