package app.web.drjackycv.data.repos.entity


import app.web.drjackycv.data.base.ResponseObject
import app.web.drjackycv.domain.repos.entity.Item
import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: OwnerResponse,
    @SerializedName("description") val description: String?,
    @SerializedName("fork") val fork: Boolean
) : ResponseObject<Item> {

    override fun toDomain(): Item =
        Item(
            id = id,
            name = name,
            owner = owner.toDomain(),
            description = description,
            fork = fork
        )

}