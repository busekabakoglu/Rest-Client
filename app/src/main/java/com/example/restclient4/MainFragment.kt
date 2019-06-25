package com.example.restclient4

import android.content.ClipData
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class MainFragment : Fragment() {
    var userList: ArrayList<User> = ArrayList<User>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_main, container, false)
// we do the navigation here
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("MainFragment","inside onViewCreated")
        val urecyclerView = getView()?.findViewById(R.id.recyclerView) as RecyclerView
        urecyclerView.apply {

            urecyclerView.layoutManager = LinearLayoutManager(activity)
            urecyclerView.adapter = ItemAdapter(userList,context)
            Log.i("MainFragment","layout manager is set")
            var apiinterface : APISerivce = RetrofitClient().getClient().create(APISerivce::class.java)
            apiinterface.getUsers().enqueue(object:retrofit2.Callback<List<User>>{
                override fun onFailure(p0: Call<List<User>>?, p1: Throwable?) {
                    Log.i("MainFragment","inside onFailure")
                }

                override fun onResponse(p0: Call<List<User>>?, response: Response<List<User>>?) {
                    Log.i("MainFragment", userList.joinToString { userList[0].author })
                    Log.i("MainFragment","inside onResponse")
                    if (response != null) {
                        userList = ArrayList(response.body()!!)
                    }
                    urecyclerView.adapter = ItemAdapter(userList,context)
                    adapter!!.notifyDataSetChanged()

                }


            })
        }
    }
}

