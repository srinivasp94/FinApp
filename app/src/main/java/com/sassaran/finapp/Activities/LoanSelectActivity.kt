package com.sassaran.finapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityLoanSelectBinding

class LoanSelectActivity : BaseActivity<ActivityLoanSelectBinding>() {
    override fun layoutRes(): Int {
        return R.layout.activity_loan_select
    }

    override fun initialise() {

        val salary_tv: TextView = findViewById(R.id.salary_tv)
        val selfemp_tv: TextView = findViewById(R.id.selfemp_tv)

        salary_tv.setOnClickListener(View.OnClickListener {

            changeActivity(this, BussLoan_Select_Activity::class.java, true);

        })
        selfemp_tv.setOnClickListener(View.OnClickListener {

            changeActivity(this, PersonalLoan_select_Activity::class.java, true);

        })

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    }