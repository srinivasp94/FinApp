package com.sassaran.finapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivitySelfEmpWorkinfoBinding

class SelfEmp_workinfo_Activity : BaseActivity<ActivitySelfEmpWorkinfoBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_self_emp_workinfo
    }

    override fun initialise() {

        val proceed_btn: TextView = findViewById(R.id.proceed_btn);

        proceed_btn.setOnClickListener(View.OnClickListener {
            changeActivity(this,SelfEmp_UpDoc_Acitvity::class.java,true);

        })

    }
}