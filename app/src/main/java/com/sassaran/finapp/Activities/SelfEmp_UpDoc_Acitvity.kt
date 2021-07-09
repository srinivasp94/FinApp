package com.sassaran.finapp.Activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sassaran.finapp.R
import com.sassaran.finapp.base.BaseActivity
import com.sassaran.finapp.databinding.ActivitySfempUploadDocumentBinding

class SelfEmp_UpDoc_Acitvity : BaseActivity<ActivitySfempUploadDocumentBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_sfemp_upload_document
    }

    override fun initialise() {

        binding.submitBtn.setOnClickListener(View.OnClickListener {
            changeActivity(this,Home_Activity::class.java,true)
        })

        binding.rootHeader.backarrowimg.setOnClickListener(View.OnClickListener {
            finish()
        })

    }

}