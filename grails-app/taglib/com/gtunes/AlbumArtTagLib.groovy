/*package com.gtunes

import grails.plugins.rest.client.RestBuilder
class AlbumArtTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static final DEFAULT_ALBUM_ART_IMAGE =
            "/images/no-album-art.gif"
    static namespace = "music"
    def albumArt = { attrs, body ->
        def artistName = attrs.remove('artist')?.toString()
        def albumTitle = attrs.remove('album')?.toString()
        def width = attrs.int('width', 100)
        attrs.remove('width')
        def albumArt = DEFAULT_ALBUM_ART_IMAGE
        if(artistName && albumTitle) {
            try {
                def restBuilder = new RestBuilder()
                def url = "http://itunes.apple.com/search?term=${albumTitle.encodeAsURL()}&media=music&entity=album&attribute=albumTerm"
                def response = restBuilder.get(url)
                def json = response.json
                // retrieve the list of search results
                                def records = json.results
                // find the record that has the correct
                // artist name and album title, note that
                // the service will return records that are
                // not an exact match
                def matchingRecord = records.find { r ->
                    r.artistName == artistName && r.collectionName == albumTitle
                }
                albumArt = matchingRecord?.artworkUrl100 ?: DEFAULT_ALBUM_ART_IMAGE
            } catch (Exception e) {
                log.error "Problem retrieving artwork: ${e.message}", e
            }
        }
        if(albumArt.startsWith("/")) albumArt = "${request.contextPath}${albumArt}"
        out << "<img width=\"$width\" src=\"${albumArt}\" border=\"0\""
        out << attrs.collect { attributeName, attributeValue ->
            " ${attributeName}=\"${attributeValue.encodeAsHTML()}\""
        }.join(' ')
        out << "></img>"
    }
}
*/