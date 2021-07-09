package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityWorkInfoBinding

class WorkInfo_Activity : BaseActivity<ActivityWorkInfoBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_work_info
    }

    override fun initialise() {

        val proceed_btn:TextView = findViewById(R.id.proceed_btn);

        proceed_btn.setOnClickListener(View.OnClickListener {
            changeActivity(this,Salaried_UpDoc_Activity::class.java,true);

        })
        

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

}