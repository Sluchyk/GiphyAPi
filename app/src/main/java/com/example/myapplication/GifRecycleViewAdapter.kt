package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GifRecycleViewAdapter (
    private val mContext :Context,
    private var mList: MutableList<String>
) : RecyclerView.Adapter<GifRecycleViewAdapter.GifViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): GifViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gif,parent,false)
        return GifViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        Glide.with(mContext)
            .load(mList[position])
            .error(R.drawable.ic_launcher_background)
            .into(holder.imageView)
        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, FullScreen::class.java)
            intent.putExtra("image_url", mList[position])
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class GifViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)

    }

}