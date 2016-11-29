package com.gtunes
class Album {

    String title
    String genre
    Date dateCreated

    static hasMany = [songs:Song]
    static belongsTo = [artist:Artist]

    static constraints = {
        title blank: false
        genre blank: false
        dateCreated blank: false
    }

    String toString() {"title $title genre $genre"}
}
