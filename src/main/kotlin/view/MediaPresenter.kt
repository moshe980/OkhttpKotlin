package view

import controller.MediaLogic
import controller.MediaService
import model.Media

class MediaPresenter {
    private var mediaLogic: MediaService? = null

    init {
        mediaLogic = MediaLogic { result,e ->
            run {
                result?.getResults()?.forEachIndexed(::print) ?:println(e)
            }
        }

    }

     fun  presentMedia() {
        mediaLogic?.getAllMovies()


    }

    private fun print(i:Int,media:Media)
    {
        println("${i+1}. $media")
    }
}