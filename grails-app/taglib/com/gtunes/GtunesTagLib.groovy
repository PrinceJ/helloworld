package com.gtunes

class GtunesTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "h"

    def repeat = { attr, body ->
        int n = attr.int('times')

        n.times { counter ->
            out << body(counter + 1)
        }
    }
}
