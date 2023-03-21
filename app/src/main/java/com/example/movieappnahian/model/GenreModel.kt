import com.google.gson.annotations.SerializedName
data class GenreModel(
    @SerializedName("genres")
    val genres: List<Genress>
)

data class Genress(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)