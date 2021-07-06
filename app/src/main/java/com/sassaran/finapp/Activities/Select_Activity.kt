package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivitySelectBinding

class Select_Activity : BaseActivity<ActivitySelectBinding>() {


    override fun layoutRes(): Int {
        return R.layout.activity_select
    }

    override fun initialise() {

       val salary_tv :TextView = findViewById(R.id.salary_tv)
       val selfemp_tv :TextView = findViewById(R.id.selfemp_tv)

        salary_tv.setOnClickListener(View.OnClickListener {

            changeActivity(this,Basic_infoActivity::class.java,true);

        })
        selfemp_tv.setOnClickListener(View.OnClickListener {

            changeActivity(this,SelfEmp_Basicinfo_Activity::class.java,true);

        })

    }
}