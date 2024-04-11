package codeisgroup.sananismayilov.onboarding.util

import androidx.annotation.DrawableRes
import codeisgroup.sananismayilov.onboarding.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {

    object First : OnBoardingPage(R.drawable.facebook, "Facebook", "Hello Facebook")
    object Second : OnBoardingPage(R.drawable.instagram, "Instagram", "Hello Instagram")
    object Third : OnBoardingPage(R.drawable.whats_app, "Whatsapp", "Hello Whatsapp")


}