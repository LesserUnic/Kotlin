import com.google.gson.annotations.SerializedName

data class JSON(
    val batchcomplete : String,
    @SerializedName("continue")
    val Continue: Continue,
    val query: Query
)
