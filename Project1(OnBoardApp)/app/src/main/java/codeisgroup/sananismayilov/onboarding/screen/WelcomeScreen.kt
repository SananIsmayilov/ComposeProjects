package codeisgroup.sananismayilov.onboarding.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import codeisgroup.sananismayilov.onboarding.R
import codeisgroup.sananismayilov.onboarding.navigation.Screen
import codeisgroup.sananismayilov.onboarding.util.OnBoardingPage
import codeisgroup.sananismayilov.onboarding.viewmodel.WelcomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(navController: NavHostController, viewmodel: WelcomeViewModel = hiltViewModel()) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerstate = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        HorizontalPager(
            count = 3,
            state = pagerstate,
            modifier = Modifier
                .weight(10f)
                .scrollable(
                    orientation = Orientation.Vertical,
                    enabled = true,
                    state = rememberScrollState()
                ),
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            pagerState = pagerstate,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
        )
        finishButton(pagerState = pagerstate) {
            println("-----finish button")
            // save data store and navigate by popstack
            viewmodel.putCompletedOnBoardShowing(true)
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
        }


    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "1",
            modifier = Modifier
                .size(150.dp)

        )

        Text(
            text = onBoardingPage.title, modifier = Modifier
                .align(Alignment.CenterHorizontally), fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = onBoardingPage.description, modifier = Modifier
                .align(Alignment.CenterHorizontally), fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )


    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun finishButton(
    pagerState: PagerState,
    onclick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(top = 10.dp, start = 40.dp, end = 40.dp, bottom = 20.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = pagerState.currentPage == 2,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = onclick, colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prewiew() {
    WelcomeScreen(rememberNavController())
}