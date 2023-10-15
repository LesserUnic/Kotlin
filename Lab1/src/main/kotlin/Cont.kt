import com.google.gson.annotations.SerializedName

data class Continue(
    val sroffset : Int,
    @SerializedName("continue")
    val cont : String
)
