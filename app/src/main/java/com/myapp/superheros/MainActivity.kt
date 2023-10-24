package com.myapp.superheros

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myapp.superheros.ui.themeimport.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { SuperHeroTopAppBar() }
    ) {
        HeroScreenList(modifier=Modifier.padding(it))
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge,

                )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SuperHeroTopAppBarPreview() {
    SuperheroesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
        ) {
            SuperHeroTopAppBar()
        }
    }

}
@Preview(showBackground = true)
@Composable
fun SuperHeroAppPreview() {
    SuperheroesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
        ) {
            SuperHeroApp()
        }
    }

}
@Preview("DarkTheme")
@Composable
fun SuperHeroAppDarkPreview() {
    SuperheroesTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
        ) {
            SuperHeroApp()
        }
    }

}