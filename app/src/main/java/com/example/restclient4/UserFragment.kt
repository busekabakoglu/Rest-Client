package com.example.restclient4

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_fragment.*

class UserFragment(): Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.user_fragment,
            container, false)

        //var name = view.findViewById(R.id.name_text) as TextView
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stars_text.append(arguments?.getString("stars"))
        author_text.text = arguments?.getString("author")
        author_text.append("/")
        author_text.append(arguments?.getString("name"))
        desc_text.text = arguments?.getString("description")
        forks_text.append(arguments?.getString("forks"))
        Picasso
            .get() // give it the context
            .load(arguments?.getString("image")) // load the image
            .into(user_image)
    }
}