package app.web.drjackycv.presentation.repos.entity

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import app.web.drjackycv.presentation.R
import app.web.drjackycv.presentation.extension.load
import kotlinx.android.synthetic.main.item_repo.view.*

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: ItemUI) = with(itemView) {
        ViewCompat.setTransitionName(itemRepoAvatarImv, item.id.toString())
        itemRepoAvatarImv.load(item.owner.avatarUrl)
        itemRepoNameTxv.text = item.name
        itemRepoDescriptionTxv.text = item.description
        itemRepoOwnerLoginTxv.text = item.owner.login
        decideItemColor(item.fork, itemRepoContainer)
    }

    private fun decideItemColor(isFork: Boolean, view: View) {
        if (isFork)
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.green))
        else
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.white))
    }

}