package com.example.YTBoxing.data

import com.example.YTBoxing.R
import com.example.YTBoxing.model.Affirmation

class Datasource() {

    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(

            Affirmation(R.string.boxer01, R.drawable.pic_ksi,R.string.score01),
            Affirmation(R.string.boxer03, R.drawable.pic_salt_papi,R.string.score02),
            Affirmation(R.string.boxer02, R.drawable.pic_jake_paul,R.string.score03),
            Affirmation(R.string.boxer04, R.drawable.pic_deji,R.string.score04),
            Affirmation(R.string.boxer05, R.drawable.pic_tommy_fury,R.string.score05),
            Affirmation(R.string.boxer06, R.drawable.pic_slim_albaher,R.string.score06),
        )

    }
}