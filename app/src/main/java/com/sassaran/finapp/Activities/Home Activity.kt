package com.sassaran.finapp.Activities

import android.content.Intent
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.navigation.NavigationView
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.base.GlobalRecyclerAdapter
import com.sassaran.finapp.databinding.ActivityHomeScreenBinding
import com.sassaran.finapp.databinding.HomeScreenItemBinding


class Home_Activity : BaseActivity<ActivityHomeScreenBinding>() {


    val textnames = ArrayList<String>()

    val images = ArrayList<Int>()

    override fun layoutRes(): Int {
        return R.layout.activity_home_screen
    }

    override fun initialise() {

        val mDrawerLayout: DrawerLayout  =  findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.navigationView)



       binding.imgMenuIcon.setOnClickListener(object : View.OnClickListener {

           override fun onClick(v: View?) {


               if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {

                   mDrawerLayout.closeDrawer(GravityCompat.START)

               } else {
                   mDrawerLayout.openDrawer(GravityCompat.START)
               }
           }

       })

        navigationView.setNavigationItemSelectedListener(this)

        textnames.add("Sign-Out ")
        textnames.add("Apply Now ")
        textnames.add("Application status ")
        textnames.add("Pay your EMIs and Dues ")
        textnames.add("Customer Service ")
        textnames.add("Locate Branches")

        images.add(R.drawable.signout)
        images.add(R.drawable.apply1)
        images.add(R.drawable.application_status)
        images.add(R.drawable.credit_card)
        images.add(R.drawable.customerservice)
        images.add(R.drawable.location)


        val manage = GridLayoutManager(this, 3);
        binding.rvDummyText.layoutManager = manage

        val dummyitemAdapter: GlobalRecyclerAdapter<*, *> =
            object : GlobalRecyclerAdapter<String, HomeScreenItemBinding>(textnames) {
                override fun getLayoutId(): Int {
                    return R.layout.home_screen_item;
                }

                override fun onBinder(
                    model: String,
                    viewbinding: HomeScreenItemBinding,
                    position: Int
                ) {

                    viewbinding.gridTxtview.text = model;
//                viewbinding.gridImgview.text = images.get(position);
                    viewbinding.layoutRoot.setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {

                            if (position == 0) {

                            } else if (position == 1) {
                                val intent = Intent(this@Home_Activity, Select_Activity::class.java)
                                intent.putExtra("tag", "from_homeact")
                                startActivity(intent)

                            } else if (position == 2) {

                            } else if (position == 3) {

                                changeActivity(this@Home_Activity, AmtEntry_Activity::class.java, false)

                            } else if (position == 4) {

                            } else if (position == 5) {
                                changeActivity(this@Home_Activity, Addresses_Activity::class.java, false)
                            }
                        }

                    })
                }

            }

        binding.rvDummyText.adapter = dummyitemAdapter


    }


}

private fun NavigationView.setNavigationItemSelectedListener(homeActivity: Home_Activity) {


}
