package helloworld

import com.gtunes.Album
import com.gtunes.Artist
import com.gtunes.Song
import grails.gorm.DetachedCriteria

class HelloController {

    static defaultAction = "index"

    def showTime() {
        render  "The time is ${new Date()}"
    }

    def index() {
     }

    def shop() {
        def genreList =
                new DetachedCriteria(Album).distinct('genre').list()
        [top5Albums: Album.list(max:5, sort:"dateCreated", order:"desc"),
         top5Songs:Song.list(max:5, sort:"title", order:"desc"),
         top5Artists: Artist.list(max:5, sort:"name", order:"desc"),
         genres: genreList.sort()]
    }

    def genre() {
        def max = Math.min(params.int('max') ?: 10, 100)
        def offset = params.int('offset') ?: 0
        def total = Album.countByGenre(params.name)
        def albumList = Album.withCriteria {
            eq 'genre', params.name
            projections {
                artist {
                    order 'name'
                }
            }
            maxResults max
            firstResult offset
        }
        return [albums:albumList,
                totalAlbums:total,
                genre:params.name]
    }
}
