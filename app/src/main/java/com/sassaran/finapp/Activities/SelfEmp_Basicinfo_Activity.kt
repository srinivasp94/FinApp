package com.sassaran.finapp.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivitySfempBasicInfoBinding

class SelfEmp_Basicinfo_Activity : BaseActivity<ActivitySfempBasicInfoBinding>() {


    override fun layoutRes(): Int {
        return R.layout.activity_sfemp_basic_info
    }

    override fun initialise() {

        val proceed_btn: TextView = findViewById(R.id.proceed_btn);

        proceed_btn.setOnClickListener(View.OnClickListener {
         //   changeActivity(this,PersonalInfo_Activity::class.java,true);
            val intent = Intent(this, PersonalInfo_Activity::class.java)
            intent.putExtra("tag", "from_selemp_basicinfo")
            startActivity(intent)

        })

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })


    }
}