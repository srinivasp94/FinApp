package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivityUploadDocumentBinding

class Salaried_UpDoc_Activity : BaseActivity<ActivityUploadDocumentBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_upload_document
    }

    override fun initialise() {

        binding.submitBtn.setOnClickListener(View.OnClickListener {
        //    changeActivity(this,Home_Activity::class.java,true)
            changeActivity(this,LoanSelectActivity::class.java,false)

        })

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })

    }
}