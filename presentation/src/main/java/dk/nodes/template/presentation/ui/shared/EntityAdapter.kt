package dk.nodes.template.presentation.ui.shared

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dk.nodes.template.domain.entity.DomainEntity
import dk.nodes.template.presentation.extensions.inflate

open class EntityAdapter<E : DomainEntity>(
    @LayoutRes private val layoutRes: Int,
    private val bind: View.(entity: E) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<E>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(layoutRes))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bind(holder.itemView, list[position])
    }

    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    fun setData(list: List<E>) {
        val diff = DiffUtil.calculateDiff(EntityDiff(this.list, list))
        this.list.clear()
        this.list += list
        diff.dispatchUpdatesTo(this)
    }

    private inner class EntityDiff(
        private val oldList: List<E>,
        private val newList: List<E>
    ) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return newList[newItemPosition].id == oldList[oldItemPosition].id
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return newList[newItemPosition] == oldList[oldItemPosition]
        }
    }

    private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}