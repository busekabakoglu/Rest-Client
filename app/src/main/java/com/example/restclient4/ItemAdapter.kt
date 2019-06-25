package com.example.restclient4

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*
import android.os.Bundle
import androidx.navigation.findNavController


class ItemAdapter(val items : ArrayList<User>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.author.text = items.get(position).author // USer a gore adapt etmedin!!!!!!!!!!!!!!!!!
        holder.description.text = items.get(position).description
        holder.author.append("/")
        holder.author.append(items.get(position).name)
        holder.stars.text = items.get(position).stars
        Picasso
            .get() // give it the context
            .load(items.get(position).avatar1) // load the image
            .into(holder.image)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("author",items.get(position).author)
            bundle.putString("description",items.get(position).description)
            bundle.putString("name",items.get(position).name)
            bundle.putString("stars",items.get(position).stars)
            bundle.putString("image",items.get(position).avatar1)
            bundle.putString("forks",items.get(position).forks)
            it.findNavController().navigate(R.id.toDetailedPage,bundle)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    var image = view.findViewById(R.id.image_id) as ImageView
    var description = view.findViewById(R.id.desc_text) as TextView
    var author = view.findViewById(R.id.author_text) as TextView
    var stars = view.findViewById(R.id.star_number) as TextView

}