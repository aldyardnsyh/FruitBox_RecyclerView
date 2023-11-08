package com.example.fruitbox_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class FruitAdapter (private val fruitList : ArrayList<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fruit,
            parent, false)
        return ItemFruitViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        val currenItem = fruitList[position]
        holder.titleImage.setImageResource(currenItem.titleImage)
        holder.tvHeading.text = currenItem.heading
        holder.tvDescription.text = currenItem.description
        holder.tvFunction.text = currenItem.function
    }

    class ItemFruitViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading : TextView = itemView.findViewById(R.id.tv_heading)
        val tvDescription : TextView = itemView.findViewById(R.id.tv_description)
        val tvFunction : TextView = itemView.findViewById(R.id.tv_function)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}