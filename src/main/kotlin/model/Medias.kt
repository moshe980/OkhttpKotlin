package model

data class Medias(
    private val page: Float,
    private val results: MutableList<Media>,
    private val total_pages: Float,
    private val total_results: Float
) {

    fun getResults(): MutableList<Media> {
        return this.results
    }


}



