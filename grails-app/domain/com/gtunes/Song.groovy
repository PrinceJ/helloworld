package com.gtunes
class Song {

    String title
    Integer duration

    static belongsTo = [albums:Album]


    static constraints = {
        title blank: false
        duration blank: false
        duration min: 1
    }

//    static belongsTo = [album:Album]

    String toString() {"$title"}
}
