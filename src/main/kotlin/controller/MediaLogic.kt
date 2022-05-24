package controller

import com.google.gson.Gson
import model.Medias
import okhttp3.*
import java.io.IOException

class MediaLogic(apiResult: (Medias?,Exception?) -> Unit) : MediaService {
    private var client: OkHttpClient = OkHttpClient()
    private var request: Request? = null
    var data: Medias? = null
    private var callback: Callback? = null

    init {

        callback = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                apiResult(null,RuntimeException())

            }

            override fun onResponse(call: Call, response: Response) {
                response.body.let{
                    val ss: String = response.body!!.string()
                    data = Gson().fromJson(ss, Medias::class.java)
                    apiResult(data!!,null)

                }
            }
        }
    }

    override fun getAllMovies() {
        request = Request.Builder()
            .url("https://api.themoviedb.org/3/discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
            .build()

        callback?.let { client.newCall(request!!).enqueue(it) }

    }

    override fun getTopRatedMovies() {
        request = Request.Builder()
            .url("https://api.themoviedb.org/3/movie/top_rated?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
            .build()

        callback?.let { client.newCall(request!!).enqueue(it) }
    }


    override fun getAllShows() {
        request = Request.Builder()
            .url("https://api.themoviedb.org/3/tv/popular?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
            .build()

        callback?.let { client.newCall(request!!).enqueue(it) }
    }
}





