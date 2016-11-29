package com.gtunes

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SongController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Song.list(params), model:[songCount: Song.count()]
    }

    def show(Song song) {
        respond song
    }

    def create() {
        respond new Song(params)
    }

    @Transactional
    def save(Song song) {
        if (song == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (song.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond song.errors, view:'create'
            return
        }

        song.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'song.label', default: 'Song'), song.id])
                redirect song
            }
            '*' { respond song, [status: CREATED] }
        }
    }

    def edit(Song song) {
        respond song
    }

    @Transactional
    def update(Song song) {
        if (song == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (song.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond song.errors, view:'edit'
            return
        }

        song.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'song.label', default: 'Song'), song.id])
                redirect song
            }
            '*'{ respond song, [status: OK] }
        }
    }

    @Transactional
    def delete(Song song) {

        if (song == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        song.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'song.label', default: 'Song'), song.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'song.label', default: 'Song'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
