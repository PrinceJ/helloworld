<header id="header" class="card-panel">
    <h1 id="logo" class="text-center center-block card-title">
        <a href="${createLink(uri: '/')}" class="text-primary">gTune Stores</a>
    </h1>
    <g:if test="${session?.user}">
        <div id="quickaccess" class="text-center">
            <a href="#" class="text-center text-success">${session?.user?.firstName}</a>,
            <g:link class="text-success" controller="user" action="logout">Logout</g:link>
        </div>
        <nav id="navigation" class="clearfix nav-wrapper">
            <ul>
                <li>
                    <g:link controller="user" action="music">
                        MyMusic |
                    </g:link>
                </li>
                <li><g:link controller="hello" action="shop">The Store |</g:link></li>
                <li><g:link controller="hello" action="index">Home</g:link></li>
            </ul>
        </nav>
    </g:if>
</header>

<div id="message notice" class="card-panel">
    <div style="margin-top:20px">
        Welcome back
        <span id="userFirstName">${session?.user?.firstName}!</span>
        <br><br>
        You have purchased
        (${session.user.purchasedSongs?.size() ?: 0}) songs.
        <br>
    </div>
</div>