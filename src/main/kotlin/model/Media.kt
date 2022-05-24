package model

data class Media(
    private val id: Int,
    private val title: String?,
    private val name: String?,
    private val voteAverage: Double?,
    private val overview: String?,
    private val releaseDate: String?,
    private val posterPath: String?,
    private val backdropPath: String?,
    private val popularity: String?
) {


    override fun toString(): String {
        return "id=$id, title=${title?:name}, voteAverage=$voteAverage, overview=$overview, releaseDate=$releaseDate, posterPath=$posterPath, backdropPath=$backdropPath, popularity=$popularity"
    }


}