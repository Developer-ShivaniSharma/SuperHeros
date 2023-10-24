package com.myapp.superheros

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myapp.superheros.model.Hero
import com.myapp.superheros.model.HeroesRepository
import com.myapp.superheros.ui.themeimport.SuperheroesTheme

@Composable
fun HeroScreenList(modifier: Modifier = Modifier) {
    HeroList(
        heroList = HeroesRepository.heroes,
        modifier = modifier
    )
}

@Composable
fun HeroList(heroList: List<Hero>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(heroList) { hero ->
            HeroDetails(hero = hero, modifier = Modifier.padding(8.dp))
        }
    }

}

@Composable
fun HeroDetails(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.clip(RoundedCornerShape(16.dp))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = null,
                alignment = Alignment.TopCenter
            )
        }
    }
}


@Preview("Light Theme")
@Composable
fun HeroDetailsPreview() {
    val heros = Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1)
    SuperheroesTheme {
        HeroDetails(hero = heros)
    }
}

@Preview
@Composable
fun HeroListPreview() {
    SuperheroesTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            HeroList(
                heroList = listOf(
                    Hero(
                        nameRes = R.string.hero1,
                        descriptionRes = R.string.description1,
                        imageRes = R.drawable.android_superhero1
                    ), Hero(
                        nameRes = R.string.hero2,
                        descriptionRes = R.string.description2,
                        imageRes = R.drawable.android_superhero2
                    ), Hero(
                        nameRes = R.string.hero3,
                        descriptionRes = R.string.description3,
                        imageRes = R.drawable.android_superhero3
                    ), Hero(
                        nameRes = R.string.hero4,
                        descriptionRes = R.string.description4,
                        imageRes = R.drawable.android_superhero4
                    ), Hero(
                        nameRes = R.string.hero5,
                        descriptionRes = R.string.description5,
                        imageRes = R.drawable.android_superhero5
                    ), Hero(
                        nameRes = R.string.hero6,
                        descriptionRes = R.string.description6,
                        imageRes = R.drawable.android_superhero6
                    )
                )
            )
        }
    }
}