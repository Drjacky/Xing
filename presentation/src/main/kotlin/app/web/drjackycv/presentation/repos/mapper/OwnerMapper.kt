package app.web.drjackycv.presentation.repos.mapper

import app.web.drjackycv.domain.repos.entity.Owner
import app.web.drjackycv.presentation.base.mapper.MapperUI
import app.web.drjackycv.presentation.repos.entity.OwnerUI

class OwnerMapper : MapperUI<Owner, OwnerUI> {

    override fun mapToUI(obj: Owner): OwnerUI = with(obj) {
        OwnerUI(
            login = login,
            avatarUrl = avatarUrl
        )
    }

}