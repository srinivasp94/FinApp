package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityPersonalInfoBinding

class PersonalInfo_Activity : BaseActivity<ActivityPersonalInfoBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_personal_info
    }

    override fun initialise() {

        val proceed_btn: TextView = findViewById(R.id.proceed_btn);

        val value:String = intent.getStringExtra("tag").toString()

        proceed_btn.setOnClickListener(View.OnClickListener {
            if (value.equals("from_basicinfo")) {
                changeActivity(this, WorkInfo_Activity::class.java, true);
            }else{
                changeActivity(this, SelfEmp_workinfo_Activity::class.java, true);

            }

        })

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })


    }
}