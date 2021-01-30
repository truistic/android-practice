package cn.truistic.android.practice.common.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.truistic.android.practice.R

class MenuAdapter(
    private val menus: MutableList<Menu>,
    private val menuItemClickListener: OnMenuItemClickListener,
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_common_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.nameTv.text = menus[position].name
        holder.itemView.setOnClickListener {
            menuItemClickListener.onMenuClick(menus[position])
        }
    }

    override fun getItemCount() = menus.size

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv: TextView = itemView.findViewById(R.id.name_tv)
    }
}
