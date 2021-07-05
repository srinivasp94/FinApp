package com.sassaran.finapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.base.GlobalRecyclerAdapter
import com.sassaran.finapp.databinding.ActivityHomeScreenBinding
import com.sassaran.finapp.databinding.DummyRecyclerItemBinding

class Home_Activity : BaseActivity<ActivityHomeScreenBinding>() {



    val textnames = ArrayList<String>()
    val images = ArrayList<Int>()

    override fun layoutRes(): Int {
        return R.layout.activity_home_screen
    }

    override fun initialise() {

        textnames.add("Hi ")
        textnames.add("Hello ")
        textnames.add("How ")
        textnames.add("are ")
        textnames.add("you ")
        textnames.add("..? ")

        var dummyitemAdapter : GlobalRecyclerAdapter<*,*>  = object :  GlobalRecyclerAdapter<String,DummyRecyclerItemBinding>(textnames){
            override fun getLayoutId(): Int {
                return R.layout.dummy_recycler_item;
            }

            override fun onBinder(model: String, viewbinding: DummyRecyclerItemBinding, position: Int) {
                viewbinding.txtDummyItem.text = model;
            }

        }

        binding.rvDummyText.adapter = dummyitemAdapter


    }


}