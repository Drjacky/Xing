package app.web.drjackycv.data.repos.entity


import app.web.drjackycv.data.base.ResponseObject
import app.web.drjackycv.domain.repos.entity.Owner
import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
) : ResponseObject<Owner> {

    override fun toDomain(): Owner =
        Owner(
            login = login,
            avatarUrl = avatarUrl
        )

}