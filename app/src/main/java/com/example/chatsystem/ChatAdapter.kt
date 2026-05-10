package com.example.chatsystem
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ChatAdapter(
    private val context: Context,
    private val list: List<ChatBean>
) : BaseAdapter() {

    // ViewHolder
    inner class ViewHolder {
        lateinit var ivAvatar: ImageView
        lateinit var tvName: TextView
        lateinit var tvMsg: TextView
        lateinit var tvTime: TextView
    }

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false)
            holder = ViewHolder()
            holder.ivAvatar = view.findViewById(R.id.iv_avatar)
            holder.tvName = view.findViewById(R.id.tv_name)
            holder.tvMsg = view.findViewById(R.id.tv_msg)
            holder.tvTime = view.findViewById(R.id.tv_time)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        // 赋值数据
        val bean = list[position]
        holder.tvName.text = bean.name
        holder.tvMsg.text = bean.lastMsg
        holder.tvTime.text = bean.time

        return view
    }
}